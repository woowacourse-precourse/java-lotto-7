package lotto.view;

import lotto.application.LottoDto;
import lotto.application.LottoTicketsDto;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.view.LottoMessageFormats.*;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoTickets(LottoTicketsDto lottoTicketsDto) {
        List<LottoDto> lottoTickets = lottoTicketsDto.getLottoTickets();
        System.out.printf((OUTPUT_PURCHASED_COUNT_MESSAGE.getMessage()), lottoTickets.size());
        for (LottoDto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getLotto()
                    .stream()
                    .sorted()
                    .toList());
        }
    }

    public static void printUserRanks(List<Rank> userRanks) {
        System.out.println(OUTPUT_WINNING_STATISTICS_HEADER.getMessage());
        List<Rank> ranks = new ArrayList<>(Arrays.asList(Rank.values())).reversed();
        for (Rank rank : ranks) {
            if (rank.equals(Rank.NONE)) {
                continue;
            }
            printUserLottoStatistics(userRanks, rank);
        }
    }

    private static void printUserLottoStatistics(List<Rank> userRanks, Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            System.out.printf((OUTPUT_BONUS_RESULT_FORMAT.getMessage()), rank.getBasicCount(), formatRankPrize(rank.getPrize()), calculateNumberOfRanks(rank, userRanks));
            return;
        }
        System.out.printf((OUTPUT_MATCH_RESULT_FORMAT.getMessage()), rank.getBasicCount(), formatRankPrize(rank.getPrize()), calculateNumberOfRanks(rank, userRanks));
    }

    public static void printRateOfReturn(Double returnOfRate) {
        System.out.printf((OUTPUT_RETURN_RATE_MESSAGE_FORMAT.getMessage()), returnOfRate);
    }

    private static String formatRankPrize(int rankPrize) {
        DecimalFormat decimalFormat = new DecimalFormat(OUTPUT_PRIZE_FORMAT.getMessage());

        return decimalFormat.format(rankPrize);
    }

    private static int calculateNumberOfRanks(Rank rank, List<Rank> userRanks) {
        return (int) userRanks.stream()
                .filter(userRank -> userRank.equals(rank))
                .count();
    }
}