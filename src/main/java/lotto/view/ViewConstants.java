package lotto.view;

import java.util.regex.Pattern;

public class ViewConstants {
    public static final String HYPHEN = "-";
    public static final String VIEW_DELIMITER = ",";
    public static final String VIEW_DELIMITER_LABEL = "쉼표(,)";

    public static final String DIGITS = "0-9";

    public static final Pattern DIGIT_AND_DELIMITER_ONLY_PATTERN
            = Pattern.compile(String.format("^[%s%s]+$", DIGITS, VIEW_DELIMITER));
}
