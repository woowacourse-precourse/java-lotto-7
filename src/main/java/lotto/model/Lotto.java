package lotto.model;

import java.util.List;

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
        if (numbers.stream().distinct().toList().size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 번호를 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto l = (Lotto) o;
        return numbers.equals(l.numbers);
    }

    public boolean haveNumber(Integer number) {
        return numbers.contains(number);
    }

    public Integer countMatch(Lotto lotto) {
        return numbers.stream()
                .filter(lotto.numbers::contains)
                .toList()
                .size();
    }

    public boolean checkBonusMatch(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getLottoNumber() {
        return this.numbers;
    }
}
