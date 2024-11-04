package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PrintController {

    LottoController lottoController = new LottoController();
    StatisticsController statisticsController = new StatisticsController();

    //로또출력
    public List<Lotto> printLottos(int purchaseNumber) {

        System.out.println(purchaseNumber + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseNumber; i++) {
            Lotto lotto = new Lotto(Lotto.generateNumbers());
            lottos.add(lotto);
        }
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        return lottos;
    }

    //당첨통계
    public LottoResult printStatistics(List<Lotto> lottos, WinNumbers winNumbers) {
        System.out.println("당첨 통계\n---");
        LottoResult lottoResult = statisticsController.calculateWinnings(lottos, winNumbers);
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoResult.rankCount()[4]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoResult.rankCount()[3]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoResult.rankCount()[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoResult.rankCount()[1]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoResult.rankCount()[0]);
        return lottoResult;
    }

    //수익률
    public void printRateOfReturn(LottoResult lottoResult, int purchaseNumber) {
        double rateOfReturn = statisticsController.calculateRateOfReturn(lottoResult.totalWinnings(), purchaseNumber);
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
