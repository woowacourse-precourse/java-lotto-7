package lotto.domain;

import java.util.List;

public class WinningLotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int MAX_COUNT = 6;

    private List<Integer> winningNumbers;
    private BonusNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public List<Integer> getImmutableWinningNumbers() {
        return List.copyOf(winningNumbers);
    }

    public BonusNumber getImmutableBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != MAX_COUNT) {
            String errorMessage = String.format("[ERROR] 로또 번호는 %d개여야 합니다.", MAX_COUNT);
            throw new IllegalArgumentException(errorMessage);
        }

        numbers.forEach((number) -> {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                String errorMessage = String.format("[ERROR] 로또 번호는 %d 이상, %d 이하 정수여야 합니다.", MIN_NUMBER, MAX_NUMBER);
                throw new IllegalArgumentException(errorMessage);
            }
        });

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }
}
