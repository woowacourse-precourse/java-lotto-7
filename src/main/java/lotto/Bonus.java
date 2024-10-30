package lotto;

public class Bonus {

    private final Lotto lotto;
    private int num;

    private Bonus() {
        throw new IllegalArgumentException();
    }

    public Bonus(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setNum(int num) {
        if (lotto.contains(num)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        this.num = num;
    }

    public boolean isCorrectNum(int bonusNum) {
        return this.num == bonusNum;
    }

    public int getNum() {
        return this.num;
    }
}
