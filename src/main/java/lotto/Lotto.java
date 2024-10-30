package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.LottoConstant;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        boolean allInRange = numbers.stream()
                .allMatch(n -> n >= 1 && n <= 45);
        if (!allInRange){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }


}
