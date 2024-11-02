package lotto.view;

import lotto.util.Constants;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLotto(List<Lotto> lottoList, int lottoNum) {
        System.out.println(lottoNum + Constants.PURCHASE_LOTTO_OUTPUT);

        for(int i=0; i<lottoNum; i++){
            List<Integer> numbers = lottoList.get(i).getNumbers();

            String joinLotto = String.join(", ", numbers.stream().map(String::valueOf).toArray(String[]::new));
            System.out.println("[" + joinLotto + "]");
        }
        System.out.println();
    }

    public void totalLotto(LottoResult result) {
        Map<LottoRank, Integer> lottoResults = result.getLottoResult();
        double rate = result.getRate();

        System.out.println(Constants.RESULT_LOTTO_OUTPUT);
        for(LottoRank lottoRank : LottoRank.values()){
            System.out.println(lottoRank.getMatch()+" - "+lottoResults.get(lottoRank)+"개");
        }
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

}
