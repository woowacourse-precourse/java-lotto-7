package lotto.io;

public enum OutputHandler {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_LOTTERY_STAT("당첨 통계\n---");

    private OutputHandler(String message) {
    }

    public static void promptPurchasedQuantity(int quantity){
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void promptTotalYield(double yield){
        System.out.println("총 수익률은 " + yield + "입니다.");
    }
}
