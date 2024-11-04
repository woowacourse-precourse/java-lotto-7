package lotto.exception;

public enum InputValidation {

    NOT_BLANK {
        @Override
        public boolean validate(String value) {
            if(value == null || value.isEmpty() || value.isBlank()) {
                try {
                    throw new IllegalArgumentException(UserErrorMessage.ERROR_NOT_ALLOWED_BLANK);
                } catch (IllegalArgumentException notBlank) {
                    System.out.println(notBlank.getMessage());
                    return false;
                }
            }
            return true;
        }
    },
    NOT_DIVISIBLE_BY_1000 {
        @Override
        public boolean validate(String value) {
            try {
                if(Integer.parseInt(value) % 1000 != 0) {
                    try {
                        throw new IllegalArgumentException(UserErrorMessage.ERROR_NOT_ALLOWED_VALUE);
                    } catch (IllegalArgumentException errorNotAllowedValue) {
                        System.out.println(errorNotAllowedValue.getMessage());
                        return false;
                    }
                }
                return true;
            } catch (NumberFormatException e) {
                if(!NOT_NUMBER.validate(value)) return false;
            }
            return true;
        }
    },
    NOT_NUMBER {
        @Override
        public boolean validate(String winningNumber) {
            if(!winningNumber.matches("\\d+")) {
                try {
                    throw new IllegalArgumentException(UserErrorMessage.ERROR_NON_NUMERIC_VALUE);
                } catch (IllegalArgumentException notNumeric) {
                    System.out.println(notNumeric.getMessage());
                    return false;
                }
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
                try {
                    throw new IllegalArgumentException(UserErrorMessage.ERROR_NON_INTEGER_VALUE);
                } catch (IllegalArgumentException notInteger) {
                    System.out.println(notInteger.getMessage());
                }
            }
            return true;
        }
    },
    NOT_IN_RANGE_1_TO_45 {
        @Override
        public boolean validate(String value) {
            if(Integer.parseInt(value) < 1 || Integer.parseInt(value) > 45) {
                try {
                    throw new IllegalArgumentException(UserErrorMessage.ERROR_VALUE_NOT_IN_RANGE);
                } catch (IllegalArgumentException notInRange) {
                    System.out.println(notInRange.getMessage());
                }
            }
            return true;
        }
    };

    public abstract boolean validate(String value);

}
