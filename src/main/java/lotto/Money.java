package lotto;

public class Money {
    private static final int ZERO = 0;
    private static final int DIVISIBLE_UNIT = 1000;

    private final int amount;

    public Money(int amount){
        this.amount = amount;
    }

    private static void validate(int amount){
        validateIsNegative(amount);
        validateDivisible(amount);
    }

    private static void validateIsNegative(int amount){
        if(amount < ZERO)
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_NEGATIVE_EXCEPTION.getMessage());
    }

    private static void validateDivisible(int amount){
        if(amount % DIVISIBLE_UNIT != ZERO)
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_INPUT_EXCEPTION.getMessage());
    }

    public static int getAmount(int amount){
        validate(amount);
        return amount/DIVISIBLE_UNIT;
    }
}
