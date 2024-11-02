package lotto.view;

public class OutputView {
    private static final String ERROR = "[ERROR] ";

    public static void errorPrint(String errorMessage) {
        System.out.println(ERROR + errorMessage);
    }

    public static void printPrompt(String string) {
        System.out.println(string);
    }
    public static void printTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + OutputViewEnum.PURCHASE_COUNT_MESSAGE.getMessage());
        for (Lotto lotto : tickets) {
            printLotto(lotto);
        }
    }
}
