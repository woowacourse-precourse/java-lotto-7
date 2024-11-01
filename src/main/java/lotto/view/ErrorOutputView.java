package lotto.view;

public class ErrorOutputView {
    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
