package lotto.domain;

public class Bonus {

    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";

    private final int bonus;

    public Bonus(String invalidBonus, Lotto lotto) {
        validatePositiveNumber(invalidBonus);
        int bonus = parseMoneyToInteger(invalidBonus);
        validateRange(bonus);
        validateAlreadyExist(bonus, lotto);
        this.bonus = bonus;
    }

    private static void validatePositiveNumber(String invalidBonus) {
        if (!invalidBonus.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 양수만 입력이 가능합니다.");
        }
    }

    private static int parseMoneyToInteger(String invalidBonus) {
        try {
            return Integer.parseInt(invalidBonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 2,147,483,647보다 클 수 없습니다.");
        }
    }

    private static void validateRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private static void validateAlreadyExist(int bonus, Lotto lotto) {
        if (lotto.isExist(bonus)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int getBonus() {
        return this.bonus;
    }
}
