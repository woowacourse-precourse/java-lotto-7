package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static List<Lotto> saleLotto(long lottoNumbers) {
        final int MIN = 1;
        final int MAX = 45;
        final int LOTTO_SIZE = 6;
        List<Lotto> lotteries = new ArrayList<Lotto>();
        for (int i = 0; i < lottoNumbers; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN,MAX,LOTTO_SIZE);
            lotteries.add(new Lotto(numbers));
        }
        return lotteries;
    }
}
