package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        this.numbers = numbers;
    }

    public static Lotto drawLotto(){
        List<Integer> numberOfLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numberOfLotto.stream().sorted().toList());
    }
}
