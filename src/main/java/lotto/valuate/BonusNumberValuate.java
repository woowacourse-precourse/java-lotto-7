package lotto.valuate;

public class BonusNumberValuate extends Valuate {

    public static void isValidNumber(String s) {
        try {
            Valuate.isNum(s);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자 하나만 허용됩니다. ex) 5");
        }
    }
}
