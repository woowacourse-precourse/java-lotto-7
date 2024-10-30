package lotto.application.printer;

import static java.util.Collections.sort;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import lotto.application.Printer;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.prizelotto.PrizeLotto;

public class LottoResultPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printPurchaseResult(int quantity, Lottos lottos) {
        print("\n" + quantity + "개를 구매했습니다.");
        List<Lotto> allLotto = lottos.value();
        for (Lotto lotto : allLotto) {
            print(makeSortLotto(lotto.getNumbers()));
        }
    }

    @Override
    public void printPrizeResult(List<PrizeLotto> prizeLottos, double profit) {
        print("\n당첨 통계\n" + "---");
        for (PrizeLotto prizeLotto : prizeLottos) {
            print(prizeLotto.getMatchCount() + "개 일치 (" + chunkByThree(prizeLotto.getPrice()) + "원) - "
                    + prizeLotto.getCount()
                    + "개");
        }
        print("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }

    private String makeSortLotto(List<Integer> lotto) {
        List<Integer> sortableList = new ArrayList<>(lotto);
        sort(sortableList);
        return sortableList.toString();
    }

    private String chunkByThree(int price) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(price);
    }
}
