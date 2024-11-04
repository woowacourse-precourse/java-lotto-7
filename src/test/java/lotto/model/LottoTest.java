package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.controller.error.ErrorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("로또 번호가 적절한 값이라면 생성된다.")
        void createLottoNumbers() {
            // given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

            // when
            Lotto lotto = new Lotto(numbers);

            // then
            assertThat(lotto.getNumbers()).isEqualTo(numbers);
        }

        @Test
        @DisplayName("문자열로 주어진 로또 번호로도 생성된다.")
        void createLottoNumbersFromString() {
            // given
            List<String> numbers = List.of("1", "2", "3", "4", "5", "6");

            // when
            Lotto lotto = Lotto.fromStringList(numbers);

            // then
            assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        }

        @Test
        @DisplayName("공백이 포함된 문자열로 주어진 로또 번호로도 생성된다.")
        void createLottoNumbersWithBlank() {
            // given
            List<String> numbers = List.of(" 1", "2  ", "  3", " 4", "5", " 6");

            // when
            Lotto lotto = Lotto.fromStringList(numbers);

            // then
            assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @Test
        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        void lottoNumbersExceedingLimit() {
            // given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

            // when & then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorType.INVALID_LOTTO_COUNT.getMessage());
        }

        @Test
        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        void lottoNumbersDuplicates() {
            // given
            int duplicateLottoNumber = 5;
            List<Integer> numbers = List.of(1, 2, 3, 4, duplicateLottoNumber, duplicateLottoNumber);

            // when & then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorType.DUPLICATE_NUMBER.getMessage());
        }

        @Test
        @DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
        void lottoNumbersOutOfRange() {
            // given
            int outOfRangeLottoNumber = Lotto.MAX_LOTTO_NUMBER + 1;
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, outOfRangeLottoNumber);

            // when & then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorType.OUT_OF_RANGE.getMessage());
        }

        @Test
        @DisplayName("로또 번호가 유효하지 않은 문자열이면 예외가 발생한다.")
        void lottoNumbersInvalidFormat() {
            // given
            String invalidLottoNumber = "abc";
            List<String> numbers = List.of("1", "2", "3", "4", "5", invalidLottoNumber);

            // when & then
            assertThatThrownBy(() -> Lotto.fromStringList(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorType.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
