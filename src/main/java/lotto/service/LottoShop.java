package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.staticenum.LottoStatic.*;

public class LottoShop {

    public List<Lotto> purchaseLotto(int money) {

        int lottoCount = money / LOTTO_PRICE;
        System.out.println(lottoCount + "개를 구매했습니다.");

        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            ArrayList<Integer> modifiable = new ArrayList<>(lottoNumbers);
            Collections.sort(modifiable);
            lottos.add(new Lotto(modifiable));
        }

        return lottos;
    }

}
