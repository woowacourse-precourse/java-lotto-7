package lotto;

import lotto.controller.MainController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MainController controller = new MainController();

        long startTime = System.nanoTime();
        controller.run();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Execution time: " + duration + " nanoseconds");
        System.out.println("Execution time: " + (duration / 1_000_000) + " milliseconds");
    }
    
}
