package lotto.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ErrorMessages;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    void purchaseAmountNotMultipleOfThousand() {
        LottoGenerator generator = new LottoGenerator();
        int purchaseAmount = 8500;
        assertThatThrownBy(() -> generator.purchaseLottos(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_PURCHASE_AMOUNT);
    }

    @Test
    @DisplayName("구입 금액이 1000원 미만인 경우 예외가 발생한다.")
    void purchaseAmountLessThanThousand() {
        LottoGenerator generator = new LottoGenerator();
        int purchaseAmount = 500;
        assertThatThrownBy(() -> generator.purchaseLottos(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_PURCHASE_AMOUNT);
    }

    @Test
    @DisplayName("로또가 정상적으로 생성된다.")
    void purchaseLottosSuccessfully() {
        LottoGenerator generator = new LottoGenerator();
        int purchaseAmount = 8000;
        generator.purchaseLottos(purchaseAmount);
        assertThat(generator.getLottos()).hasSize(8);
    }
}
