package run;

import container.Strategy;
import model.MessageTask;
import model.Task;
import runner.DelayTaskRunner;
import runner.PrinterTaskRunner;
import runner.StrategyTaskRunner;

import java.time.LocalDateTime;

public class TestRunner {
    public static MessageTask[] getMessages()
    {MessageTask task1= new MessageTask("1", "Cerinta exercitiu ", "Sa se rezolve ecuatiile date ", "Ana", "Maria", LocalDateTime.now());
     MessageTask task2= new MessageTask("2", "Tema laborator ", "Sa se scrie un program care calculeaza suma cifrelor pare ", "Cristina ", "Claudia ", LocalDateTime.now());
     MessageTask task3= new MessageTask("3", "Nota laborator ", "8 ", "Radu ", "Mihai ", LocalDateTime.now());
     MessageTask task4= new MessageTask("4", "Activitate seminar ", "Creati o clasa cu atributele date ", "Radu" ,"Cristi ", LocalDateTime.now());
     MessageTask task5= new MessageTask("5", "Nota seminar ", "10", "Cristina", "Raul", LocalDateTime.now());
    return new MessageTask[]{
            task1,task2,task3,task4,task5
    };
    }
    public static void test1()
    {System.out.println("Test pentru MessageTask ");
    MessageTask[] mesaje = getMessages();
    for (MessageTask m:mesaje)
        m.execute();
    }
    public static void test2(Strategy strategy)
    {System.out.println("Test pentru Strategy Task: ");
     MessageTask[] ms=getMessages();
        StrategyTaskRunner runner= new StrategyTaskRunner(strategy);
     for (Task t:ms)
         runner.addTask(t);
     runner.executeAll();

    }
    public static void test3(Strategy strategy)
    {System.out.println("Strategy and Printer test:");
        MessageTask[] m= getMessages();
        StrategyTaskRunner runner= new StrategyTaskRunner(strategy);
        runner.PrinterTaskRunner printer= new PrinterTaskRunner(runner);
        for(Task t: m){
            runner.addTask(t);
        }
        System.out.println("Run with Strategy");
        runner.executeAll();
        for(Task t: m){
            printer.addTask(t);
        }
        System.out.println("Run with Printer");
        printer.executeAll();

    }
    public static void test4(Strategy strategy)
    { System.out.println("Strategy, Printer and Delay test:");
        MessageTask[] m= getMessages();
        StrategyTaskRunner runner= new StrategyTaskRunner(strategy);
        PrinterTaskRunner printer= new PrinterTaskRunner(runner);
        DelayTaskRunner delay= new DelayTaskRunner(runner);
        for(Task t: m){
            runner.addTask(t);
        }
        System.out.println("Run with Strategy: ");
        runner.executeAll();
        for(Task t: m){
            printer.addTask(t);
        }
        System.out.println("Run with Printer: ");
        printer.executeAll();
        for(Task t: m){
            delay.addTask(t);
        }
        System.out.println("Run with delay: ");
        delay.executeAll();

    }

    public static void run( Strategy strategy)
    {test1();
    test2(strategy);
    test3(strategy);
    test4(strategy);
    }
}
