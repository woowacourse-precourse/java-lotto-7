package lotto;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGeneratorTest {

    @DisplayName("로또 랜덤 생성 예외 없는지 테스트")
    @Test
    void 로또_랜덤_생성_테스트() {
        final LottoGenerator lottoGenerator = new LottoGenerator();
        Assertions.assertDoesNotThrow(() -> lottoGenerator.random());
    }

    @DisplayName("투입 금액만큼 구매되도록 구현")
    @ParameterizedTest
    @MethodSource("구입금액데이터")
    void 로또_구매_기능_테스트(final int payment, final int count) {
        final LottoGenerator lottoGenerator = new LottoGenerator();
        final LottoPayment lottoPayment = new LottoPayment(new BigDecimal(payment));

        Assertions.assertEquals(lottoGenerator.generate(lottoPayment).getSize(), count);
    }

    static Stream<Arguments> 구입금액데이터() {
        return Stream.of(
                Arguments.of(1000, 1),
                Arguments.of(2000, 2),
                Arguments.of(1000000, 1000)
        );
    }
}