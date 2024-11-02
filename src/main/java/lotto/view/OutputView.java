package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void printLottoDetails(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto ->
            System.out.println(lotto.represent())
        );
    }
}
