package lotto.io;

import java.util.List;

import lotto.lotto.LottoAmount;
import lotto.lotto.Lottos;

public class ConsoleOutputHandler implements OutputHandler {

    private static final String NEW_LINE = "\n";

    @Override
    public void printLotto(Lottos lottos, LottoAmount lottoAmount) {
        int purchaseLottoCount = lottoAmount.getPurchaseLottoCount();
        System.out.println(NEW_LINE + purchaseLottoCount + "개를 구매했습니다.");

        List<List<Integer>> lottoValues = lottos.getLottoValues();
        for (List<Integer> lottoValue : lottoValues) {
            System.out.println(lottoValue);
        }
    }
}
