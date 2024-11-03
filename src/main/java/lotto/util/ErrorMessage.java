package lotto.util;

public class ErrorMessage {
    public static final String EMPTY_PURCHASE_AMOUNT_STRING_ERROR = "[ERROR] Purchase Amount Input is empty";
    public static final String NOT_INTEGER_STRING_ERROR = "[ERROR] Purchase Amount is not Integer Format";
    public static final String NOT_DIVISIBLE_BY_1000_ERROR = "[ERROR] Purchase Amount is not divisible by 1000";

    public static final String EMPTY_WINNING_NUMBERS_STRING_ERROR = "[ERROR] Winning Numbers Input is empty";
    public static final String INVALID_WINNING_NUMBERS_LENGTH_ERROR = "[ERROR] Winning Numbers has invalid length";
    public static final String INVALID_WINNING_NUMBERS_FORMAT_ERROR = "[ERROR] Winning Number is not Integer";
    public static final String INVALID_RANGE_WINNING_NUMBERS_ERROR = "[ERROR] Winning Numbers is not between 1-45";
    public static final String DUPLICATED_WINNING_NUMBERS_ERROR = "[ERROR] Winning Numbers is duplicated";

    public static final String EMPTY_BONUS_NUMBER_STRING_ERROR = "[ERROR] Bonus Number Input is empty";
    public static final String INVALID_BONUS_NUMBER_FORMAT_ERROR = "[ERROR] Bonus Number is not Integer";
    public static final String INVALID_BONUS_NUMBER_RANGE_ERROR = "[ERROR] Bonus Number is not between 1-45";
}
