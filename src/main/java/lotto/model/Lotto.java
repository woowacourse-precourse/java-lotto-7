package lotto.model;

import lotto.dto.LottoDto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateUnique(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45사이 여야 합니다.");
            }
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복일 수 없습니다.");
        }
    }

    public Prize determinePrize(List<Integer> numbers, int bonus) {
        return Prize.getPrize(countMatchNumber(numbers), hasBonus(bonus));
    }

    private int countMatchNumber(List<Integer> numbers) {
        return (int) this.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private boolean hasBonus(int bonus) {
        return this.numbers.contains(bonus);
    }

    public LottoDto toLottoDto() {
        return new LottoDto(numbers);
    }
}
