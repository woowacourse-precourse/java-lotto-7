package lotto.exception;

public enum InputValidation {

    NOT_BLANK {
        @Override
        public boolean validate(String value) {
            if(value == null || value.isEmpty() || value.isBlank()) {
                throw new IllegalArgumentException(UserErrorMessage.ERROR_NOT_ALLOWED_BLANK);
            }
            return true;
        }
    },
    NOT_DIVISIBLE_BY_1000 {
        @Override
        public boolean validate(String value) {
            try {
                int purchaseAmount = Integer.parseInt(value);
                if(purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException(UserErrorMessage.ERROR_NOT_ALLOWED_VALUE);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(UserErrorMessage.ERROR_NON_INTEGER_VALUE);
            }
            return true;
        }
    },
    NOT_NUMBER {
        @Override
        public boolean validate(String winningNumber) {
            if(!winningNumber.matches("\\d+")) {
                throw new IllegalArgumentException(UserErrorMessage.ERROR_NON_NUMERIC_VALUE);
            }
            return true;
        }
    },
    NOT_INTEGER {
        @Override
        public boolean validate(String value) {
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(UserErrorMessage.ERROR_NON_INTEGER_VALUE);
            }
            return true;
        }
    },
    NOT_IN_RANGE_1_TO_45 {
        @Override
        public boolean validate(String value) {
            if(Integer.parseInt(value) < 1 || Integer.parseInt(value) > 45) {
                throw new IllegalArgumentException(UserErrorMessage.ERROR_VALUE_NOT_IN_RANGE);
            }
            return true;
        }
    };

    public abstract boolean validate(String value);

}
