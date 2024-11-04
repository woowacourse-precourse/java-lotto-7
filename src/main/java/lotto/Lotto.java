package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT_EXCEPTION.getMessage());
        }
    }


    public static List<Lotto> publishLotto(int amount) {
        int N = Money.getAmount(amount);
        List<Lotto> lotto = new ArrayList<>();

        for(int i = 0; i < N; i++){
            List<Integer> list = Randoms.pickUniqueNumbersInRange(1,45,6);
            Collections.sort(list);

            lotto.add(new Lotto(list));
        }

        return lotto;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
