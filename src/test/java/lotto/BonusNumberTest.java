package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호 입력시 문자가 들어오면 예외가 발생한다")
    void 보너스_번호_입력시_문자가_들어오면_예외가_발생한다() {
        //given
        String number = "a";

        //when //then
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 입력시 로또 범위에 해당되지 않으면 예외가 발생한다")
    void 보너스_번호_입력시_로또_범위에_해당되지_않으면_예외가_발생한다() {
        //given
        String number = "46";

        //when //then
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 입력시 여러 번호를 입력하려 할 경우 예외가 발생한다")
    void 보너스_번호_입력시_여러_번호를_입력하려_할_경우_예외가_발생한다() {
        //given
        String number = "1,2,3";

        //when //then
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}