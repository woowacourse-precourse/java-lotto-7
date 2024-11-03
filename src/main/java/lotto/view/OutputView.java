package lotto.view;

import java.util.EnumMap;
import java.util.stream.Collectors;
import lotto.amount.Amount;
import lotto.lotto.Lotto;
import lotto.lotto.Lottos;
import lotto.lotto.Rank;
import lotto.lotto.WinningResult;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String SUCCESS_LOTTO_PURCHASE_MESSAGE = NEW_LINE + "%d개를 구매했습니다." + NEW_LINE;
    private static final String REQUEST_WINNING_NUMBERS_MESSAGE = NEW_LINE + "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = NEW_LINE + "보너스 번호를 입력해 주세요.";
    private static final String WINNING_RESULT_STATISTICS_TITLE = NEW_LINE + "당첨 통계" + NEW_LINE + "---";
    private static final String WINNING_RESULT_STATISTICS_BODY = "%d개 일치%s (%s원) - %d개" + NEW_LINE;
    private static final String BONUS_NUMBER_MATCH_RESULT_MESSAGE = ", 보너스 볼 일치";
    private static final String TOTAL_RETURN_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private static final String LOTTO_NUMBERS_SEPARATOR = ", ";
    private static final String LOTTO_NUMBERS_PREFIX = "[";
    private static final String LOTTO_NUMBERS_POSTFIX = "]";
    private static final String EMPTY_STRING = "";

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseLottoNumbers(Lottos lottos) {
        System.out.printf(SUCCESS_LOTTO_PURCHASE_MESSAGE, lottos.getPurchaseLottoCount());

        lottos.getLottos()
                .forEach(this::printLottoNumbers);
    }

    public void requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS_MESSAGE);
    }

    public void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatistics(WinningResult winningResult, Amount purchaseAmount) {
        System.out.println(WINNING_RESULT_STATISTICS_TITLE);

        EnumMap<Rank, Integer> rankCounts = winningResult.getRankCounts();
        for (Rank rank : Rank.values()) {
            printRankStatistics(rank, rankCounts);
        }

        double returnRate = calculateReturnRate(rankCounts, purchaseAmount);
        System.out.printf(TOTAL_RETURN_RATE_MESSAGE, returnRate);
    }

    private void printRankStatistics(Rank rank, EnumMap<Rank, Integer> rankCounts) {
        if (rank == Rank.NONE) {
            return;
        }

        System.out.printf(WINNING_RESULT_STATISTICS_BODY,
                rank.getMatchCount(),
                getBonusNumberMatchMessage(rank),
                generatePrizeFormat(rank.getPrize()),
                rankCounts.get(rank)
        );
    }

    private String getBonusNumberMatchMessage(Rank rank) {
        if (rank.hasBonusNumber()) {
            return BONUS_NUMBER_MATCH_RESULT_MESSAGE;
        }

        return EMPTY_STRING;
    }

    private String generatePrizeFormat(int prize) {
        return String.format("%,d", prize);
    }

    private void printLottoNumbers(Lotto lotto) {
        String lottoNumbers = lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBERS_SEPARATOR));

        System.out.println(LOTTO_NUMBERS_PREFIX + lottoNumbers + LOTTO_NUMBERS_POSTFIX);
    }

    private double calculateReturnRate(EnumMap<Rank, Integer> rankCounts, Amount purchaseAmount) {
        int totalPrize = 0;

        for (Rank rank : Rank.values()) {
            totalPrize += rank.getPrize() * rankCounts.get(rank);
        }

        return ((double) totalPrize / purchaseAmount.getValue() * 100);
    }
}
