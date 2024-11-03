package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호가 유효한 범위라면 성공")
    void 보너스_번호_유요한_범위_정상_검증() {
        //given
        int validBonusNumber = 32;

        //when
        BonusNumber bonusNumber = new BonusNumber(validBonusNumber);

        //then
        assertThat(bonusNumber.getNumber()).isEqualTo(32);
    }

    @Test
    @DisplayName("보너스 번호가 범위 밖이라면 예외 발생")
    void 보너스_번호_범위_밖_예외_검증() {
        //given
        int invalidBonusNumber = 46;

        //when
        try {
            BonusNumber bonusNumber = new BonusNumber(invalidBonusNumber);
        } catch (LottoException e) {
            assertThat("[ERROR] 보너스 번호는 1~45 사이의 수를 입력하셔야 합니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatThrownBy(() -> new BonusNumber(invalidBonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_RANGE_ERROR.getErrorMessage());
    }
}
