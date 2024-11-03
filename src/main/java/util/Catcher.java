package util;

public class Catcher {
    public static void repeat(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            repeat(runnable);
        }
    }

}
