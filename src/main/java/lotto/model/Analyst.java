package lotto.model;

import java.util.List;

public class Analyst {
    private int[] winLottos = new int[6];


    public Analyst(List<LottoResult> results, String inputMoney) {
        calculateWinLotto(results);
    }

    private void calculateWinLotto(List<LottoResult> results) {
        for (LottoResult result : results) {
            winLottos[Integer.parseInt(result.getWinningScore())]++;
        }
    }
}