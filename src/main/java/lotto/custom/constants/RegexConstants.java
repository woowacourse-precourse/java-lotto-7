package lotto.custom.constants;

public class RegexConstants {
    public static final String DIGIT_ONLY_REGEX = "[0-9]+";

    public static final String DIGIT_COMMA_SPACE_ONLY_REGEX = "^[0-9,\\s]*$";

    public static final String DIGITS_SPACE_ONLY_REGEX = "^[0-9\\s]*$";

    public static final String CONSECUTIVE_COMMAS_REGEX = ",+";

    public static final String SINGLE_COMMA = ","; // 연속된 쉼표를 하나의 쉼표로 줄이는 표현식에 사용

    public static final String LEADING_TRAILING_COMMA_REGEX = "^,|,$";

    public static final String EMPTY_STRING = ""; // 앞뒤에 존재하는 쉼표를 제거하는 표현식에 사용
}