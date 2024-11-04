package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.DuplicationNumberException;
import lotto.exception.InvalidNumberRangeException;
import lotto.exception.InvalidNumberSizeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        List<Integer> duplicateNumbers = new ArrayList<>();

        if (numbers.size() != 6) {
            throw new InvalidNumberSizeException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        for (Integer lottoNumber : numbers) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                throw new InvalidNumberRangeException("[ERROR] 1에서 45사이의 숫자를 입력해주세요.");
            }
            if (duplicateNumbers.contains(lottoNumber)) {
                throw new DuplicationNumberException("[ERROR] 중복된 숫자가 존재합니다.");
            }
            duplicateNumbers.add(lottoNumber);
        }
    }
}
