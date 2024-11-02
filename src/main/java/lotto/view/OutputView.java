package lotto.view;

import lotto.application.LottoDto;
import lotto.application.LottoTicketsDto;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoTickets(LottoTicketsDto lottoTicketsDto) {
        List<LottoDto> lottoTickets = lottoTicketsDto.getLottoTickets();
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (LottoDto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getLotto()
                    .stream()
                    .sorted()
                    .toList());
        }
    }

    public static void printUserRanks(List<Rank> userRanks) {
        System.out.println("당첨 통계");
        List<Rank> ranks = new ArrayList<>(Arrays.asList(Rank.values())).reversed();
        for (Rank rank : ranks) {
            if (rank.equals(Rank.NONE)) {
                continue;
            }
            if (rank.equals(Rank.SECOND)) {
                System.out.println(rank.getBasicCount() + "개 일치, 보너스 볼 일치 " + "(" + formatRankPrize(rank.getPrize()) + "원)" + " - " + calculateNumberOfRanks(rank, userRanks) + "개");
                continue;
            }
            System.out.println(rank.getBasicCount() + "개 일치 " + "(" + formatRankPrize(rank.getPrize()) + "원)" + " - " + calculateNumberOfRanks(rank, userRanks) + "개");
        }
    }

    private static String formatRankPrize(int rankPrize) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        return decimalFormat.format(rankPrize);
    }

    private static int calculateNumberOfRanks(Rank rank, List<Rank> userRanks) {
        return (int) userRanks.stream()
                .filter(userRank -> userRank.equals(rank))
                .count();
    }

    public static void printRateOfReturn(Double returnOfRate) {
        System.out.println("총 수익률은 " + returnOfRate + "%입니다.");
    }
}
