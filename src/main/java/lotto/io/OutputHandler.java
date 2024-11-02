package lotto.io;

import lotto.domain.Lottos;

public class OutputHandler {

    private static final String PRICE_INPUT_NAVIGATE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_MESSAGE_TEMPLATE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_NAVIGATE = "당첨 번호를 입력해 주세요.";

    public void showPriceInputNavigateMessage() {
        System.out.println(PRICE_INPUT_NAVIGATE);
    }

    public void showPurchasedLottos(Lottos lottos) {
        showNewLine();
        showLottoCountMessage(lottos);
        showEachLottoNumbers(lottos);
    }

    public void showWinningNumbersNavigateMessage() {
        System.out.println(WINNING_NUMBERS_INPUT_NAVIGATE);
    }

    private void showLottoCountMessage(Lottos lottos) {
        System.out.println(String.format(PURCHASED_MESSAGE_TEMPLATE, lottos.size()));
    }

    private void showEachLottoNumbers(Lottos lottos) {
        lottos.toUnmodifiableList().forEach(System.out::println);
    }

    private void showNewLine() {
        System.out.println();
    }
}