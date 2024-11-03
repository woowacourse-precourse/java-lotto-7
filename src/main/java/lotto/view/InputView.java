package lotto.view;

public class InputView {

    public static void validateAmountInput(String money){
        if (money == null || money.isEmpty()){
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해 주세요.");
        }
        if (!isNumeric(money)){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    public static boolean isNumeric(String input){
        return input.matches("\\d+");
    }
}
