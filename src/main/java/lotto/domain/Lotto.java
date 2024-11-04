package lotto.domain;

import static lotto.utils.Constant.LOTTO_NUMBER_MAX;
import static lotto.utils.Constant.LOTTO_NUMBER_MIN;
import static lotto.utils.Constant.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import global.errorMessage.LottoErrorMessage;
import global.errorMessage.NumberErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

/**
 * 제공된 Lotto 클래스를 사용하여 구현해야 한다.
 * Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
 * numbers의 접근 제어자인 private은 변경할 수 없다.
 * Lotto의 패키지를 변경할 수 있다.
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto create() {
        List<Integer> randoms = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_SIZE);
        List<Integer> sortedNumbers = new ArrayList<>(randoms);
        Collections.sort(sortedNumbers);
        return new Lotto(sortedNumbers);
    }

    public boolean containBonusNumber(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }

    public String result() {
        StringJoiner stringJoiner = new StringJoiner(", ","[","]");
        numbers.forEach(
                number -> stringJoiner.add(String.valueOf(number))
        );
        return stringJoiner.toString();
    }

    public Integer getElement(int index) {
        if(index < 0 || index >= LOTTO_SIZE) {
            throw new IndexOutOfBoundsException();
        }
        return numbers.get(index);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbersInRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        if(numbers.stream().anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException(NumberErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(Integer number : numbers) {
            if(!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
            }
        }
    }
}
