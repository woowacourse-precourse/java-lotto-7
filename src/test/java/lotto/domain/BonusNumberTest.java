package lotto.domain;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    final int MIN_LOTTO_NUMBER = 1;
    final int MAX_LOTTO_NUMBER = 45;

    @Nested
    @DisplayName("객체 생성 테스트" )
    class CreateBonusNumberTest {
        @Test
        void 보너스_번호는_1과_45_사이의_숫자여야_한다() {
            // given
            String input = "7";

            // when & then
            assertDoesNotThrow(() -> new BonusNumber(winningLotto, input));
        }

        @Test
        void BonusNumber_는_하나의_보너스_번호를_가진다() {
            // given
            String input = "7";
            BonusNumber bonusNumber = new BonusNumber(winningLotto, input);

            // when
            int actual = bonusNumber.getNumber();
            int expected = 7;

            // then
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("예외 처리 테스트" )
    class BonusNumberExceptionTest {
        @Test
        void 보너스_번호가_범위_외의_숫자이면_예외가_발생한다() {
            // given
            String input = "46";

            // when & then
            assertThatThrownBy(() -> new BonusNumber(winningLotto, input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage(format("[ERROR] 보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }

        @Test
        void 당첨_번호와_중복된_번호가_입력되면_예외가_발생한다() {
            // given
            String input = "3";

            // when & then
            assertThatThrownBy(() -> new BonusNumber(winningLotto, input))
                    .isInstanceOf(LottoException.class)
                    .hasMessage("[ERROR] 당첨 번호와 중복된 번호입니다." );
        }
    }
}
