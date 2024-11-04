package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.factory.LottoFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(int total) {
        lottoList = IntStream.range(0, total)
                .mapToObj(i -> LottoFactory.createLotto(getRandomNum()))
                .collect(Collectors.toList());
    }

    private static List<Integer> getRandomNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
