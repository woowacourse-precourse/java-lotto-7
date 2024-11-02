package lotto.model;

import static lotto.constant.ErrorMessage.INVALID_LOTTO_MONEY_UNIT;
import static lotto.constant.ErrorMessage.NEGATIVE_MONEY;
import static lotto.constant.ErrorMessage.ZERO_LOTTO_MONEY;
import static lotto.constant.LottoInfo.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("== LottoPurchaseMoney 테스트 ==")
public class LottoPurchaseMoneyTest {
    @Nested
    @DisplayName("-- 기능 테스트 --")
    class FeatureTest {
        @ParameterizedTest
        @DisplayName("로또 개수로 변환")
        @MethodSource("moneyToLottoCountArguments")
        void 로또_개수로_변환(final int money, final int lottoCount) {
            LottoPurchaseMoney purchaseMoney = new LottoPurchaseMoney(money);

            assertThat(purchaseMoney.toLottoCount()).isEqualTo(lottoCount);
        }

        static Stream<Arguments> moneyToLottoCountArguments() {
            return Stream.of(
                    Arguments.of(LOTTO_PRICE, 1),
                    Arguments.of(LOTTO_PRICE * 3, 3),
                    Arguments.of(LOTTO_PRICE * 7, 7),
                    Arguments.of(LOTTO_PRICE * 10, 10)
            );
        }
    }

    @Nested
    @DisplayName("-- 예외 테스트 --")
    class ExceptionTest {
        @Test
        @DisplayName("0원")
        void 돈이_0원() {
            assertThatThrownBy(() -> new LottoPurchaseMoney(0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ZERO_LOTTO_MONEY.getMessage());
        }

        @ParameterizedTest
        @DisplayName("음수")
        @ValueSource(ints = {-1, -777, -15})
        void 돈이_음수(final int negativeMoney) {
            assertThatThrownBy(() -> new LottoPurchaseMoney(negativeMoney))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEGATIVE_MONEY.getMessage());
        }

        @ParameterizedTest
        @DisplayName("로또 가격 단위가 아님")
        @ValueSource(ints = {LOTTO_PRICE + 1, LOTTO_PRICE + 3, LOTTO_PRICE + 7})
        void 돈이_로또_가격_단위_아님(final int money) {
            assertThatThrownBy(() -> new LottoPurchaseMoney(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_LOTTO_MONEY_UNIT.getMessage());
        }
    }
}
