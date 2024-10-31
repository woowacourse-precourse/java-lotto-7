package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoPurchaseTest {

    @Test
    void 구입_금액이_0원_이하인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new UserLotto(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_1000원_단위가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new UserLotto(8500))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
