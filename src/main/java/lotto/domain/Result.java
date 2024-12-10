package lotto.domain;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Result {
    private static final int INITIAL_PRIZE = 0;
    private static final int MISS_COUNT = 0;
    private static final String MATCH_COUNT_MESSAGE = "%d개 일치%s (%s원) - %d개";
    private static final String BONUS_BALL_MATCH = ", 보너스 볼 일치";
    private static final List<LottoRank> DISPLAY_RANKS = List.of(
            LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);

    private final Map<LottoRank, Integer> matchResults;
    private int totalPrize;

    public Result() {
        this.matchResults = initializeMatchResults();
        this.totalPrize = INITIAL_PRIZE;
    }

    private Map<LottoRank, Integer> initializeMatchResults() {
        Map<LottoRank, Integer> results = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, MISS_COUNT);
        }
        return results;
    }

    public static Result from(LottoTicket lottoTicket, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Result result = new Result();
        result.storeResults(lottoTicket, winningNumbers, bonusNumber);
        return result;
    }

    private void storeResults(LottoTicket lottoTicket, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (Lotto lotto : lottoTicket.getTickets()) {
            LottoRank rank = winningNumbers.calculateRank(lotto, bonusNumber);
            recordMatchResult(rank);
        }
    }

    private void recordMatchResult(LottoRank rank) {
        if (rank == LottoRank.MISS) {
            return;
        }
        incrementMatchCount(rank);
        addPrize(rank.getPrize());
    }

    private void incrementMatchCount(LottoRank rank) {
        matchResults.put(rank, matchResults.get(rank) + 1);
    }

    private void addPrize(int prize) {
        totalPrize += prize;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public List<String> getFormattedResults() {
        return formatResults();
    }

    private List<String> formatResults() {
        NumberFormat currencyFormat = NumberFormat.getInstance(Locale.US);
        List<String> formattedResults = new ArrayList<>();

        for (LottoRank rank : DISPLAY_RANKS) {
            formattedResults.add(formatSingleResult(rank, currencyFormat));
        }
        return formattedResults;
    }

    private String formatSingleResult(LottoRank rank, NumberFormat currencyFormat) {
        int count = matchResults.getOrDefault(rank, MISS_COUNT);
        String formattedPrize = currencyFormat.format(rank.getPrize());
        String bonusMessage = getBonusMessage(rank);
        return String.format(MATCH_COUNT_MESSAGE, rank.getMatchCount(), bonusMessage, formattedPrize, count);
    }

    private String getBonusMessage(LottoRank rank) {
        return rank == LottoRank.SECOND ? BONUS_BALL_MATCH : "";
    }
}
