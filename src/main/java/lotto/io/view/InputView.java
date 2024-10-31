package lotto.io.view;

public class InputView {
    private static final InputView INSTANCE = new InputView();

    public static InputView getInstance() {
        return INSTANCE;
    }

    public void showMoneyInputExplanation() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showWinningNumberExplanation() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void showBonusNumberExplanation() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
