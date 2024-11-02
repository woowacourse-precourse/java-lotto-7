package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Service {
    // TODO: 로또발행
    List<List<Integer>> generator(int sheets) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < sheets; i++) {
            lottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return lottos;
    }
}
