package lotto.dto.result;

import static lotto.exception.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningNumbersTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("로또 번호가 올바른 형식일 경우 정상적으로 생성된다.")
        void 로또_번호_생성_성공() {
            List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

            WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers);

            assertThat(winningNumbers.lottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @Test
        @DisplayName("로또 번호가 null일 경우 예외를 발생시킨다.")
        void 로또_번호가_null일_경우_예외를_발생시킨다() {
            List<Integer> lottoNumbers = null;

            assertThatThrownBy(() -> new WinningNumbers(lottoNumbers))
                    .isInstanceOf(NullPointerException.class)
                    .hasMessage(NULL_LOTTO_NUMBERS.getMessage());
        }

        @Test
        @DisplayName("로또 번호가 빈 리스트일 경우 예외를 발생시킨다.")
        void 로또_번호가_빈_리스트일_경우_예외를_발생시킨다() {
            List<Integer> lottoNumbers = List.of();

            assertThatThrownBy(() -> new WinningNumbers(lottoNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(EMPTY_LOTTO_NUMBERS.getMessage());
        }

        @Test
        @DisplayName("로또 번호에 중복된 번호가 있을 경우 예외를 발생시킨다.")
        void 로또_번호에_중복이_있을_경우_예외를_발생시킨다() {
            List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 7, 7);

            assertThatThrownBy(() -> new WinningNumbers(lottoNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(DUPLICATE_NUMBER_IN_WINNING_NUMBERS.getMessage());
        }
    }
}
