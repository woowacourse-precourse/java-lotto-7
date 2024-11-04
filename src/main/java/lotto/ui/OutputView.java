package lotto.ui;

import static lotto.constant.ViewConstant.BUY_LOTTO_MESSAGE_FORMAT;
import static lotto.constant.ViewConstant.CONTOUR;
import static lotto.constant.ViewConstant.LOTTO_RESULT_MESSAGE;

import java.util.List;
import lotto.controller.dto.LottoResult;
import lotto.model.Lotto;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public void printPurchaseHistory(List<Lotto> purchaseHistory) {
        System.out.printf(BUY_LOTTO_MESSAGE_FORMAT + "%n", purchaseHistory.size());
        purchaseHistory.forEach(System.out::println);
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println(CONTOUR);
        System.out.println(lottoResult);
    }
}
