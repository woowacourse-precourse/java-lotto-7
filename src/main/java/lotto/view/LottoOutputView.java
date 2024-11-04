package lotto.view;

import static lotto.constant.LottoInfoMsg.START_PRINT_LOTTO_NUMBERS;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoRanking;
import lotto.model.Lotto;

public class LottoOutputView {

    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(START_PRINT_LOTTO_NUMBERS.getMsg().formatted(lottos.size()));

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printFinalResult(Map<LottoRanking, Integer> matchedResultMap, double profitRate) {
        System.out.println("matchedResultMap = " + matchedResultMap);
        System.out.println("profitRate = " + profitRate);
    }
}
