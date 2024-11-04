package lotto.validation;

public class InputNumValidation {
    private static final String INPUT_NUM_NOT_DIVIDE_THOUSAND = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

    private static void isDivideThousand(String inputNum) throws IllegalArgumentException {
        long num = Long.parseLong(inputNum);

        if (num % 1000 != 0) {
            throw new IllegalArgumentException(INPUT_NUM_NOT_DIVIDE_THOUSAND);
        }
    }

    public static boolean checkInputNum(String inputNum) {
        try {
            isDivideThousand(inputNum);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
