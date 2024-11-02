package lotto.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import lotto.Rank;

public class OutputView {
    public void printStartMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printTicket(int tryCount, LinkedHashMap<Integer, List<Integer>> lottoTicket) {
        System.out.println();
        System.out.println(tryCount + "개를 구매했습니다.");
        for (Entry<Integer, List<Integer>> entry : lottoTicket.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void printVictoryNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printResult(int[] match) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            System.out.printf("%s (%,d원) - %d개%n", rank.getMatchInfo(), rank.getPrizeMoney(), match[rank.ordinal()]);
        }
    }

    public void printRevenue(double revenue) {
        System.out.printf("총 수익률은 %.1f%%입니다.", revenue);
    }
}
