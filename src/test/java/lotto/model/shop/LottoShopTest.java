package lotto.model.shop;

import lotto.mock.number_generator.ChoosableRandomNumberMaker;
import lotto.mock.number_generator.RealRandomNumberGenerator;
import lotto.mock.number_generator.SequentialRandomNumberGenerator;
import lotto.model.Lottos;
import lotto.model.exception.PurchaseMoneyInvalidException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static lotto.model.LottosTest.getLottos;
import static org.assertj.core.api.Assertions.*;

@DisplayName("LottoShop 테스트")
public class LottoShopTest {

    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final LottoShop lottoShop = new LottoShop();
    private final SequentialRandomNumberGenerator sequentialRandomNumberGenerator = new SequentialRandomNumberGenerator();
    private final ChoosableRandomNumberMaker choosableRandomNumberMaker = new ChoosableRandomNumberMaker();
    private final RealRandomNumberGenerator realRandomNumberGenerator = new RealRandomNumberGenerator();

    static Stream<Arguments> 로또_구매_금액이_로또_가격의_배수가_아닐_경우_예외를_던진다_테스트_케이스() {
        return Stream.of(
                Arguments.of(LOTTO_PRICE + 1, true),
                Arguments.of(LOTTO_PRICE * 2, false),
                Arguments.of(LOTTO_PRICE, false),
                Arguments.of(LOTTO_PRICE - 1, true)
        );
    }

    @Test
    @DisplayName("로또 구매 금액이 로또 가격보다 작을 경우 예외를 던진다.")
    void purchaseRandomLottos_LottoMoneyTooSmall_ExceptionThrown() {
        // given
        int money = LOTTO_PRICE - 1;

        // when, then
        assertThatThrownBy(() -> lottoShop.purchaseRandomLottos(money, choosableRandomNumberMaker))
                .isInstanceOf(PurchaseMoneyInvalidException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "money: {0}, isExceptionThrown: {1}")
    @MethodSource("로또_구매_금액이_로또_가격의_배수가_아닐_경우_예외를_던진다_테스트_케이스")
    void 로또_구매_금액이_로또_가격의_배수가_아닐_경우_예외를_던진다(int money, boolean isExceptionThrown) {

        // when, then
        if (isExceptionThrown) {
            assertThatThrownBy(() -> lottoShop.purchaseRandomLottos(money, realRandomNumberGenerator))
                    .isInstanceOf(PurchaseMoneyInvalidException.class)
                    .isInstanceOf(IllegalArgumentException.class);
            return;
        }
        assertThatNoException().isThrownBy(() -> lottoShop.purchaseRandomLottos(money, realRandomNumberGenerator));
    }

    @ParameterizedTest(name = "expected: {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 로또_구매_금액이_정상적인_경우_가격만큼의_로또를_구매한다(int expected) {

        // given
        int money = LOTTO_PRICE * expected;
        sequentialRandomNumberGenerator.setSizeWillBeGenerated(LOTTO_NUMBER_COUNT);

        // when
        Lottos lottos = lottoShop.purchaseRandomLottos(money, sequentialRandomNumberGenerator);
        int actual = getLottos(lottos).size();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
