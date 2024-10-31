package lotto;

public class OutputView {
    public static final String LOTTO_AMOUNT_PROMPT = "구입 금액을 입력해 주세요.";
    public static final String LOTTO_WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    public static final String LOTTO_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public void printLottoAmountPrompt() {
        System.out.println(LOTTO_AMOUNT_PROMPT);
    }

    public void printLottoWinningNumberPrompt() { System.out.println(LOTTO_WINNING_NUMBER_PROMPT); }

    public void printLottoBonusNumberPrompt() { System.out.println(LOTTO_BONUS_NUMBER_PROMPT); }
}
