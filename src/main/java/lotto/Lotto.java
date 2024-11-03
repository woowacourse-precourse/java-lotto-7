package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.info.LottoInfo;

public class Lotto {
    /*
    - Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
    - numbers의 접근 제어자인 private은 변경할 수 없다.
    */
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoInfo.MIN_NUMBER.getNumber(), LottoInfo.MAX_NUMBER.getNumber(),
                LottoInfo.COUNT.getNumber());
    }
}
