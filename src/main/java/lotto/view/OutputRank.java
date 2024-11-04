package lotto.view;

import lotto.domain.Rank;

import java.util.Map;

public class OutputRank {

  private static final String MESSAGE_MATCH_RESULT = "%d개 일치 (%d원) - %d개";
  private static final String MESSAGE_BONUS_MATCH_RESULT = "5개 일치, 보너스 볼 일치 (30000000원) - %d개";

  public static void printMatchResults(Map<Rank, Long> rankResults) {
    System.out.println("당첨 통계");
    System.out.println("---");
    for (Rank rank : Rank.values()) {
      if (rank != Rank.NONE) {
        printRankResult(rank, rankResults.getOrDefault(rank, 0L));
      }
    }
  }

  private static void printRankResult(Rank rank, Long count) {
    if (rank == Rank.SECOND) {
      System.out.println(String.format(MESSAGE_BONUS_MATCH_RESULT, count));
    }
    if (rank != Rank.SECOND) {
      System.out.println(String.format(MESSAGE_MATCH_RESULT, rank.getMatchCount(), rank.getPrizeAmount(), count));
    }
  }
}
