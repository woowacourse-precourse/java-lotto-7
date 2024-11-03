package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.staticenum.ErrorStatic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.staticenum.LottoStatic.*;

public class LottoShop {

    public List<Lotto> purchaseLotto(int money) {
        if ((money % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException(ErrorStatic.MONEY_ERROR);
        }

        int lottoCount = money / LOTTO_PRICE;
        System.out.println(lottoCount + "개를 구매하였습니다");

        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

}
