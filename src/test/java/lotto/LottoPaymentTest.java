package lotto;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPaymentTest {

    @DisplayName("로또 갯수 테스트")
    @ParameterizedTest
    @MethodSource("입금금액데이터")
    void 로또_갯수_테스트(final int amount, final int lottoCount) {
        final LottoPayment lottoPayment = new LottoPayment(new BigDecimal(amount));
        Assertions.assertThat(lottoPayment.getLottoCount())
                .isEqualTo(lottoCount);
    }

    @DisplayName("로또 1000원 단위가 아닐 때 에러 출력 테스트")
    @ParameterizedTest
    @MethodSource("잘못된입금데이터")
    void 로또_1000원_단위가_아닐_때_에러_출력_테스트(final int amount) {
        Assertions.assertThatThrownBy(() -> new LottoPayment(new BigDecimal(amount)));
    }

    static Stream<Arguments> 입금금액데이터() {
        return Stream.of(
                Arguments.of(15000, 15)
        );
    }

    static Stream<Arguments> 잘못된입금데이터() {
        return Stream.of(
                Arguments.of(15002),
                Arguments.of(-15002),
                Arguments.of(0)
        );
    }
}