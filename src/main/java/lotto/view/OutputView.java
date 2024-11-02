package lotto.view;

import lotto.domain.Lottos;

public class OutputView {
    private static final String INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_MESSAGE = "%d개를 구입했습니다.";
    private static final String INPUT_LOTTO_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    public void printLottoPurchaseAmountMessage() {
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(String.format(PURCHASE_LOTTO_MESSAGE, lottos.getLottos().size()));
        lottos.getLottos().forEach(System.out::println);
    }

    public void printInputLottoWinningNumbersMessage() {
        System.out.println(INPUT_LOTTO_WINNING_NUMBERS);
    }
}
