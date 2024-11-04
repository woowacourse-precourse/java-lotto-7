package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.domain.LottoCount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoCountTest {
    @ParameterizedTest
    @MethodSource("testData")
    void 구매_금액에_따른_로또_갯수_생성(int purchaseAmount, int output) {
        LottoCount lottoCount = new LottoCount(purchaseAmount);
        assertThat(lottoCount.getCount()).isEqualTo(output);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 1001, 500, 0})
    void 구매_금액의_단위가_1000원이_아니면_예외가_발생한다(int purchaseAmount) {
        assertThatThrownBy(() -> new LottoCount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.arguments(1000, 1),
                Arguments.arguments(2000, 2),
                Arguments.arguments(9000, 9),
                Arguments.arguments(12000, 12)
        );
    }
}
