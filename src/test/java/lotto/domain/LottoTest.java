package lotto.domain;

import java.util.stream.Stream;
import lotto.domain.exception.CustomErrorCode;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
class LottoTest {

    @ParameterizedTest
    @MethodSource("provideInvalidLottoSizes")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다(List<Integer> numbers) {
        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CustomErrorCode.EXCEPTION_LOTTO_SIZE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideDuplicateLottoNumbers")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다(List<Integer> numbers) {
        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CustomErrorCode.EXCEPTION_DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideOutOfRangeLottoNumbers")
    void 로또_번호에_범위를_벗어난_숫자가_있으면_예외가_발생한다(List<Integer> numbers) {
        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CustomErrorCode.EXCEPTION_LOTTO_RANGE.getMessage());
    }

    private static Stream<List<Integer>> provideInvalidLottoSizes() {
        return Stream.of(
                List.of(1, 2, 3, 4),
                List.of(1, 2, 3, 4, 5, 6, 7),
                List.of(1, 2, 3, 4, 5)
        );
    }

    private static Stream<List<Integer>> provideDuplicateLottoNumbers() {
        return Stream.of(
                List.of(1, 2, 3, 4, 4, 5),
                List.of(1, 1, 3, 4, 5, 6),
                List.of(1, 2, 3, 45, 45, 45)
        );
    }

    private static Stream<List<Integer>> provideOutOfRangeLottoNumbers() {
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 46),
                List.of(0, 2, 3, 4, 5, 45)
        );
    }


}
