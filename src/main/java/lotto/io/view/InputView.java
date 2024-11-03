package lotto.io.view;

public class InputView {
    private static final InputView INSTANCE = new InputView();

    public static InputView getInstance() {
        return INSTANCE;
    }

    public void showMoneyInputExplanation() {
        System.out.print("구입금액을 입력해 주세요.\n");
    }

    public void requestWinLottoExplanation() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void showBonusNumberExplanation() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }
}
