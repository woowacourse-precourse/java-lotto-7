package lotto.domain.buyer;

import static lotto.resources.Constants.THOUSND_UNIT;
import static lotto.resources.Constants.ZERO;
import static lotto.resources.ErrorMessages.INVALID_THOUSAND_UNIT_MONEY;
import static lotto.resources.ErrorMessages.NEGATIVE_QUANTITY_MONEY;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PurchaseCountTest {
    private static Stream<Arguments> provideMoneyTestCases() {
        return Stream.of(
                Arguments.of(ZERO, ZERO),
                Arguments.of(THOUSND_UNIT, 1),
                Arguments.of(THOUSND_UNIT * 10, 10),
                Arguments.of(THOUSND_UNIT * 100, 100)
        );
    }

    @DisplayName("1000원 단위로 떨어지지 않은 돈 액수를 입력하면 예외가 발생한다.")
    @Test
    void 돈_액수가_1000원_단위로_떨어지지않으면_예외가_발생한다() {
        assertThatThrownBy(() -> PurchaseCount.from(THOUSND_UNIT - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_THOUSAND_UNIT_MONEY.getMessage());
    }

    @DisplayName("돈 액수가 음수이면 예외가 발생한다.")
    @Test
    void 돈_액수가_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> PurchaseCount.from(-1 * THOUSND_UNIT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_QUANTITY_MONEY.getMessage());
    }

    @DisplayName("돈 액수에 따라 구매개수를 올바르게 계산한다.")
    @MethodSource("provideMoneyTestCases")
    @ParameterizedTest(name = "입력값: \"{0}\", 결과: \"{1}\"")
    void 돈_액수에_따라_구매개수를_올바르게_계산한다(int money, int result) {
        Assertions.assertThat(PurchaseCount.from(money).getPurchaseCount())
                .isEqualTo(result);
    }
}
