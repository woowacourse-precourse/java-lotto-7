package lotto;

import java.util.ArrayList;

public class Printer {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        System.out.println(Constants.FORM_ERROR_MESSAGE + message);
    }

    public static void printIssueResult(Lotto ticket) {
        System.out.println(makeIssueResultMessage(ticket));
    }

    private static String makeIssueResultMessage(Lotto ticket) {
        ArrayList<Integer> numbers = ticket.getNumbersArrayList();

        String message = "[";
        for (int i = 0; i < 6; i++) {
            message += numbers.get(i);
            if (i != 5) {
                message += ", ";
            }
        }
        message += "]";

        return message;
    }
}