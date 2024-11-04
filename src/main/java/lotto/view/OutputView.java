package lotto.view;

import static lotto.constant.ApplicationConstants.MATCH_RESULT_MESSAGE;
import static lotto.constant.ApplicationConstants.MATCH_RESULT_MESSAGE1;
import static lotto.constant.ApplicationConstants.MATCH_RESULT_MESSAGE2;
import static lotto.constant.ApplicationConstants.PURCHASE_SUCCESS_MESSAGE;
import static lotto.constant.ApplicationConstants.TOTAL_PROFIT_RATE_MESSAGE;
import static lotto.constant.ApplicationConstants.WINNING_STATISTICS_HEADER;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.enums.LottoRank;

public class OutputView {
    public void printPurchaseLotts(List<Lotto> purchaseLottos) {
        System.out.println(String.format(PURCHASE_SUCCESS_MESSAGE, purchaseLottos.size()));

        purchaseLottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public void printLottoResult(List<LottoRank> lottoResult) {
        System.out.println(WINNING_STATISTICS_HEADER);

        Map<LottoRank, Long> rankCount = lottoResult.stream()
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));

        Stream.of(LottoRank.values()).filter(rank -> rank != LottoRank.NOTHING).forEach(
                rank -> System.out.println(String.format(MATCH_RESULT_MESSAGE, getMatchDescription(rank),
                        NumberFormat.getNumberInstance().format(rank.getReward()), rankCount.getOrDefault(rank, 0L))));

    }

    private String getMatchDescription(LottoRank lottoRank) {
        String text = String.format(MATCH_RESULT_MESSAGE1, lottoRank.getMatchCount());
        if (lottoRank.isMatchBonus()) {
            text = text.concat(MATCH_RESULT_MESSAGE2);
        }
        return text;
    }

    public void printProfit(double profit) {
        System.out.println(String.format(TOTAL_PROFIT_RATE_MESSAGE, profit));
    }
}
