package lotto.domain;

import lotto.domain.provider.DefinedNumberProvider;
import lotto.domain.provider.NullProvider;
import lotto.domain.validator.DefaultRangeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private final DefaultRangeValidator rangeValidator = new DefaultRangeValidator();

    @DisplayName("로또 번호의 개수가 6개보다 적거나 많으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideNumbersGreaterOrLess6InLength")
    void lottoHas6Numbers(List<Integer> numbers) {
        DefinedNumberProvider numberProvider = new DefinedNumberProvider(numbers);

        assertThatThrownBy(() -> new Lotto(numberProvider, rangeValidator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    private static Stream<Arguments> provideNumbersGreaterOrLess6InLength() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3, 4, 5))
        );
    }

    @DisplayName("로또 번호 리스트가 null이면 예외가 발생한다.")
    @Test
    void lottoNumberListCannotBeNull() {
        assertThatThrownBy(() -> new Lotto(new NullProvider(), rangeValidator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 NULL 일 수 없습니다.");
    }

    @DisplayName("로또 번호가 null이면 예외가 발생한다.")
    @Test
    void lottoNumberCannotBeNull() {
        DefinedNumberProvider numberProvider = new DefinedNumberProvider(null, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new Lotto(numberProvider, rangeValidator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 null 을 포함할 수 없습니다.");
    }

    @DisplayName("로또 번호가 1과 45 사이 범위를 넘어가면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("provideOutOfRangeNumbers")
    void lottoNumberShouldBeBetween1And45(List<Integer> numbers, Integer invalidNumber) {
        DefinedNumberProvider numberProvider = new DefinedNumberProvider(numbers);

        assertThatThrownBy(() -> new Lotto(numberProvider, rangeValidator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 ~ 45 사이의 숫자입니다. 잘못된 숫자 : %s", invalidNumber);
    }

    private static Stream<Arguments> provideOutOfRangeNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5), 0),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, -6), -6),
                Arguments.of(Arrays.asList(41, 42, 43, 44, 45, 46), 46)
        );
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void lottoHasUniqueNumbers() {
        DefinedNumberProvider numberProvider = new DefinedNumberProvider(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> new Lotto(numberProvider, rangeValidator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("로또가 특정 번호를 가졌는지 여부를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, true", "7, false"}, delimiter = ',')
    void returnLottoHasSpecificNumber(Integer number, boolean expected) {
        DefinedNumberProvider numberProvider = new DefinedNumberProvider(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numberProvider, rangeValidator);

        assertThat(lotto.hasNumber(number)).isEqualTo(expected);
    }

}
