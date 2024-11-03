package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {

    private static final String purchaseAmountMessage = "구입금액을 입력해 주세요.";
    private static final String winningNumbersMessage = "당첨 번호를 입력해 주세요.";
    private static final String bonusNumberMessage = "보너스 번호를 입력해 주세요.";
    private static final String lottoCountMessage = "%d개를 구매했습니다.\n";


    private OutputView() {
    }

    public static void printInputPurchaseAmountMessage() {
        System.out.println(purchaseAmountMessage);
    }

    public static void printInputWinningNumbers() {
        System.out.println(winningNumbersMessage);
    }

    public static void printInputBonusNumber() {
        System.out.println(bonusNumberMessage);
    }

    public static void printLottoCountMessage(int lottoCount) {
        System.out.printf(lottoCountMessage, lottoCount);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }
}
