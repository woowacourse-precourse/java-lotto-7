package lotto;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber from(String input, Lotto correctNumber) {
        try {
            int bonusNumber = Integer.parseInt(input);
            validateDuplicate(bonusNumber, correctNumber);
            validateRange(bonusNumber);
            return new BonusNumber(bonusNumber);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45의 정수이어야 합니다.");
        }
    }

    private static void validateDuplicate(int number, Lotto correctNumber) {
        if(correctNumber.numbers().contains(number)){
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int number() {
        return this.number;
    }
}
