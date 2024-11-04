package lotto.view;

public class OutputView {

    private static final PrintMessage message = new PrintMessage();

    public static void getBuyCountMessage(int createLotto) {
        System.out.println(createLotto + "개를 구매했습니다.");
    }

    public static void getResultPrintMessage() {
        message.getResultPrintMessage();
    }
    public static void printResultProfit(double totalPrize) {
        System.out.printf("총 수익률은 %.1f%%입니다.",totalPrize);
    }
}