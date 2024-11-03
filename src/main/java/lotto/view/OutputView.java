package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoRank;

public class OutputView {
    public void result(List<List<Integer>> lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (List<Integer> lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }

    public void printresult(Map<String, Integer> result) {
        for (LottoRank rank : LottoRank.values()) {
            int num = result.get(rank.name());
            System.out.println(rank.getMatchCount() + "개 일치 " + rank.getOutputPrize() + "원" + " - " + num + "개");
        }
    }

    public void printRate(double num) {
        System.out.println("총 수익률은 " + String.format("%.2f", num) + "%입니다.");
    }
}
