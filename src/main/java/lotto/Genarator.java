package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Genarator {

    private static final int LOTTO_PRICE = 1000;
    private static final int NUMBER_RANGE = 45;

    public List<Lotto> autoGen(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        int numOfLottos = amount / LOTTO_PRICE;


        for (int i = 0; i < numOfLottos; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, NUMBER_RANGE, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }


}
