package lotto.domain.lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoRange(numbers);
        validateLottoDuplicate(numbers);

        this.numbers = numbers;
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }

    public int getMatchedCount(final Lotto randomLotto) {
        int result = 0;

        for (Integer userLottoNumber : numbers) {
            if (randomLotto.numbers.contains(userLottoNumber)) {
                result += 1;
            }
        }
        return result;
    }


    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateLottoDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 로또 번호가 존재합니다.");
        }
    }


    @Override
    public String toString() {
        List<Integer> printout = new ArrayList<>(numbers);
        Collections.sort(printout);
        return printout.toString();
    }

}
