package lotto.console.domain;

public enum InputValidator {
    MONEY {
        @Override
        public boolean check(String input) {
            return input != null && input.matches(MONEY_REGEX);
        }
    },

    WIN_NUMBERS {
        @Override
        public boolean check(String input) {
            return input != null && input.matches(WIN_NUMBERS_REGEX);
        }
    },
    ;

    private static final String MONEY_REGEX = "^\\d+$";
    private static final String WIN_NUMBERS_REGEX = "^\\d+(?:,\\d+){5}$";

    public abstract boolean check(String input);
}
