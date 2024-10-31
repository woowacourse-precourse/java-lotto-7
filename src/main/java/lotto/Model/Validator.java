package lotto.Model;

public class Validator {
    public static void validatePrice(int price){
        if (price <= 0){
            throw new IllegalArgumentException("[ERROR] 금액은 양의 정수로 입력되어야 합니다.");
        }
        if (price % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 금액은 1000단위로 입력되어야 합니다.");
        }
    }
}
