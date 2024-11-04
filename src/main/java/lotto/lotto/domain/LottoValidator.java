package lotto.lotto.domain;

import java.util.List;

public enum LottoValidator {

    NUMBERS_SIZE {
        @Override
        public boolean check(List<Integer> numbers) {
            return numbers.size() == LOTTO_NUMBERS_SIZE;
        }
    },

    DUPLICATED {
        @Override
        public boolean check(List<Integer> numbers) {
            return numbers.stream().distinct().count() == LOTTO_NUMBERS_SIZE;
        }
    },

    OUT_OF_RANGE {
        @Override
        public boolean check(List<Integer> numbers) {
            return numbers.stream().noneMatch(this::isOutOfRange);
        }

        private boolean isOutOfRange(int number) {
            return number < 1 || number > 45;
        }
    },
    ;

    private static final int LOTTO_NUMBERS_SIZE = 6;

    public abstract boolean check(List<Integer> numbers);
}
