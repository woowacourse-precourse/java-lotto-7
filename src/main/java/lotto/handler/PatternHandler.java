package lotto.handler;

import java.util.regex.Pattern;

public class PatternHandler {
    public static final Pattern MONEY_PATTERN = Pattern.compile("\\d+");
    public static final Pattern WINNING_NUMBERS_PATTERN = Pattern.compile("^\\s*\\d+\\s*(,\\s*\\d+\\s*){5}$");
    public static final Pattern BONUS_NUMBER_PATTERN = Pattern.compile("\\d+");
}
