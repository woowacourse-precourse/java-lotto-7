package lotto.util;

public class ErrorMessage {
    public static final String ERROR_EMPTY_PURCHASE_AMOUNT = "[ERROR] Purchase amount must not be empty.";
    public static final String ERROR_NON_INTEGER_PURCHASE_AMOUNT = "[ERROR] Purchase amount must be an integer.";
    public static final String ERROR_PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000 = "[ERROR] Purchase amount must be divisible by 1000.";

    public static final String ERROR_INVALID_LOTTO_LENGTH = "[ERROR] Lotto must contain exactly 6 numbers.";
    public static final String ERROR_LOTTO_NUMBER_OUT_OF_RANGE = "[ERROR] Lotto numbers must be between 1 and 45.";
    public static final String ERROR_DUPLICATE_LOTTO_NUMBER = "[ERROR] Lotto numbers must be unique.";

    public static final String ERROR_EMPTY_WINNING_NUMBERS = "[ERROR] Winning numbers must not be empty.";
    public static final String ERROR_INVALID_WINNING_NUMBERS_LENGTH = "[ERROR] Winning numbers must contain exactly 6 numbers.";
    public static final String ERROR_INVALID_WINNING_NUMBERS_FORMAT = "[ERROR] Winning numbers must be integers.";
    public static final String ERROR_WINNING_NUMBERS_OUT_OF_RANGE = "[ERROR] Winning numbers must be between 1 and 45.";
    public static final String ERROR_DUPLICATE_WINNING_NUMBER = "[ERROR] Winning numbers must be unique.";

    public static final String ERROR_EMPTY_BONUS_NUMBER = "[ERROR] Bonus number must not be empty.";
    public static final String ERROR_INVALID_BONUS_NUMBER_FORMAT = "[ERROR] Bonus number must be an integer.";
    public static final String ERROR_BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] Bonus number must be between 1 and 45.";
}
