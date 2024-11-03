package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.service.lottoImpl.RandomNumberServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberService implements RandomNumberServiceImpl {
    @Override
    public List<Lotto> createRandomNumber(int tickets) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < tickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);;
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }
}
