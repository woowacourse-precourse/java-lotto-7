package lotto.view;

public class InputView {
    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String PLACE_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void printPurchase() {
        System.out.println(PURCHASE_MESSAGE);
    }

    public void printPurchaseCount(int count) {
        System.out.println();
        System.out.printf((PURCHASE_COUNT_MESSAGE) + "%n", count);
    }

    public void printPlaceNumber() {
        System.out.println();
        System.out.println(PLACE_NUMBER_MESSAGE);
    }

    public void printBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
}
