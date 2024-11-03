package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class LottoView {

    public void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void printAllLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
