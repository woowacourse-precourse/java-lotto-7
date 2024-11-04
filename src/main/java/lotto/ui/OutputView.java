package lotto.ui;

import static lotto.constant.ViewConstant.BUY_LOTTO_MESSAGE_FORMAT;
import static lotto.constant.ViewConstant.CONTOUR;
import static lotto.constant.ViewConstant.LOTTO_RESULT_MESSAGE;
import static lotto.constant.ViewConstant.PRIZE_RATE_FORMAT;
import static lotto.constant.ViewConstant.PRIZE_RESULT_FORMAT;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.dto.PrizeResultInfo;
import lotto.controller.dto.PrizeResultsDto;
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

    public void printLottoResult(PrizeResultsDto prizeResultsDto) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println(CONTOUR);
        printPrizeResult(prizeResultsDto.results());
    }

    private void printPrizeResult(List<PrizeResultInfo> results) {
        String formattedResults = results.stream()
                .map(result -> String
                        .format(PRIZE_RESULT_FORMAT, result.condition(), result.prize(), result.count())
                )
                .collect(Collectors
                        .joining(System.lineSeparator()));
        System.out.println(formattedResults);
    }

    public void printPrizeRate(BigDecimal rate) {
        System.out.printf((PRIZE_RATE_FORMAT) + "%n", rate);
    }
}
