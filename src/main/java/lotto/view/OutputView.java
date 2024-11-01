package lotto.view;

import lotto.dto.LottoNumbers;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String DIVIDER = "---";

    public void printLottoCount(final int count) {
        System.out.println(System.lineSeparator() + count + PURCHASE_MESSAGE);
    }

    public void printLottoNumbers(final LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers.getLottoNumbers());
    }

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }

    public void printResult() {
        System.out.println(System.lineSeparator() + RESULT_MESSAGE);
        System.out.println(DIVIDER + System.lineSeparator());
    }
}
