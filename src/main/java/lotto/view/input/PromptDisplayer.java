package lotto.view.input;

public class PromptDisplayer {
    private static final String PURCHASE_PRICE_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String WINNING_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public void showPurchasePrompt() {
        System.out.println(PURCHASE_PRICE_PROMPT);
    }

    public void showLottoNumberPrompt() {
        System.out.println(WINNING_LOTTO_NUMBER_PROMPT);
    }

    public void showBonusNumberPrompt() {
        System.out.println(WINNING_BONUS_NUMBER_PROMPT);
    }
}
