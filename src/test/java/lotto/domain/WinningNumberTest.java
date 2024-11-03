package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @Test
    @DisplayName("정상적인 당첨 집합 검증")
    void 정상_당첨_집합_검증() {
        //given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        //when
        WinningNumber winningNumber = new WinningNumber(lotto, bonusNumber);

        //then
        assertThat(winningNumber.getWinningLotto().getNumbers()).isEqualTo(lotto.getNumbers());
        assertThat(winningNumber.getBonusNumber().getNumber()).isEqualTo(bonusNumber.getNumber());
    }

    @Test
    @DisplayName("당첨 집합 생성 시 중복 예외 검증")
    void 당첨_집합_생성_중복_예외_검증() {
        //given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(6);

        //when
        try {
            WinningNumber winningNumber = new WinningNumber(lotto, bonusNumber);
        } catch (LottoException e) {
            assertThat("[ERROR] 보너스 번호는 당첨 번호와 중복된 수 없이 입력하셔야 합니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatThrownBy(() -> new WinningNumber(lotto, bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_DUPLICATE_WINNING_LOTTO.getErrorMessage());
    }
}
