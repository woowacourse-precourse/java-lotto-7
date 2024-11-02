package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<List<Integer>> buyLotto(int lottoCount) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int index = 0; index < lottoCount; index++) {
            lottos.add(Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_NUMBER_COUNT).stream().sorted().toList());
        }
        return lottos;
    }
}
