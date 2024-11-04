package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoCreate;

import java.util.Arrays;

public class Output {
    public static void printLottos(LottoCreate lottoCreate) {
        System.out.println(lottoCreate.getLottoCount() + "개를 구매했습니다.");
        for(Lotto lotto : lottoCreate.getLottos())
            System.out.println(lotto.getNumbers().toString());
        System.out.println();
    }
}
