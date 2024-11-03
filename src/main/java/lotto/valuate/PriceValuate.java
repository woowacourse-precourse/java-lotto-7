package lotto.valuate;

public class PriceValuate extends Valuate {
    public static void isValidNumber(String s) {
        try {
            Valuate.isNum(s);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("금액은 숫자 형식으로 입력해주세요. ex) 5000");
        }
    }


    public static void isValidPrice(int price) {
        if (price / 1000 < 1 || price % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위로 입력해 주세요.");
        }
    }
}
