package lotto.view;

public class OutputView {
    private OutputView() {
    }

    public static void printRequestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void printRequestLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printRequestLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
