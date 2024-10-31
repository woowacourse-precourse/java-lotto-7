package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void printLottoQuantity(List<Lotto> lottos) {
        System.out.println(lottos.size()+"개를 구매했습니다.");
    }
}
