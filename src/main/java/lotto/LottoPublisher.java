package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoPublisher {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Lotto> generateLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++){
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lottoNumber));
        }
        return lottos;
    }
}