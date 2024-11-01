package lotto;

import java.util.List;

public class Output {
    private static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_NUMBER_PREFIX = "[";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String LOTTO_NUMBER_SUFFIX = "]";

    public static void printPurchaseMessage(final int purchasedLottoesCount) {
        System.out.println(purchasedLottoesCount + LOTTO_PURCHASE_MESSAGE);
    }

    public static void printLotto(final Lotto lotto) {
        String lottoNumbers = lotto.readNumberAscending(LOTTO_NUMBER_DELIMITER);
        System.out.println(LOTTO_NUMBER_PREFIX + lottoNumbers + LOTTO_NUMBER_SUFFIX);
    }
}
