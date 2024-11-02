package lotto.view;

import lotto.domain.Constants;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

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
    }

    public void totalLotto(Map<LottoRank, Integer> lottoResult, double rate) {
        System.out.println(Constants.RESULT_LOTTO_OUTPUT);
    }
}
