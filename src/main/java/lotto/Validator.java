package lotto;

public class Validator {

    public static void priceValidate(String price) {
        if(!price.matches("[+-]?\\d*(\\.\\d+)?"))
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        if(price.matches("-\\d+(\\.\\d+)?$"))
            throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
        if(price.matches("[-+]?\\d*\\.\\d+$"))
            throw new IllegalArgumentException("[ERROR] 소수는 입력할 수 없습니다.");
        if(Integer.parseInt(price) % 1000 > 0)
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야합니다.");
    }
}
