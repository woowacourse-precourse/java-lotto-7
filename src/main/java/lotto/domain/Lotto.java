package lotto.domain;

import static lotto.constant.ExceptionMessage.DUPLICATE_NUMBER;
import static lotto.constant.ExceptionMessage.INVALID_SIZE;
import static lotto.constant.ExceptionMessage.NUMBER_OUT_OF_RANGE;
import static lotto.constant.LottoConstants.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.MINIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.NUMBERS_PER_TICKET;

import java.util.List;
import lotto.vo.LottoNumber;

/**
 * 고유하고 검증된 번호 목록을 가진 로또 티켓을 나타냅니다.
 * <p>
 * 이 클래스는 미션 요구사항에 따라 {@code numbers} 이외의 추가 필드를 가질 수 없고, {@code numbers} 필드에 대해 private 접근 제한자를 유지해야 합니다. 이러한 제한을 준수하면서
 * 번호 검증을 수행하기 위해 {@link LottoNumber} 객체를 직접 사용하지 않고, 각 번호를 {@link LottoNumber}를 통해 검증한 후 정수 값을 저장하여 유효한 번호 리스트를 유지합니다.
 * </p>
 */
public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        List<Integer> validatedNumbers = validateAndConvertNumbers(numbers);

        validateSizeExact(validatedNumbers);
        validateNoDuplicate(validatedNumbers);
        validateNumbersInRange(validatedNumbers);

        this.numbers = validatedNumbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(List.copyOf(numbers));
    }

    private List<Integer> validateAndConvertNumbers(List<Integer> inputNumbers) {
        return inputNumbers.stream()
                .map(LottoNumber::from)
                .map(LottoNumber::getValue)
                .sorted()
                .toList();
    }

    private void validateSizeExact(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_PER_TICKET) {
            throw new IllegalArgumentException(INVALID_SIZE.format(NUMBERS_PER_TICKET));
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NUMBERS_PER_TICKET) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.message());
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberInRange(number);
        }
    }

    private void validateNumberInRange(int number) {
        if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.format(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber.getValue());
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public int countMatchingNumbers(Lotto other) {
        return (int) numbers.stream()
                .filter(number -> other.contains(LottoNumber.from(number)))
                .count();
    }
}
