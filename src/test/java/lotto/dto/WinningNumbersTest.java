package lotto.dto;

import lotto.exception.CustomIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.ErrorMessage.BONUS_NUMBER_DUPLICATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("보너스 번호가 당첨 번호에 포함되지 않으면 정상적으로 생성된다.")
        void 보너스_번호가_당첨_번호에_포함되지_않으면_정상적으로_생성된다() {
            List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 7;

            WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers, bonusNumber);

            assertThat(winningNumbers.lottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
            assertThat(winningNumbers.bonusNumber()).isEqualTo(bonusNumber);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @Test
        @DisplayName("보너스 번호가 당첨 번호에 포함될 경우 예외를 발생시킨다.")
        void 보너스_번호가_당첨_번호에_포함될_경우_예외를_발생시킨다() {
            List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 5;

            assertThatThrownBy(() -> new WinningNumbers(lottoNumbers, bonusNumber))
                    .isInstanceOf(CustomIllegalArgumentException.class)
                    .hasMessage(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
