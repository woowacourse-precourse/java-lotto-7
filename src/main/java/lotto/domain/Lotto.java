package lotto.domain;

import lotto.domain.type.LottoRank;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public static Lotto from(String lottoAnswerNum) {
        List<Integer> numbers = List.of(lottoAnswerNum.split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Lotto(numbers);
    }

    public List<Integer> getNumList() {
        return numbers;
    }

    public LottoRank match(Lotto target, int bonusNumber) {
        long count = numbers.stream()
                .filter(target.numbers::contains)
                .count();

        boolean isMatchBonus = numbers.contains(bonusNumber);

        return LottoRank.valueOf(count, isMatchBonus);
    }
}
