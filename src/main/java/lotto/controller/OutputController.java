package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.lottoMachine.Lotto;
import lotto.lottoMachine.LottoResult;

public class OutputController {
    public void printUserLottos (Integer purchaseNum,List<Lotto> userLottos){
        StringBuilder sb = new StringBuilder();
        sb.append(purchaseNum).append("개를 구매했습니다. \n");
        userLottos.forEach(lotto -> sb.append(lotto).append("\n"));

        System.out.println(sb);
    }

    public void printResult(Map<LottoResult, Integer> resultMap, Double ratioOfProfit) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨통계 \n").append("--- \n");
        for(Map.Entry<LottoResult, Integer> entry : resultMap.entrySet()) {
            LottoResult lottoResult = entry.getKey();
            sb.append(lottoResult.getDescription()).append(entry.getValue()).append("개 \n");
        }

        sb.append(String.format("총 수익률은 %.1f%%입니다.\n", ratioOfProfit));
        System.out.println(sb);
    }
}
