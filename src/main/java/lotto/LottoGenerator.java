package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;


public class LottoGenerator {
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); // 로또 번호 랜덤 생성
        return new Lotto(numbers);
    }
}