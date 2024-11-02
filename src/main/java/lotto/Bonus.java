package lotto;

public class Bonus {
    private int bonus;
    public Bonus(String bonusText, Lotto lotto) {
        if (!bonusText.matches("\\d{1,2}")){
            throw new IllegalArgumentException("[Error] 보너스 번호는 숫자형식이어야 합니다");
        }
        bonus = Integer.parseInt(bonusText);
        if (bonus<1 || bonus>45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이에 있어야합니다.");
        }
        if (lotto.getNumbers().contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 로또 번호와 중복되는 보너스 번호가 입력되었습니다.");
        }
        this.bonus = bonus;
    }
    public int getBonus() {
        return bonus;
    }
}
