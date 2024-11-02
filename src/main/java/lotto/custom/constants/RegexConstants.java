package lotto.custom.constants;

public class RegexConstants {
    public static final String DIGIT_ONLY_REGEX = "[0-9]+";

    public static final String DIGIT_COMMA_SPACE_ONLY_REGEX = "^[0-9,\\s]*$";

    public static final String DIGIT_SPACE_DIGIT_REGEX = ".*\\d+\\s+\\d+.*";

    public static final String DIGITS_SPACE_ONLY_REGEX = "^[0-9\\s]*$";

    public static final String CONSECUTIVE_COMMAS_REGEX = ",+";

    public static final String LEADING_TRAILING_COMMA_REGEX = "^,|,$";

    public static final String EMPTY_STRING = "";

    public static final String SINGLE_COMMA = ",";
}
