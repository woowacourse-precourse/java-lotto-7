package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {

    //로또 번호 생성
    public Lotto generate() {
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(generatedNumbers);
    }

}
