package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.MyLotto;

public class ResultView {

    public static final String LINE_BREAK = "\n";

    public void printPurchaseLottoInfo(MyLotto lottos) {
        numberOfLotto(lottos.getNumberOfLotto());
        printPurchasedLottos(lottos);
    }

    private void numberOfLotto(int numberOfLotto) {
        System.out.println(LINE_BREAK +numberOfLotto+"개를 구매했습니다");
    }

    private void printPurchasedLottos(MyLotto lottos) {
        for (Lotto lotto : lottos.getMyLottos()) {
            System.out.println(
                    lotto.getLotto()
                            .stream()
                            .map(i -> String.valueOf(i.toString()))
                            .collect(Collectors.joining(", ", "[", "]"))
            );
        }
    }

}
