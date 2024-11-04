package lotto.domain.number;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호 테스트")
class WinningLottoNumbersTest {

    @Nested
    @DisplayName("당첨 번호 생성")
    class WinningNumbersCreation {
        @Test
        @DisplayName("당첨 번호는 6개의 숫자여야 한다.")
        void 실패_당첨번호생성_5개() {
            List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);

            assertThatThrownBy(() -> new WinningLottoNumbers(invalidNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        @Test
        @DisplayName("당첨 번호는 1부터 45 사이의 숫자여야 한다.")
        void 실패_당첨번호_범위초과() {
            List<Integer> invalidNumbers = List.of(0, 1, 2, 3, 4, 46);

            assertThatThrownBy(() -> new WinningLottoNumbers(invalidNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 당첨 번호는 1이상 45이하여야 합니다.");
        }

        @Test
        @DisplayName("당첨 번호는 중복될 수 없다.")
        void 실패_당첨번호_중복() {
            List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5, 5);

            assertThatThrownBy(() -> new WinningLottoNumbers(invalidNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }

        @Test
        @DisplayName("유효한 당첨 번호가 입력되면 객체가 생성된다.")
        void 성공_당첨번호_유효한파라미터() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

            assertThatCode(() -> new WinningLottoNumbers(numbers))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("보너스 번호 검증")
    class BonusNumberValidation {
        @Test
        @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
        void 실패_보너스번호_당첨번호생성_중복값() {
            String winningNumbers = "1, 2, 3, 4, 5, 6";
            String duplicateNumber = "1";

            assertThatThrownBy(() ->
                    new WinningNumbers(WinningLottoNumbers.from(winningNumbers),
                            BonusNumber.from(duplicateNumber)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        @Test
        @DisplayName("보너스 번호와 당첨 번호가 올바르면 WinningNumbers 객체가 생성된다.")
        void 성공_보너스번호_당첨번호생성_유효한파라미터() {
            String winningNumbers = "1, 2, 3, 4, 5, 6";
            String bonusNumber = "7";

            assertThatCode(() ->
                    new WinningNumbers(WinningLottoNumbers.from(winningNumbers),
                            BonusNumber.from(bonusNumber)))
                    .doesNotThrowAnyException();
        }
    }
}
