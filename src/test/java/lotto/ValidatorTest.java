package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.util.LottoValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {-8000, 1750, 500, 333})
    void 구입_금액_입력_실패(int purchaseAmount) {
        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> providerLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5)),
                Arguments.of(Arrays.asList(1,2,3,4,5,5)),
                Arguments.of(Arrays.asList(1,2,3,4,5,67)),
                Arguments.of(Arrays.asList(1,2,3,4,5,0))
        );
    }

    @ParameterizedTest
    @MethodSource("providerLottoNumbers")
    void 당첨_번호_입력_실패(List<Integer> numbers) {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> providerBonusNumbers() {
        return Stream.of(
                Arguments.of(-1, Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(0, Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(46, Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(1, Arrays.asList(1, 2, 3, 4, 5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("providerBonusNumbers")
    void 보너스_번호_입력_실패(int bonusNumber, List<Integer> numbers) {
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(bonusNumber, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
