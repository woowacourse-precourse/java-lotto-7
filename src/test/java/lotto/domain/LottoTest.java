package lotto.domain;

import static lotto.constants.LottoTicket.LOWER_BOUND;
import static lotto.constants.LottoTicket.NUMBERS_PER_LOTTO;
import static lotto.constants.LottoTicket.UPPER_BOUND;
import static lotto.exception.ErrorMessages.NUMBER_COUNT_MISMATCH;
import static lotto.exception.ErrorMessages.NUMBER_DUPLICATION;
import static lotto.exception.ErrorMessages.OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.ticket.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


@DisplayName("[Domain] Lotto")
public class LottoTest {

    @Nested
    @DisplayName("[validate] 로또 생성 시 번호 리스트의 유효성을 검증한다")
    class ValidateWhenCreateLottoTest{

        @Test
        @DisplayName("[create] 옳바른 형태의 리스트가 들어오면 정상적으로 로또가 생성된다")
        public void Given_ValidNumbers_When_CreateLotto_Then_NoException() {
            // Given
            List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6); // 유효한 번호 리스트

            // When & Then
            assertDoesNotThrow(() -> new Lotto(validNumbers)); // 예외가 발생하지 않아야 함
        }

        @Test
        @DisplayName("[Exception] 번호 개수가 일치하지 않는 경우 예외를 던진다.")
        public void Given_InvalidNumberCount_When_CreateLotto_Then_ThrowException() {
            // Given
            List<Integer> invalidCountNumbers = List.of(1, 2, 3); // 번호 개수 불일치

            // When & Then
            assertThatThrownBy(()-> new Lotto(invalidCountNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.format(NUMBER_COUNT_MISMATCH.getMessage(),NUMBERS_PER_LOTTO.getValue()));
        }

        @ParameterizedTest
        @MethodSource("outOfRangeNumbersProvider") // Given
        @DisplayName("[Exception] 로또 번호의 범위를 벗어난 숫자가 있을 경우 예외를 던진다.")
        public void Given_OutOfRangeNumbers_When_CreateLotto_Then_ThrowException(List<Integer> outOfRangeNumbers) {

            // When & Then
            assertThatThrownBy(() -> new Lotto(outOfRangeNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(String.format(OUT_OF_RANGE.getMessage(), LOWER_BOUND.getValue(), UPPER_BOUND.getValue()));
        }

        private static Stream<List<Integer>> outOfRangeNumbersProvider() {
            return Stream.of(
                    List.of(0, 1, 2, 3, 4, 5),
                    List.of(1, 2, 3, 4, 5, 51)
            );
        }

        @Test
        @DisplayName("[Exception] 로또 번호 중 중복된 숫자가 있을 경우 예외를 던진다.")
        public void Given_DuplicateNumbers_When_CreateLotto_Then_ThrowException() {
            // Given
            List<Integer> duplicateNumbers = List.of(1, 2, 3, 3, 5, 6); // 중복된 번호

            // When & Then
            assertThatThrownBy(()-> new Lotto(duplicateNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_DUPLICATION.getMessage());
        }
    }

    @Nested
    @DisplayName("[getNumbers] 로또의 번호들이 정상적으로 반환되는 지 확인한다")
    class GetNumbersTest{

        @Test
        @DisplayName("[return] 정상적으로 로또의 번호들을 반환한다")
        public void Given_ValidNumbers_When_GetNumbers_Then_ReturnNumbers() {
            //given
            List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

            //when
            Lotto lotto = new Lotto(validNumbers);

            //then
            assertThat(lotto.getNumbers()).isEqualTo(validNumbers);
        }

    }


}
