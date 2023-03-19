package org.example.service;

import org.example.domain.Bursa;
import org.example.repo.Repository;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Service {

    /**
     * Creeaza o instanta de repository in database pe serverul local
     */
    Repository<Long, Bursa> repoUtilizator;

    public Service(Repository<Long, Bursa> repoUtilizator) {
        this.repoUtilizator = repoUtilizator;
    }


    public List<Bursa> getAllAsList() {
        Iterable<Bursa> iterable = repoUtilizator.getAll();
        List<Bursa> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    public List<Bursa> filtrareBursa() {
        List<Bursa> list = getAllAsList();
        return list
                .stream()
                .filter(s -> s.getNume().equals("Andronescu") && s.getPrenume().equals("Ilinca"))
                .collect(Collectors.toList());
    }

    public List<Bursa> filtrareBursaSociala() {
        List<Bursa> list = getAllAsList();
        return list
                .stream()
                .filter(s -> s.getTip().equals("sociala"))
                .collect(Collectors.toList());
    }

    public List<Bursa> filtrareSuma() {
        List<Bursa> list = getAllAsList();
        return list
                .stream()
                .filter(s -> s.getTip().equals("sociala") && s.getSuma() > 400)
                .collect(Collectors.toList());
    }

    public List<Bursa> sortareNumePrenume() {
        List<Bursa> list = getAllAsList();
//        return  list
//                .stream()
//                .sorted(Comparator.comparing(Produs::getNume))
//                .sorted(Comparator.comparing(Produs::getCategorie)
//                        .reversed())
//                .collect(Collectors.toList());


        Comparator<Bursa> comparatorNume=Comparator.comparing(Bursa::getNume);
        Comparator<Bursa> comparatorPrenume=Comparator.comparing(Bursa::getPrenume);
        Comparator<Bursa> comparator = comparatorNume.thenComparing(comparatorPrenume);




        list.stream().sorted(comparator)
                .toList()
                .stream().map(a->a.getId() + " " + a.getNume() +" "+  a.getPrenume() )
                .forEach(System.out::println);
        return list;
    }

    public List<Bursa> sortareTip() {
        List<Bursa> list = getAllAsList();
//        return list
//                .stream()
//                .sorted(Comparator.comparing(Produs::getDescriere).reversed())
//                .collect(Collectors.toList());

        list.stream().sorted(Comparator.comparing(Bursa::getTip).reversed()).toList()
                .stream().map(a->a.getNume() + " " + a.getPrenume() +" "+  a.getTip())
                .forEach(System.out::println);
        return list;
    }

    public List<Bursa> sortareSuma() {
//        List<Produs> list = getAllAsList();
//         return list
//                .stream()
//                .sorted(Comparator.comparingDouble(Produs::getPret))
//                .collect(Collectors.toList());
        List<Bursa> list = getAllAsList();
        list.stream().sorted(Comparator.comparingDouble(Bursa::getSuma)).toList()
                .stream().map(a->a.getId()+ " "+ a.getSuma())
                .forEach(System.out::println);
        return list;
    }
}

