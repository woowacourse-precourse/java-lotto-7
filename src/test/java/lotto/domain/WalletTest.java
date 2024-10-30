package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WalletTest {

    @Test
    void 최소_구입_금액_미달시_예외_처리(){
        assertThatThrownBy(() -> new Wallet(100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 최소 1,000원 입니다.");

    }


    @Test
    void 금액_단위가_맞지_않을시_예외_처리(){
        assertThatThrownBy(() -> new Wallet(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 구입 금액은 1,000원 단위로 입력해 주세요.");

    }

}