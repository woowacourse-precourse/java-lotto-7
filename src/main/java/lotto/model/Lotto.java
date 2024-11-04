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
        if (numbers.size() != LottoIntConst.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LottoIntConst.LOTTO_SIZE.getValue() + "개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoIntConst.MIN_LOTTO_NUM.getValue() || number > LottoIntConst.MAX_LOTTO_NUM.getValue()) {
                throw new IllegalArgumentException(
                        "[ERROR] 로또 번호는 " + LottoIntConst.MIN_LOTTO_NUM.getValue() + "에서 "
                                + LottoIntConst.MAX_LOTTO_NUM.getValue() + "사이 여야 합니다."
                );
            }
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복일 수 없습니다.");
        }
    }

    public Prize determinePrize(Lotto winningNumber, int bonus) {
        return Prize.getPrize(countMatchNumber(winningNumber), contains(bonus));
    }

    private int countMatchNumber(Lotto other) {
        return (int) this.numbers.stream()
                .filter(other::contains)
                .count();
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public LottoDto toLottoDto() {
        return new LottoDto(numbers);
    }
}
