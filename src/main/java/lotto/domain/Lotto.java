package lotto.domain;

import lotto.domain.LottoConstant;

import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        numbers.forEach(this::validateNumberInRange);
        validateDuplicates(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        int lottoSize = LottoConstant.LOTTO_SIZE.getIntValue();
        if (numbers.size() != lottoSize) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d개여야 합니다.", lottoSize));
        }
    }

    private void validateNumberInRange(Integer number) {
        int minNumber = LottoConstant.MIN_NUMBER.getIntValue();
        int maxNumber = LottoConstant.MAX_NUMBER.getIntValue();

        if (number < minNumber)
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d 이상이어야 합니다.", minNumber));
        if (number > maxNumber)
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d 이하이어야 합니다.", maxNumber));
    }

    private void validateDuplicates(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private List<Integer> sortAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
