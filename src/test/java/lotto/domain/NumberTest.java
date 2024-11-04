package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;
import lotto.testUtil.testDouble.NumberPickerFake;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @Test
    void 로또번호를_생성한다() {
        //given
        int value = 30;

        //expected
        assertThatCode(() -> Number.from(value))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0})
    void 로또번호가_1보다_작으면_예외가_발생한다(int underMinimumValue) {
        //given

        //expected
        assertThatThrownBy(() -> Number.from(underMinimumValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 이상, 45 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {46, 100})
    void 로또번호가_45보다_크면_예외가_발생한다(int overMaximumValue) {
        //given

        //expected
        assertThatThrownBy(() -> Number.from(overMaximumValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 이상, 45 이하여야 합니다.");
    }

    @Test
    void 로또번호를_숫자들로_생성한다() {
        //given
        List<Integer> values = List.of(1, 2, 3, 4);

        //expected
        assertThatCode(() -> Number.from(values))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또번호를_숫자들로_생성할_때_null이면_예외가_발생한다() {
        //given
        List<Integer> values = null;

        //expected
        assertThatThrownBy(() -> Number.from(values))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number에 전달된 파라미터가 null입니다.");
    }

    @ParameterizedTest
    @MethodSource("provideNumbersWithLessThan1")
    void 로또번호를_숫자들로_생성할_때_1보다_작은_숫자가_있으면_예외가_발생한다(List<Integer> values) {
        //given

        //expected
        assertThatThrownBy(() -> Number.from(values))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 이상, 45 이하여야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("provideNumbersWithMoreThan45")
    void 로또번호를_숫자들로_생성할_때_45보다_큰_숫자가_있으면_예외가_발생한다(List<Integer> values) {
        //given

        //expected
        assertThatThrownBy(() -> Number.from(values))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 이상, 45 이하여야 합니다.");
    }

    @Test
    void NumberPicker를_통해_중복되지_않는_로또번호를_생성한다() {
        //given
        NumberPickerFake numberPickerFake = new NumberPickerFake();
        numberPickerFake.setNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int creationCount = 10;

        //when
        List<Number> result = Number.createUniqueNumbers(creationCount, numberPickerFake);

        //then
        assertThat(result.size()).isEqualTo(10);
        assertThat(new HashSet<>(result).size()).isEqualTo(10);
    }

    @Test
    void NumberPicker를_통해_생성시_45보다_많이_생성하려고_하면_예외가_발생한다() {
        //given
        NumberPickerFake numberPickerFake = new NumberPickerFake();
        numberPickerFake.setNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int creationCount = 46;

        //expected
        assertThatThrownBy(() -> Number.createUniqueNumbers(creationCount, numberPickerFake))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 한번에 45개까지 생성할 수 있습니다.");
    }

    @Test
    void NumberPicker를_통해_생성시_NumberPicker가_null이면_예외가_발생한다() {
        //given
        NumberPickerFake numberPickerFake = null;
        int creationCount = 10;

        //expected
        assertThatThrownBy(() -> Number.createUniqueNumbers(creationCount, numberPickerFake))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number에 전달된 파라미터가 null입니다.");
    }

    @Test
    void NumberPicker를_통해_생성시_count가_null이면_예외가_발생한다() {
        //given
        NumberPickerFake numberPickerFake = new NumberPickerFake();
        Integer creationCount = null;

        //expected
        assertThatThrownBy(() -> Number.createUniqueNumbers(creationCount, numberPickerFake))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number에 전달된 파라미터가 null입니다.");
    }

    @Test
    void 로또번호는_내부_값으로_비교된다() {
        //given
        int value = 30;
        Number sut = Number.from(value);

        //when
        Number target = Number.from(value);

        //then
        assertThat(sut).isEqualTo(target);
    }

    @Test
    void 로또번호를_다른_타입의_객체와_비교하면_거짓이다() {
        //given
        Number sut = Number.from(30);

        //when
        Object target = new Object();

        //then
        assertThat(sut).isNotEqualTo(target);
    }

    private static Stream<Arguments> provideNumbersWithLessThan1() {
        return Stream.of(
                Arguments.of(List.of(-100, 2, 3, 4, 5, 7)),
                Arguments.of(List.of(-1, 2, 3, 4, 5, 7)),
                Arguments.of(List.of(0, 2, 3, 4, 5, 7))
        );
    }

    private static Stream<Arguments> provideNumbersWithMoreThan45() {
        return Stream.of(
                Arguments.of(List.of(-100, 2, 3, 4, 5, 7)),
                Arguments.of(List.of(-1, 2, 3, 4, 5, 7)),
                Arguments.of(List.of(0, 2, 3, 4, 5, 7))
        );
    }
}
