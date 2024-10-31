package lotto;

public class Printer {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        System.out.println(Constants.FORM_ERROR_MESSAGE + message);
    }
}