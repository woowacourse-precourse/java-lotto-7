package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class Output {
    public void purchaseAmount(List<Lotto> issuedLotto) {
        for (Lotto lotto : issuedLotto) {
            System.out.println(lotto);
        }
    }

}
