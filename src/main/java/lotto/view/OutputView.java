package lotto.view;

import lotto.model.LottoRank;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

public class OutputView {
    private static final String QUESTION_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PRINT_LOTTO_AMOUNT = "개를 구매했습니다.";
    private static final String QUESTION_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String PRINT_STATISTICS_HEADER = "당첨 통계\n---";
    private static final NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());

    public void printInputMoney() {
        System.out.println(QUESTION_LOTTO_AMOUNT);
    }

    public void printLottoAmount(int count) {
        System.out.println();
        System.out.println(count + PRINT_LOTTO_AMOUNT);
    }

    public void printWinningNumbers() {
        System.out.println();
        System.out.println(QUESTION_WINNING_NUMBERS);
    }

    public void printBonusNumber() {
        System.out.println();
        System.out.println(QUESTION_BONUS_NUMBER);
    }

    public void printStatistics(Map<LottoRank, Integer> result) {
        System.out.println();
        System.out.println(PRINT_STATISTICS_HEADER);
        Stream.of(LottoRank.values())
                .filter(rank -> rank != LottoRank.MISS)
                .sorted(Comparator.comparingInt(LottoRank::getPrize))
                .forEach(rank -> printRankStatistics(rank, result));
    }

    private void printRankStatistics(LottoRank rank, Map<LottoRank, Integer> result) {
        String message;
        String formattedPrize = numberFormat.format(rank.getPrize());
        if (rank.getMatchBonus()) {
            message = rank.getMatchCount() + "개 일치, 보너스 볼 일치" + " (" + formattedPrize + "원) - " + result.getOrDefault(rank, 0) + "개";
        } else {
            message = rank.getMatchCount() + "개 일치" + " (" + formattedPrize + "원) - " + result.getOrDefault(rank, 0) + "개";
        }
        System.out.println(message);
    }
}