package lotto.domain;

import static lotto.constant.ExceptionMessage.DUPLICATE_NUMBER;
import static lotto.constant.ExceptionMessage.INVALID_SIZE;
import static lotto.constant.ExceptionMessage.NUMBER_OUT_OF_RANGE;
import static lotto.constant.LottoConstants.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.MINIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.NUMBERS_PER_TICKET;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    class 로또_생성_테스트 {
        @Test
        void 유효한_번호로_로또를_생성한다() {
            // given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

            // when
            Lotto lotto = Lotto.from(numbers);

            // then
            assertSoftly(softly -> {
                softly.assertThat(lotto.getNumbers()).hasSize(6);
                softly.assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
                softly.assertThat(lotto.getNumbers()).isSorted();
            });
        }

        @Test
        void 번호는_정렬되어_저장된다() {
            // given
            List<Integer> numbers = List.of(6, 1, 4, 3, 5, 2);

            // when
            Lotto lotto = Lotto.from(numbers);

            // then
            assertSoftly(softly -> {
                softly.assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
                softly.assertThat(lotto.getNumbers()).isSorted();
            });
        }

        @Test
        void 로또_번호는_불변이다() {
            // given
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
            Lotto lotto = Lotto.from(numbers);

            // when
            numbers.add(7);

            // then
            assertSoftly(softly -> {
                softly.assertThat(lotto.getNumbers()).hasSize(6);
                softly.assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
            });
        }
    }

    @Nested
    class 로또_번호_개수_검증_테스트 {
        @ParameterizedTest
        @MethodSource("provideTooFewNumbers")
        void 번호가_부족하면_예외가_발생한다(List<Integer> numbers) {
            assertThatThrownBy(() -> Lotto.from(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_SIZE.format(NUMBERS_PER_TICKET));
        }

        @ParameterizedTest
        @MethodSource("provideTooManyNumbers")
        void 번호가_초과되면_예외가_발생한다(List<Integer> numbers) {
            assertThatThrownBy(() -> Lotto.from(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_SIZE.format(NUMBERS_PER_TICKET));
        }

        private static Stream<List<Integer>> provideTooFewNumbers() {
            return Stream.of(
                    List.of(1, 2, 3, 4, 5),
                    List.of(1, 2, 3),
                    List.of(),
                    List.of(1)
            );
        }

        private static Stream<List<Integer>> provideTooManyNumbers() {
            return Stream.of(
                    List.of(1, 2, 3, 4, 5, 6, 7),
                    List.of(1, 2, 3, 4, 5, 6, 7, 8),
                    List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
            );
        }
    }

    @Nested
    class 로또_번호_범위_검증_테스트 {
        @ParameterizedTest
        @ValueSource(ints = {0, -1, -10, Integer.MIN_VALUE})
        void 최소_범위_미만의_번호가_있으면_예외가_발생한다(int invalidNumber) {
            // given
            List<Integer> numbers = Arrays.asList(invalidNumber, 2, 3, 4, 5, 6);

            // when & then
            assertThatThrownBy(() -> Lotto.from(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NUMBER_OUT_OF_RANGE.format(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
        }

        @ParameterizedTest
        @ValueSource(ints = {46, 50, 100, Integer.MAX_VALUE})
        void 최대_범위_초과의_번호가_있으면_예외가_발생한다(int invalidNumber) {
            // given
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, invalidNumber);

            // when & then
            assertThatThrownBy(() -> Lotto.from(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NUMBER_OUT_OF_RANGE.format(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
        }
    }

    @Nested
    class 로또_번호_중복_검증_테스트 {
        @Test
        void 중복된_번호가_있으면_예외가_발생한다() {
            // given
            List<Integer> numbers = List.of(1, 2, 3, 3, 4, 5);

            // when & then
            assertThatThrownBy(() -> Lotto.from(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(DUPLICATE_NUMBER.message());
        }

        @ParameterizedTest
        @MethodSource("provideDuplicateNumbers")
        void 여러_중복_패턴에_대해_예외가_발생한다(List<Integer> numbers) {
            assertThatThrownBy(() -> Lotto.from(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(DUPLICATE_NUMBER.message());
        }

        private static Stream<List<Integer>> provideDuplicateNumbers() {
            return Stream.of(
                    List.of(1, 1, 1, 1, 1, 1),  // 모두 동일
                    List.of(1, 2, 2, 3, 4, 5),  // 연속된 중복
                    List.of(1, 2, 3, 4, 5, 5),  // 마지막 중복
                    List.of(1, 1, 2, 2, 3, 3)   // 쌍으로 중복
            );
        }
    }

    @Test
    void 로또_번호_반환값은_불변이다() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        // when
        List<Integer> numbers = lotto.getNumbers();

        // then
        assertThatThrownBy(() -> numbers.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 경계값으로_로또를_생성한다() {
        // given
        List<Integer> numbers = List.of(
                MINIMUM_LOTTO_NUMBER,
                MINIMUM_LOTTO_NUMBER + 1,
                MAXIMUM_LOTTO_NUMBER - 2,
                MAXIMUM_LOTTO_NUMBER - 1,
                MAXIMUM_LOTTO_NUMBER,
                MAXIMUM_LOTTO_NUMBER - 3
        );

        // when
        Lotto lotto = Lotto.from(numbers);

        // then
        assertThat(lotto.getNumbers())
                .containsExactly(1, 2, 42, 43, 44, 45)
                .isSorted();
    }

    @Nested
    class 로또_번호_포함_여부_테스트 {
        @Test
        void 로또가_특정_번호를_포함하는지_확인한다() {
            // given
            Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber containedNumber = LottoNumber.from(1);
            LottoNumber notContainedNumber = LottoNumber.from(7);

            // when & then
            assertSoftly(softly -> {
                softly.assertThat(lotto.contains(containedNumber)).isTrue();
                softly.assertThat(lotto.contains(notContainedNumber)).isFalse();
            });
        }

        @Test
        void 로또_번호의_경계값_포함_여부를_확인한다() {
            // given
            Lotto lotto = Lotto.from(List.of(1, 2, 3, 43, 44, 45));
            LottoNumber minNumber = LottoNumber.from(MINIMUM_LOTTO_NUMBER);
            LottoNumber maxNumber = LottoNumber.from(MAXIMUM_LOTTO_NUMBER);
            LottoNumber middleNumber = LottoNumber.from(3);

            // when & then
            assertSoftly(softly -> {
                softly.assertThat(lotto.contains(minNumber)).isTrue();
                softly.assertThat(lotto.contains(maxNumber)).isTrue();
                softly.assertThat(lotto.contains(middleNumber)).isTrue();
            });
        }

        @Test
        void 정렬되어_있어도_번호_포함_여부를_정확히_확인한다() {
            // given
            Lotto lotto = Lotto.from(List.of(6, 1, 4, 3, 5, 2));  // 정렬: 1,2,3,4,5,6
            LottoNumber originalFirstNumber = LottoNumber.from(6);
            LottoNumber originalLastNumber = LottoNumber.from(2);

            // when & then
            assertSoftly(softly -> {
                softly.assertThat(lotto.contains(originalFirstNumber)).isTrue();
                softly.assertThat(lotto.contains(originalLastNumber)).isTrue();
                softly.assertThat(lotto.getNumbers()).isSorted();
            });
        }

        @Test
        void 여러_번호의_포함_여부를_순차적으로_확인한다() {
            // given
            Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
            List<LottoNumber> containedNumbers = List.of(
                    LottoNumber.from(1),
                    LottoNumber.from(3),
                    LottoNumber.from(6)
            );
            List<LottoNumber> notContainedNumbers = List.of(
                    LottoNumber.from(7),
                    LottoNumber.from(8),
                    LottoNumber.from(9)
            );

            // when & then
            assertSoftly(softly -> {
                softly.assertThat(containedNumbers).allMatch(lotto::contains);
                softly.assertThat(notContainedNumbers).noneMatch(lotto::contains);
            });
        }
    }
}
