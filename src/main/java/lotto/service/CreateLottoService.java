package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateLottoService {
    private static final int LOTTO_SIZE = 6;

    public List<Lotto> createRandomLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(createSingleLotto());
        }
        return lottos;
    }

    private Lotto createSingleLotto() {
        // 불변 리스트를 새로운 ArrayList로 변환하여 정렬 가능하게 만듦
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_SIZE));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}