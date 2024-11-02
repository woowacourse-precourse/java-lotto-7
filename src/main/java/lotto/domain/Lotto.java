package lotto.domain;

import lotto.Constant;
import lotto.validation.LottoValidator;

import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        //리스트 사이즈 검증
        LottoValidator.checkLottoSize(numbers);
        //1~45사이의 값인지 검증
        numbers.forEach(LottoValidator::checkNumberInRange);
        //유니크 검증
        LottoValidator.checkUniqueNumber(numbers);
    }

    /**
     * 비트 쉬프트 연산을 통해 6개의 로또 번호를 비교한다
     *
     * @param otherLottoNumbers 다른 로또 번호 리스트를 입력으로 받는다
     * @return 일치하는 로또 번호의 개수를 리턴한다
     */
    public int compareLottoNumber(List<Integer> otherLottoNumbers) {
        long result = getBitmask(numbers) & getBitmask(otherLottoNumbers);
        return (int) IntStream.range(Constant.MINIMUM_LOTTO_NUMBER, Constant.MAXIMUM_LOTTO_NUMBER+1)
                .filter(i -> (result & (1L << i)) != 0)
                .count();
    }

    private long getBitmask(List<Integer> numbers) {
        long bitmask = 0;
        for(Integer number : numbers) {
            bitmask |= (1L << number);
        }
        return bitmask;
    }

    //getter
    public List<Integer> getNumbers() {
        return numbers;
    }
}
