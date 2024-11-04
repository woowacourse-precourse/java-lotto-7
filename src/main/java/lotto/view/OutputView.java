package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottosDto;

public class OutputView {
    private OutputView() {
    }

    public static void printPurchaseAmountInputMessage() {
        printMessage("구입금액을 입력해 주세요.");
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        printMessage(message);
    }

    public static void printPurchasedLottos(LottosDto lottosDto) {
        printErrorMessage("구입한 로또 번호:");
        for (LottoDto lotto : lottosDto.lottos()) {
            System.out.println(lotto.numbers());
        }
    }

    public static void printWinningNumberInputMessage() {
        printMessage("당첨 번호를 입력해 주세요.");
    }
}
