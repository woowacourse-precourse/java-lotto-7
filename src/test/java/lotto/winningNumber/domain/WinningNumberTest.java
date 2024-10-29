package lotto.winningNumber.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import lotto.global.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumberTest {

    @Test
    @DisplayName("1~45 숫자 범위중에 중복되지 않은 숫자를 입력하면 생성할 수 있다")
    void createWiningNumber() throws Exception {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 45);
        int bonus = 7;

        // when
        WinningNumber winningNumber = new WinningNumber(numbers, bonus);

        // then
        assertThat(winningNumber).isNotNull()
                .extracting("numbers", "bonus")
                .containsExactlyInAnyOrder(numbers, bonus);

    }

    @ParameterizedTest
    @DisplayName("1~45 숫자 범위를 벗어나면 에러를 반환한다")
    @MethodSource("providedOutOfRange")
    void outOfRange(List<Integer> numbers, int bonus) throws Exception {

        // then
        assertThatThrownBy(() -> new WinningNumber(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
    }

    private static Stream<Arguments> providedOutOfRange() {
        return Stream.of(
                Arguments.arguments(List.of(0, 1, 2, 3, 4, 5), 6),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 46), 7)
        );
    }

    @ParameterizedTest
    @DisplayName("6자리가 아니라면 에러를 반환한다")
    @MethodSource("providedWrongCount")
    void notSix(List<Integer> numbers, int bonus) throws Exception {

        // then
        assertThatThrownBy(() -> new WinningNumber(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_COUNT.getMessage());
    }

    private static Stream<Arguments> providedWrongCount() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 5), 6),
                Arguments.arguments(List.of(2, 3, 4, 5, 6), 7)
        );
    }

    @ParameterizedTest
    @DisplayName("당첨번호에 중복된 숫자가 있다면 오류를 반환한다")
    @MethodSource("providedDuplicateNumber")
    void duplicateNumber(List<Integer> numbers, int bonus) throws Exception {

        // then
        assertThatThrownBy(() -> new WinningNumber(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    private static Stream<Arguments> providedDuplicateNumber() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 2, 3, 5, 7), 6),
                Arguments.arguments(List.of(2, 3, 4, 5, 6, 2), 7)
        );
    }

    @ParameterizedTest
    @DisplayName("당첨번호 중에 보너스 번호가 있다면 에러를 반환한다")
    @MethodSource("providedDuplicateBonus")
    void duplicateBonus(List<Integer> numbers, int bonus) throws Exception {

        // then
        assertThatThrownBy(() -> new WinningNumber(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    private static Stream<Arguments> providedDuplicateBonus() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 44, 3, 5, 7), 44),
                Arguments.arguments(List.of(2, 3, 4, 5, 6, 1), 5)
        );
    }

}