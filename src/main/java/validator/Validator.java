package validator;

import utils.Pair;

public class Validator {
    public final Pair<Integer, Integer> LOTTO_NUMBER_SCOPE = new Pair<>(1, 45);

    public static void validateLong(String inputContent) {
        try {
            Long.parseLong(inputContent);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 정수가 아닙니다.");
        }
    }

    public static void validatePositiveNumber(String inputContent) {
        long convertedContent = Long.parseLong(inputContent);
        if (convertedContent <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 0 이하의 음수입니다.");
        }
    }

    public static void validateNumberInRange(Integer number, Pair<Integer, Integer> scope) {
        if (!isScope(number, scope)) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 범위에 맞지 않습니다.");
        }
    }

    private static boolean isScope(Integer number, Pair<Integer, Integer> scope) {
        if (scope.first != null && number < scope.first) {
            return false;
        }
        if (scope.second != null && number > scope.second) {
            return false;
        }
        return true;
    }

    public static void validatePurchasing(long criteriaMoney, int cost) {
        if (!isPurchaseAble(criteriaMoney, cost)) {
            throw new IllegalArgumentException("[ERROR] 잔액이 남습니다.");
        }
    }

    private static boolean isPurchaseAble(long criteriaMoney, int cost) {
        return criteriaMoney % cost == 0;
    }
}
