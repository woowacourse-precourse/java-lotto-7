package lotto.view;

import java.util.stream.Collectors;
import lotto.lotto.Lotto;
import lotto.lotto.Lottos;
import lotto.lotto.WinningResult;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String SUCCESS_LOTTO_PURCHASE_MESSAGE = NEW_LINE + "%d개를 구매했습니다." + NEW_LINE;
    private static final String REQUEST_WINNING_NUMBERS_MESSAGE = NEW_LINE + "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = NEW_LINE + "보너스 번호를 입력해 주세요.";
    public static final String WINNING_RESULT_STATISTICS_TITLE = NEW_LINE + "당첨 통계" + NEW_LINE + "---";

    private static final String LOTTO_NUMBERS_SEPARATOR = ", ";
    private static final String LOTTO_NUMBERS_PREFIX = "[";
    private static final String LOTTO_NUMBERS_POSTFIX = "]";

    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseLottoNumbers(int lottoCount) {
        System.out.printf(SUCCESS_LOTTO_PURCHASE_MESSAGE, lottoCount);

        Lottos lottos = new Lottos(lottoCount);
        lottos.getLottos()
                .forEach(this::printLottoNumbers);
    }

    public void requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS_MESSAGE);
    }

    public void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatistics(WinningResult winningResult) {
        System.out.println(WINNING_RESULT_STATISTICS_TITLE);
    }

    private void printLottoNumbers(Lotto lotto) {
        String lottoNumbers = lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBERS_SEPARATOR));

        System.out.println(LOTTO_NUMBERS_PREFIX + lottoNumbers + LOTTO_NUMBERS_POSTFIX);
    }
}
