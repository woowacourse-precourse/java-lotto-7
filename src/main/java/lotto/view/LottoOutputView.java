package lotto.view;

import static lotto.constant.LottoInfoMsg.START_PRINT_LOTTO_NUMBERS;

import java.util.List;
import lotto.model.Lotto;

public class LottoOutputView {

    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(START_PRINT_LOTTO_NUMBERS.getMsg().formatted(lottos.size()));

        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
