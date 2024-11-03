package lotto.model.lotto;

public enum LottoNumber {
        VALID(1, 45);

        private final int min;
        private final int max;

        LottoNumber(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public boolean isValid(int number) {
            return number >= min && number <= max;
        }
    }
