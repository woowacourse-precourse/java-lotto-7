package lotto;

public class Bonus {
    public static void parseBonus (String bonusText, LottoGame lottoGame) {
        if (!bonusText.matches("\\d{1,2}")){
            throw new IllegalArgumentException("보너스 번호는 숫자형식이어야 합니다");
        }
        int bonus = Integer.parseInt(bonusText);
        if (bonus<1 || bonus>45){
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이에 있어야합니다.");
        }
        lottoGame.setBonusNumber(bonus);
    }
}
