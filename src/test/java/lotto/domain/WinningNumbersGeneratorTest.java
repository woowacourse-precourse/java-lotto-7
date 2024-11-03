package lotto.domain;

import lotto.dto.WinningNumbers;
import lotto.exception.CustomIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.exception.ErrorMessage.BONUS_NUMBER_DUPLICATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersGeneratorTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("정상적인 경우 당첨 번호와 보너스 번호를 올바르게 생성한다.")
        void 당첨_번호와_보너스_번호_생성_성공() {
            List<Integer> winningNumbersPool = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
            WinningNumbersGenerator generator = new WinningNumbersGenerator(winningNumbersPool);

            WinningNumbers winningNumbers = generator.generate();

            assertThat(winningNumbers.lottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
            assertThat(winningNumbers.bonusNumber()).isEqualTo(7);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @Test
        @DisplayName("보너스 번호가 당첨 번호에 포함될 경우 예외를 발생시킨다.")
        void 보너스_번호가_당첨_번호에_포함될_경우_예외() {
            List<Integer> winningNumbersPool = Arrays.asList(1, 2, 3, 4, 5, 7, 7);
            WinningNumbersGenerator generator = new WinningNumbersGenerator(winningNumbersPool);

            assertThatThrownBy(generator::generate)
                    .isInstanceOf(CustomIllegalArgumentException.class)
                    .hasMessage(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
