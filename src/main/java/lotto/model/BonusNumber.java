package lotto.model;

public class BonusNumber {
    private final int bonusNumber;
    public BonusNumber(int bonusNumber){
        isNumberBetween1And45(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    private void isNumberBetween1And45(int bonusNumber){
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
}
