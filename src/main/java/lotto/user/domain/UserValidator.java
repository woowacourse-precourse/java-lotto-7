package lotto.user.domain;

import lotto.lotto.domain.Lotto;

enum UserValidator {
    MULTIPLE_OF_THOUSAND {
        @Override
        public boolean check(int money) {
            return money % Lotto.PRICE == 0;
        }
    },

    OVER_THAN_ZERO {
        @Override
        public boolean check(int money) {
            return money >= 0;
        }
    },
    ;

    public abstract boolean check(int money);
}
