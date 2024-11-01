package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class WalletTest {

    @Test
    void 최소_구입_금액_미달시_예외_처리() {
        assertThatThrownBy(() -> new Wallet(100))
                .isInstanceOf(IllegalArgumentException.class);

    }


    @Test
    void 금액_단위가_맞지_않을시_예외_처리() {
        assertThatThrownBy(() -> new Wallet(1001))
                .isInstanceOf(IllegalArgumentException.class);

    }

}