package lotto.view;

import lotto.dto.LottoNumbers;

public class OutputView {
    private final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public void printLottoCount(final int count) {
        System.out.println(System.lineSeparator() + count + PURCHASE_MESSAGE);
    }

    public void printLottoNumbers(final LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers.getLottoNumbers());
    }

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
