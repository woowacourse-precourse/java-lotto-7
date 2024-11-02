package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {

    public final Lotto lotto;

    private LottoGenerator() {
        this.lotto = generate();
    }

    //로또 번호 생성
    private Lotto generate() {
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(generatedNumbers);
    }

    public Lotto getLotto() {
        return lotto;
    }
}
