package lotto.domain;

public class Money {
    private final Long money;

    public Money(String inputMoney) {
        validate(inputMoney);
        this.money = Long.parseLong(inputMoney);
    }

    private void validate(String inputMoney) {
        zeroValueCheck(inputMoney);
        long convertedMoney = convertToLongCheck(inputMoney);
        divideBy1000Check(convertedMoney);
    }

    private static void zeroValueCheck(String inputMoney) {
        if (inputMoney == null || inputMoney.isEmpty() || inputMoney.equals("0")) {
            throw new IllegalArgumentException(MoneyErrorConfig.ZERO_VALUE_ERROR.getErrorMessage());
        }
    }

    private static long convertToLongCheck(String inputMoney) {
        try {
            return Long.parseLong(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MoneyErrorConfig.STRING_TO_LONG_CONVERT_ERROR.getErrorMessage());
        }
    }

    private static void divideBy1000Check(long convertedMoney) {
        if (convertedMoney % 1000 != 0) {
            throw new IllegalArgumentException(MoneyErrorConfig.DIVIDE_1000_ERROR.getErrorMessage());
        }
    }

    public Long getMoney() {
        return money;
    }
}
