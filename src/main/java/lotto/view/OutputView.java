package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class OutputView {

    public static final String PURCHASE_COUNT = "%d개를 구입하였습니다.";

    public void purchasedLottos(List<Lotto> lottos){
        System.out.printf(PURCHASE_COUNT, lottos.size());
        for (Lotto lotto:lottos){
            System.out.println(lotto);
        }
    }
}
