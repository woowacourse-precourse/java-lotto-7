package lotto.view;

import lotto.model.*;

public class OutputView {
    public void printCount(Amount amount){
        System.out.println(amount.getCount() + "개를 구입하셨습니다.");
    }

    public void printLottoList(LottoList lottoList){
        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResults(ResultCalculator resultCalculator){
        for (Rank rank : Rank.values()) {
            if (rank.getPrize() == 0) continue;
            int count = resultCalculator.getRankCounts().getOrDefault(rank, 0);
            System.out.println(rank.getDescription() + count + "개");
        }
    }

    public void printProfitRate(double profitRate){
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
