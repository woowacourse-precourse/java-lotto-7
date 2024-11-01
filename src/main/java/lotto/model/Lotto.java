package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoNumberRange;
import lotto.dto.LottoDto;
import lotto.exception.ExceptionMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortLottoNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoNumberRange.LOTTO_NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER.format(numbers.size()));
        }
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER.format());
        }
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        return uniqueNumbers.size() != numbers.size();
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public boolean isContainsNumber(int number) {
        return numbers.contains(number);
    }

    public long winningNumberCount(Lotto winningLottoTicket) {
        return numbers.stream()
                .filter(winningLottoTicket.numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public LottoDto toDto() {
        return new LottoDto(this);
    }
}
