package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGeneration {  // 번호 열거형
    public enum LottoOption {
        NUMBER_MAX(45),
        NUMBER_COUNT(6);

        private final int value;

        LottoOption(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public List<Integer> pickUniqueNumbers () {     // 1부터 45 중복되지 않는 숫자 뽑기
        return Randoms.pickUniqueNumbersInRange(1, LottoOption.NUMBER_MAX.getValue(), LottoOption.NUMBER_COUNT.getValue());
    }
}
