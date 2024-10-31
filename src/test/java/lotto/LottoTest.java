package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Nested
    @DisplayName("추가기능 테스트")
    class 추가_기능_테스트 {

        private Lotto testLotto;

        @BeforeEach
        void setTestNumbers() {
            this.testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        }

        @ParameterizedTest(name = "({index}) {0} ==> true")
        @DisplayName("숫자가 포함되어 있다면 참을 반환한다.")
        @ValueSource(ints = {
                1, 2, 3, 4, 5, 6
        })
        void 숫자가_포함되어_있다면_참을_반환한다(
                // given
                int givenNotContainsNumber
        ) {
            // when
            boolean result = testLotto.contains(givenNotContainsNumber);

            // when & then
            assertThat(result).isTrue();
        }

        @ParameterizedTest(name = "({index}) {0} ==> true")
        @DisplayName("숫자가 포함되어 있지 않다면 거짓을 반환한다.")
        @ValueSource(ints = {
                7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
                37, 38, 39, 40, 41, 42, 43, 44, 45
        })
        void 숫자가_포함되어_있지_않다면_거짓을_반환한다(
            // given
            int givenNotContainsNumber
        ) {
            // when
            boolean result = testLotto.contains(givenNotContainsNumber);

            // when & then
            assertThat(result).isFalse();
        }

        @ParameterizedTest(name = "({index}) {0} ==> {1}")
        @DisplayName("올바른 일치하는 번호 갯수를 반환한다.")
        @MethodSource("argumentsForCountSameNumber")
        void 올바른_일치하는_번호_갯수를_반환한다(
                // given
                List<Integer> givenNumbers, int expected
        ){
            // when
            int result = testLotto.countSameNumber(givenNumbers);

            // then
            assertThat(result).isEqualTo(expected);
        }
        private static Stream<Arguments> argumentsForCountSameNumber() {
            return Stream.of(
                    Arguments.of(
                            List.of(6, 7, 8, 9, 10, 11), 1
                    ),
                    Arguments.of(
                            List.of(1, 2, 3, 4, 5, 6), 6
                    ),
                    Arguments.of(
                            List.of(7, 8, 9, 10, 11, 12), 0
                    )
            );
        }

    }
}
