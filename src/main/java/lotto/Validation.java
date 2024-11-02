package lotto;

public class Validation {
    public static void validatePrice(String price) {
        if (price == null)
            throw new IllegalArgumentException("[ERROR] 금액은 필수입니다.");
        if (!isDigit(price))
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해야 합니다.");
        if (!checkMinimumAndMultiple(Integer.parseInt(price)))
            throw new IllegalArgumentException("[ERROR] 로또의 단위금액은 1000원입니다.");
    }

    private static boolean isDigit(String value){
        return value.matches("^\\d+$");
    }

    private static boolean checkMinimumAndMultiple(int value){
        return value >= 1000 && value % 1000 == 0;
    }
}
