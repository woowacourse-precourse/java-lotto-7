package lotto.view;

public class OutputView {

    public static void printError(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
