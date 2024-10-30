package lotto.domain.lottos;

import static java.util.Arrays.stream;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoRange(numbers);
        validateLottoDuplicate(numbers);
        this.numbers = numbers;
    }

    //todo 우와 다른 객ㄱ체여도 바로 otrhernLotto.nnumers가 되구나
    public int getNumberOfMatches(final Lotto randomLotto){
        int result = 0;

        for (Integer userLottoNumber : numbers) {
            if (randomLotto.numbers.contains(userLottoNumber)){
                result += 1;
            }
        }
        return result;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }


    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    //fixme 여기서?
    private void validateLottoDuplicate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 로또 번호가 존재합니다.");
        }
    }



    @Override
    public String toString() {
        numbers.stream().sorted().collect(Collectors.toList());
        return numbers.toString();
    }
}
