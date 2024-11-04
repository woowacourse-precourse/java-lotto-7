package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @Test
    @DisplayName("로또 번호 - 성공 테스트")
    void testValidLottoNumber() {
        //given
        String input = "1, 2, 3, 4, 5, 6";

        //when
        Lotto lotto = Lotto.of(input);

        //then
        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @ParameterizedTest(name = "입력: ''{0}'', 메시지: {1}")
    @MethodSource("provideInvalidWinningNumbers")
    @DisplayName("잘못된 당첨 번호가 입력되면 예외가 발생한다.")
    void testInvalidWinningNumbers(String input, String errorMessage) {
        assertThatThrownBy(() -> Lotto.of(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(errorMessage);
    }

    private static Stream<Arguments> provideInvalidWinningNumbers() {
        return Stream.of(
                Arguments.of("", ErrorMessage.BLANK_WINNING_NUMBER.getMessage()),
                Arguments.of("1,2,a,4,5,6", ErrorMessage.NOT_NUMERIC_LOTTO_NUMBER.getMessage()),
                Arguments.of("1,2,3,1000000000000,4,5", ErrorMessage.TOO_BIG_INPUT.getMessage())
        );
    }

    @ParameterizedTest(name = "입력: ''{0}'', 메시지: {1}")
    @MethodSource("provideInvalidLottoNumbers")
    @DisplayName("잘못된 로또 번호가 입력되면 예외가 발생한다.")
    void testInvalidLottoNumbers(List<Integer> input, String errorMessage) {
        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(errorMessage);
    }

    private static Stream<Arguments> provideInvalidLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7), ErrorMessage.NOT_LOTTO_NUMBER_COUNT_SIX.getMessage()),
                Arguments.of(List.of(1, 2, 3, 4, 50, 5), ErrorMessage.OUT_RANGE_LOTTO_NUMBER.getMessage()),
                Arguments.of(List.of(1, 2, 3, 4, 5, 5), ErrorMessage.DUPLICATED_LOTTO_NUMBER.getMessage())
        );
    }
}
