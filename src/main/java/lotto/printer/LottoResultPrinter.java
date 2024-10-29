package lotto.printer;

import static java.util.Collections.sort;

import java.util.List;
import lotto.application.Printer;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoResultPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printPurchaseResult(int quantity, Lottos lottos) {
        print(quantity + "개를 구매했습니다.");
        List<Lotto> allLotto = lottos.value();
        for (Lotto lotto : allLotto) {
            print(makeSortLotto(lotto.getNumbers()));
        }
    }

    private String makeSortLotto(List<Integer> lotto) {
        sort(lotto);
        return lotto.toString();
    }
}
