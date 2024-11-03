package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.message.ExceptionMessage;
import lotto.model.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void validateNumbersLengthTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBER_LENGTH_EXCEPTION);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void validateNumberDuplicationTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBER_DUPLICATION_EXCEPTION);
    }

    @DisplayName("로또 번호가 번호 범위를 넘길 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateInvalidAreaNumbers")
    void validateNumberAreaTest(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WINNING_NUMBER_AREA_EXCEPTION);
    }

    static Stream<Arguments> generateInvalidAreaNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 46)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 0))
        );
    }

    @DisplayName("정상 로또 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoNumbers")
    void validWinningNumberTest(List<Integer> numbers) {
        assertThatCode(() -> new Lotto(numbers)).doesNotThrowAnyException();
    }

    static Stream<Arguments> generateLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(2, 3, 4, 5, 6, 8)),
                Arguments.of(List.of(10, 11, 23, 24, 26, 27))
        );
    }

    @DisplayName("보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateDuplicationCaseOfBonusNumbers")
    void validateBonusNumberDuplicationTest(Lotto lotto, int bonusNumber) {
        assertThatThrownBy(() -> lotto.generateWinningLotto(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.BONUS_NUMBER_DUPLICATION_EXCEPTION);
    }

    static Stream<Arguments> generateDuplicationCaseOfBonusNumbers() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6)
        );
    }

    @DisplayName("보너스 번호가 번호 범위를 넘길 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateInvalidAreaCaseOfBonusNumbers")
    void validateBonusNumberAreaTest(Lotto lotto, int bonusNumber) {
        assertThatThrownBy(() -> lotto.generateWinningLotto(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.BONUS_NUMBER_AREA_EXCEPTION);
    }

    static Stream<Arguments> generateInvalidAreaCaseOfBonusNumbers() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46)
        );
    }

    @DisplayName("당첨 로또 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateWinningLotto")
    void generateWinningLottoTest(Lotto lotto, int bonusNumber) {
        assertThat(lotto.generateWinningLotto(bonusNumber)).isNotNull();
    }

    static Stream<Arguments> generateWinningLotto() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7)
        );
    }

}
