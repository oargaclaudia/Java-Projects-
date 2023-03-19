package org.example;

import org.example.domain.Bursa;
import org.example.repo.Repository;
import org.example.repo.ServiceManager;
import org.example.service.Service;
import org.example.ui.UserInterface;

public class Main {
    public static void main(String[] args) {

        Repository<Long, Bursa> repoDBUtilizator = new ServiceManager("jdbc:postgresql://localhost:5432/entitate","postgres","smiley10");

        Service srv = new Service(repoDBUtilizator);

        UserInterface ui = new UserInterface(srv);

        ui.runInterface();
    }
}