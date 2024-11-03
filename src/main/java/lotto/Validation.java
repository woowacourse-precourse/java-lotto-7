package lotto;

public class Validation {
    public static void validatePrice(String price) {
        if (price == null)
            throw new IllegalArgumentException("[ERROR] 금액은 필수입니다.");
        if (isNotDigit(price))
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해야 합니다.");
        if (!checkMinimumAndMultiple(Integer.parseInt(price)))
            throw new IllegalArgumentException("[ERROR] 로또의 단위금액은 1000원입니다.");
    }

    public static void validateWinningNumbers(String[] winningNumbers){
        if (winningNumbers == null)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 필수입니다.");
        if (winningNumbers.length != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        for (String number : winningNumbers){
            if (isNotDigit(number))
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로 입력해야 합니다.");
            if (isNotValidRange(Integer.parseInt(number)))
                throw new IllegalArgumentException("[ERROR] 당첨 번호 범위는 1~45까지여야 합니다.");
        }
    }

    public static void validateBonusNumbers(String bonusNumber) {
        if (bonusNumber == null)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 필수입니다.");
        if (isNotDigit(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
        if (isNotValidRange(Integer.parseInt(bonusNumber)))
            throw new IllegalArgumentException("[ERROR] 보너스 번호 범위는 1~45까지여야 합니다.");
    }

    private static boolean isNotDigit(String value){
        return !value.matches("^\\d+$");
    }

    private static boolean checkMinimumAndMultiple(int value){
        return value >= 1000 && value % 1000 == 0;
    }

    private static boolean isNotValidRange(int value){
        return !(value >= 1 && value <= 45);
    }
}
