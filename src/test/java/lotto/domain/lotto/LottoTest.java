package lotto.domain.lotto;

import java.util.stream.Stream;
import lotto.domain.Number;
import lotto.domain.lotto.FakeRandomNumber.FakeLottoNumberGenerator;
import lotto.domain.exception.CustomErrorCode;

import java.util.List;
import lotto.domain.lotto.random.CreateRandomNumbers;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
class LottoTest {

    private final CreateRandomNumbers createRandomNumbers = new FakeLottoNumberGenerator();

    @Test
    void 정상적인_번호를_가진_로또를_생성한다() {
        // given
        Lotto lotto = new Lotto(createRandomNumbers.getRandomNumbers());

        // when
        List<Integer> displayLotto = lotto.displayLotto()
                .stream()
                .map(Number::getNumber)
                .toList();

        // then
        assertThat(displayLotto.size()).isEqualTo(6);
        assertThat(displayLotto)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Nested
    class 예외_테스트를_진행한다 {

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
    }
}
