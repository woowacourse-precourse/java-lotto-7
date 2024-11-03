package lotto.model;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number, Lotto lotto) {
        validate(number, lotto);
        this.number = number;
    }

    private void validate(int number, Lotto lotto) {
        if (number < 1 && number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45사이의 숫자여야 합니다.");
        } //에러메시지를 enum으로 다뤘으면 좋겠네
        if (lotto.isDuplicateWithLotto(number)) { //lotto를 받아오는게 좋을까?
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되면 안됩니다.");
        }
    }

    public int getNumber(){
        return number;
    }
}
