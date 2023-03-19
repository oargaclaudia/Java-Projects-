package run;

import container.Strategy;

public class Main {
    public static void main(String[] args) {

        String strategy= args[0].toUpperCase();

        Strategy s;
        s= switch (strategy){
            case "LIFO"-> Strategy.LIFO;
            case "FIFO"-> Strategy.FIFO;
            default -> null;
        };
        TestRunner.run(s);
    }

}
