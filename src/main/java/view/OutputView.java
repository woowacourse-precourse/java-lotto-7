package view;

import static view.message.ViewMessage.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import lotto.Lotto;
import lotto.LottoRank;
import lotto.LottoResult;

public class OutputView {

    public static void printPurchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printLottoNumbersMessage() {
        System.out.println(LOTTO_NUMBERS_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public static void printPurchaseQuantity(BigDecimal purchaseQuantity) {
        System.out.printf(PURCHASE_QUANTITY_MESSAGE, purchaseQuantity);
    }

    public static void printLottos(Set<Lotto> lottos) {
        lottos.stream()
              .map(Lotto::getNumbers)
              .forEach(System.out::println);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(LOTTO_RESULT_MESSAGE);

        Map<LottoRank, Integer> rankCounts = lottoResult.getRankCounts();

        Arrays.stream(LottoRank.values())
              .filter(rank -> rank != LottoRank.NONE)
              .forEach(rank -> printLottoRank(rank, rankCounts.get(rank)));
    }

    private static void printLottoRank(LottoRank lottoRank, int matchCount) {
        String formattedPrize = THOUSANDS_COMMA_FORMAT.format(lottoRank.getPrize());

        System.out.printf(MATCH_COUNT_MESSAGE, lottoRank.getWinningCount());
        if (lottoRank.isBonusMatched()) {
            System.out.print(MATCHED_BONUS_NUMBER_MESSAGE);
        }
        System.out.printf(PRIZE_AND_RANK_COUNT_MESSAGE, formattedPrize, matchCount);
    }

    public static void printReturnOnInvestment(BigDecimal returnOnInvestment) {
        System.out.printf(RETURN_ON_INVESTMENT_MESSAGE, returnOnInvestment);
    }
}
