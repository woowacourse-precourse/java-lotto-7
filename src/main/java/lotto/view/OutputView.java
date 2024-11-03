package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRankType;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static lotto.constants.ViewMessage.*;
import static lotto.domain.LottoRankType.*;

public class OutputView {

    private static final String NUMBER_FORMAT = "%,d";
    private static final String DELIMITER = ",";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final int DEFAULT_VALUE = 0;
    private static final int INCREMENT_COUNT = 1;

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLottoPurchaseCount(int lottoCount) {
        printMessage(String.format(LOTTO_PURCHASE_COUNT.getText(), lottoCount));
    }

    public static void printLottoProfitRate(String lottoProfitRate) {
        printMessage(String.format(PROFIT_RATE.getText(), lottoProfitRate));
    }

    public static void printLottoListPrompt(List<Lotto> lottos) {
        lottos.forEach(lotto -> printMessage(formatLottoNumbers(lotto)));
    }

    public static void printLottoResultPrompt(List<LottoRankType> lottoRankTypes) {
        EnumMap<LottoRankType, Integer> rankCountMap = initializeRankCountMap();
        countLottoRanks(lottoRankTypes, rankCountMap);
        printLottoResults(rankCountMap);
    }

    private static EnumMap<LottoRankType, Integer> initializeRankCountMap() {
        EnumMap<LottoRankType, Integer> rankCountMap = new EnumMap<>(LottoRankType.class);
        Arrays.stream(LottoRankType.values())
                .forEach(rank -> rankCountMap.put(rank, DEFAULT_VALUE));
        return rankCountMap;
    }

    private static void countLottoRanks(List<LottoRankType> lottoRankTypes, EnumMap<LottoRankType, Integer> rankCountMap) {
        lottoRankTypes.forEach(rank -> rankCountMap.put(rank, rankCountMap.get(rank) + INCREMENT_COUNT));
    }

    private static void printLottoResults(EnumMap<LottoRankType, Integer> rankCountMap) {
        List.of(
                formatResult(FIFTH.getMatchCount(), FIFTH.getPrice(), rankCountMap.getOrDefault(FIFTH, DEFAULT_VALUE)),
                formatResult(FOURTH.getMatchCount(), FOURTH.getPrice(), rankCountMap.getOrDefault(FOURTH, DEFAULT_VALUE)),
                formatResult(THIRD.getMatchCount(), THIRD.getPrice(), rankCountMap.getOrDefault(LottoRankType.THIRD, DEFAULT_VALUE)),
                formatBonusResult(SECOND.getMatchCount(), SECOND.getPrice(), rankCountMap.getOrDefault(SECOND, DEFAULT_VALUE)),
                formatResult(FIRST.getMatchCount(), FIRST.getPrice(), rankCountMap.getOrDefault(FIRST, DEFAULT_VALUE))
        ).forEach(OutputView::printMessage);
    }

    private static String formatResult(final int matchCount, final int price, final int count) {
        return String.format(MATCH_RESULT.getText(), matchCount, String.format(NUMBER_FORMAT, price), count);
    }

    private static String formatBonusResult(final int matchCount, final int price, final int count) {
        return String.format(MATCH_BONUS_RESULT.getText(), matchCount, String.format(NUMBER_FORMAT, price), count);
    }

    private static String formatLottoNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(joining(DELIMITER, PREFIX, SUFFIX));
    }

}