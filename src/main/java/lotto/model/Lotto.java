package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import lotto.constant.LottoConfiguration;

public class Lotto {

    public static final String NULL_NUMBER_EXCEPTION_MESSAGE = "로또 번호 리스트가 null인 것은 허용하지 않습니다.";
    public static final String NUMBER_DUPLICATION_EXCEPTION_MESSAGE = "로또 번호는 중복이 존재하면 안됩니다.";
    public static final String INCORRECT_NUMBER_COUNT_EXCEPTION_MESSAGE =
            String.format("로또 번호는 %d 개여야 합니다.", LottoConfiguration.LOTTO_NUMBER_COUNT);
    public static final String OUT_OF_RANGE_NUMBER_EXCEPTION_MESSAGE =
            String.format("로또번호는 %d~%d 사이여야 합니다.",
                    LottoConfiguration.LOTTO_NUMBER_RANGE_START, LottoConfiguration.LOTTO_NUMBER_RANGE_END);
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNull(numbers);
        validateNumberCount(numbers);
        validateNumberDuplication(numbers);
        validateNumberRange(numbers);
        this.numbers = alignNumber(numbers);
    }

    private void validateNull(List<Integer> numbers) {
        if (Objects.isNull(numbers)) {
            throw new IllegalArgumentException(NULL_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoConfiguration.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private void validateNumberDuplication(List<Integer> numbers) {
        HashSet<Integer> notDuplicatedNumber = new HashSet<>(numbers);
        if (notDuplicatedNumber.size() != LottoConfiguration.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(int number) {
        if (number < LottoConfiguration.LOTTO_NUMBER_RANGE_START
                || number > LottoConfiguration.LOTTO_NUMBER_RANGE_END) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private List<Integer> alignNumber(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public String printLottoNumbers() {
        List<String> targetNumbers = numbers.stream().map(String::valueOf).toList();
        return String.join(", ", targetNumbers);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
