package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
       LottoValidator.validateLottoNumber(numbers);
    }

    public LottoRank checkRank(List<Integer> winningNumber, int bonusNumber) {
        int matchCount = (int) numbers.stream()
                .filter(winningNumber::contains)
                .count();
        boolean matchBonus = numbers.contains(bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
