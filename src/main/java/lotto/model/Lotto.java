package lotto.model;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortLottoNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoNumberRange.LOTTO_NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
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
}
