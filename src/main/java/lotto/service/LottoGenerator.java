package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {
    public List<Integer> getLottoGeneratorNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
