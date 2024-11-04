package lotto.model;

public class BonusNumber {

    private final int bonusNumber;
    public BonusNumber(String bounsNumberString, WinningNumber winningNumber){
        validateNotEmpty(bounsNumberString);
        validateNumberIsInteger(bounsNumberString);
        this.bonusNumber = Integer.parseInt(bounsNumberString);
        validateNumberRange();
        validateNoDuplicate(winningNumber);
    }

    private void validateNotEmpty(String bounsNumberString) {
        if(bounsNumberString.isEmpty()) throw new IllegalArgumentException("[ERROR] 보너스 번호는 빈 값이 들어올 수 없습니다.");
    }

    private void validateNumberIsInteger(String bounsNumberString) {
        try{
            Integer.parseInt(bounsNumberString);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로 입력되어야 합니다.");
        }
    }

    private void validateNumberRange() {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateNoDuplicate(WinningNumber winningNumber) {
        if(winningNumber.isContainsNumber(bonusNumber)) throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복 없이 입력되어야 합니다.");
    }
}
