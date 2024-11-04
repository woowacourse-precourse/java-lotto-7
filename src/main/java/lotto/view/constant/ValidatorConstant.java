package lotto.view.constant;

import java.util.regex.Pattern;

public class ValidatorConstant {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
}
