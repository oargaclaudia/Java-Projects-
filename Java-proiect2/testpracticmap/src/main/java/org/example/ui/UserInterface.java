package org.example.ui;

import org.example.service.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {

    protected Service utilizatorService;

    /**
     * Creeaza o instanta de interfata cu utilizatorul
     * @param utilizatorService -service-ul pentru utilizatori
     */
    public UserInterface(Service utilizatorService) {
        this.utilizatorService = utilizatorService;
    }

    public void printMenu() {
        System.out.println("    1. Afisare burse. ");
        System.out.println("    2. Cautarea bursei pentru Andronescu Ilinca. ");
        System.out.println("    3. Filtrare burse sociale. ");
        System.out.println("    4. Filtrare burse sociale cu suma mai mare de 400.");
        System.out.println("    5. Sortare dupa nume si prenume, crescator.");
        System.out.println("    6. Sortare dupa tip, descrescator.");
        System.out.println("    7. Sortare dupa suma, crescator.");
        System.out.println("\nx << Iesire");
    }


    public void handleOption(String option) {
        switch (option) {
            case "1" -> {
                System.out.println("\nBurse:");
                utilizatorService.getAllAsList().forEach(System.out::println);
            }
            case "2" -> {
                System.out.println("\nBursa cautata in lista:");
                utilizatorService.filtrareBursa().forEach(System.out::println);
            }
            case "3" -> {
                System.out.println("\nBurse filtrate:");
                utilizatorService.filtrareBursaSociala().forEach(System.out::println);
            }

            case "4" -> {
                System.out.println("\nBurse filtrate:");
                utilizatorService.filtrareSuma().forEach(System.out::println);
            }

            case "5" -> {
                System.out.println("\nBurse sortate:");
                utilizatorService.sortareNumePrenume();
            }
            case "6" -> {
                System.out.println("\nBurse sortate:");
                utilizatorService.sortareTip();
            }
            case "7" -> {
                System.out.println("\nBurse sortate:");
                utilizatorService.sortareSuma();
            }
            default -> System.out.println("\nOptiunea nu a fost gasita!");
        }
    }

    /**
     * Ruleaza interfata cu utilizatorul in consola
     */
    public void runInterface() {
        while(true) {
            try {
                printMenu();
                System.out.println("\nIntroduceti optiunea dorita: ");
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                String line = input.readLine();
                String option = line.strip().split(" ")[0];

                if(option.equals("x"))
                    return;
                else handleOption(option);
            }
            catch (IOException ie) {
                System.out.println("\nEroare:\n");
                ie.printStackTrace();
                System.out.println("---> reincercati!");
            }

        }
    }
}

