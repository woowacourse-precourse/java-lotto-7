package lotto.handler;

public class PrintHandler {
    private static final String PRINT_BUY_MONEY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PRINT_WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String PRINT_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public void printBuyMoneyAmount() {
        System.out.println(PRINT_BUY_MONEY_AMOUNT);
    }

    public void printBuyLottoNumbersOfPurchases(int numberOfPurchases) {
        System.out.println(numberOfPurchases + "개를 구매했습니다.");
    }

    public void printWinningNumbersPrompt() {
        System.out.println(PRINT_WINNING_NUMBERS_PROMPT);
    }

    public void printBonusNumberPrompt() {
        System.out.println(PRINT_BONUS_NUMBER_PROMPT);
    }
}
