package lotto.printer;

import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.List;
import lotto.RankPrice;
import lotto.application.Printer;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PrizeNumber;

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
    public void printPrizeResult(PrizeNumber prizeNumber, double profit) {
        print("\n당첨 통계\n" + "---");
        print(RankPrice.FIFTH.getViewName() + " - " + prizeNumber.getFifthPrizeLottoNumber() + "개");
        print(RankPrice.FOURTH.getViewName() + " - " + prizeNumber.getFourthPrizeLottoNumber() + "개");
        print(RankPrice.THIRD.getViewName() + " - " + prizeNumber.getThirdPrizeLottoNumber() + "개");
        print(RankPrice.SECOND.getViewName() + " - " + prizeNumber.getSecondPrizeLottoNumber() + "개");
        print(RankPrice.FIRST.getViewName() + " - " + prizeNumber.getFirstPrizeLottoNumber() + "개");
        print("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }

    private String makeSortLotto(List<Integer> lotto) {
        List<Integer> sortableList = new ArrayList<>(lotto);
        sort(sortableList);
        return sortableList.toString();
    }
}
