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
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            int num = result.get(rank.name());
            System.out.println(printRank(rank, num));
        }
    }

    private String printRank(LottoRank rank, int num) {
        if (rank.name() == "SECOND") {
            String message = String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", rank.getMatchCount(), rank.getPrize(),
                    num);
            return message;
        }
        String message = String.format("%d개 일치 (%,d원) - %d개", rank.getMatchCount(), rank.getPrize(), num);
        return message;
    }


    public void printRate(double num) {
        System.out.println("총 수익률은 " + String.format("%.1f", num) + "%입니다.");
    }
}
