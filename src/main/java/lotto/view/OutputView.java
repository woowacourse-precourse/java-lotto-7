package lotto.view;

public class OutputView {

    private static final String NUMBER_OF_PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    public static void printNumberOfPurchases(int number) {
        System.out.println(String.format(NUMBER_OF_PURCHASE_MESSAGE, number));
    }
}
