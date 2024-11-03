package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constant;
import lotto.validation.LottoValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    private static Lotto makeRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                Constant.MINIMUM_LOTTO_NUMBER,
                Constant.MAXIMUM_LOTTO_NUMBER,
                Constant.LOTTO_SIZE));
    }

    public static List<Lotto> makeRandomLottoList(Integer amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoList.add(Lotto.makeRandomLotto());
        }
        return lottoList;
    }

    //getter
    public List<Integer> getNumbers() {
        return numbers;
    }

    //For Test
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }
}
