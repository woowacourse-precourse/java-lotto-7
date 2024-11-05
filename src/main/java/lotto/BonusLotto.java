package lotto;

import java.util.List;

public class BonusLotto {
    private final int bonusNumber;
    private List<Integer> numbers;

    public BonusLotto(int bonusNumber, List<Integer> numbers) {
        BonusValidate(bonusNumber, numbers);
        this.bonusNumber = bonusNumber;
        this.numbers = numbers;
    }

    private void BonusValidate(int bonusNumber, List<Integer> numbers) {
        if(bonusNumber < 1 || bonusNumber > 45 ) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 번호를 입력해야 합니다.");
        }
        if(numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복되는 로또 번호는 입력할 수 없습니다.");
        }
    }
}
