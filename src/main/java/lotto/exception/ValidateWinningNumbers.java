package lotto.exception;

public enum ValidateWinningNumbers {

    NOT_BLANK {
        @Override
        public boolean validateNumbers(String inputWinningNumbers) {
            if(inputWinningNumbers == null && inputWinningNumbers.isEmpty()) {
                throw new IllegalArgumentException(UserErrorMessage.ERROR_NOT_ALLOWED_BLANK);
            }
            return true;
        }
    },
    NOT_NUMBER {
        @Override
        public boolean validateNumbers(String winningNumber) {
            if(!winningNumber.matches("\\d+")) {
                throw new IllegalArgumentException(UserErrorMessage.ERROR_NON_NUMERIC_VALUE);
            }
            return true;
        }
    },
    NOT_INTEGER {
        @Override
        public boolean validateNumbers(String winningNumber) {
            try {
                Integer.parseInt(winningNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(UserErrorMessage.ERROR_NON_INTEGER_VALUE);
            }
            return true;
        }
    },
    NOT_IN_RANGE {
        @Override
        public boolean validateNumbers(String winningNumber) {
            if(Integer.parseInt(winningNumber) < 1 || Integer.parseInt(winningNumber) > 45) {
                throw new IllegalArgumentException(UserErrorMessage.ERROR_VALUE_NOT_IN_RANGE);
            }
            return true;
        }
    };

    public abstract boolean validateNumbers(String winningNumber);

}
