package lotto.validator;
public class NumberValidate{

    public static void validateAmount(String input) throws IllegalArgumentException{
        try {
            isEmpty(input);
            isNumeric(input);
            isOverThousand(input);
            isDivisibleByThousand(input);
        } catch (NullPointerException | IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    public static void isOverThousand(String input) {
        int amount = Integer.parseInt(input);
        if (amount <= 1000) {
            throw new IllegalArgumentException("[ERROR] 최소금액은 1,000원 입니다.");
        }
    }

    public static void isDivisibleByThousand(String input){
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1,000으로 나누어 떨어지는 숫자를 입력해주세요.");
        }
    }

    public static void isEmpty(String input) {
        if (input == null || input.isEmpty() || input.contains(" ")) {
            throw new NullPointerException("[ERROR] 입력값이 null이거나 공백을 포함하고 있습니다.");
        }
    }
    public static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자만 입력해주세요.");
        }
    }


}
