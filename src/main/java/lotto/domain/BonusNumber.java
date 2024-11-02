package lotto.domain;

public class BonusNumber {

    private int bonus;

    public BonusNumber(int bonus, Lotto winningNumber){
        validate(bonus, winningNumber);
        this.bonus = bonus;
    }

    private void validate(int number, Lotto winningNumber) {
        checkNumberRange(number);
        checkNumberDuplicated(number, winningNumber);
    }

    private void checkNumberRange(int number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호가 숫자 범위를 벗어납니다.");
        }
    }

    private void checkNumberDuplicated(int number, Lotto winningNumber){
        if (winningNumber.getNumbers().contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    public int getBonus() {
        return bonus;
    }
}
