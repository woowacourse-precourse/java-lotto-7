package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class Output {
    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.print("[");
            System.out.print(lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            System.out.println("]");
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계\n"
                + "---");
        System.out.print(lottoResult.getResultMessage());
    }

    public void printYield(double yield) {
        System.out.print("총 수익률은" + yield + "%입니다.");
    }
}
