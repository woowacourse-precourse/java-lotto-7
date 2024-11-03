package lotto.valuate;

public class WinnerNumberValuate extends Valuate {

    public static void isValidNumber(String s) {
        if (s == "") {
            throw new IllegalArgumentException("당첨 번호에 공백을 포함할 수 없습니다.");
        }
        try {
            isNum(s);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자만 입력할 수 있습니다.");
        }
    }


}
