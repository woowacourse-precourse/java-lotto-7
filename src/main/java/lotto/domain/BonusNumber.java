package lotto.domain;

public class BonusNumber {
    private final int bonusNum;

    public BonusNumber(String number_str){
        int number=checkText(number_str);
        validate(number);
        this.bonusNum=number;
    }
    private void validate(int amount) {
        checkRange(amount);
    }
    private int checkText(String numberStr) {
        numberStr=numberStr.trim();
        if (numberStr.isBlank()) {
            throw new IllegalArgumentException();
        }
        try {
            return Integer.parseInt(numberStr.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    private void checkRange(int number){
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
        }
    }
    public int getBonusNum() {
        return bonusNum;
    }
}
