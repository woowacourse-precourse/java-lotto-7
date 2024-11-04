package lotto.controller;

import java.util.List;
import lotto.lottoMachine.Lotto;
import lotto.lottoMachine.LottoResult;

public class OutputController {
    public void printUserLottos (Integer purchaseNum,List<Lotto> userLottos){
        StringBuilder sb = new StringBuilder();
        sb.append(purchaseNum).append("개를 구매했습니다. \n");
        userLottos.forEach(lotto -> sb.append(lotto).append("\n"));

        System.out.println(sb);
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println("당첨통계 \n--- \n");
        System.out.println(lottoResult);
    }
}
