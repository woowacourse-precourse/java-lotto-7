package lotto.model;

import static lotto.constants.LottoConfig.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public List<List<Integer>> generateLottoNumbers(int money) {
        return IntStream.range(ZERO.getValue(), money)
                .mapToObj(i -> {
                    List<Integer> singleLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
                    Collections.sort(singleLotto);
                    return singleLotto;
                })
                .collect(Collectors.toList());
    }
}