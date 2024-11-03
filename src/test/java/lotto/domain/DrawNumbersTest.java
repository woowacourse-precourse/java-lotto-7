package lotto.domain;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DrawNumbersTest {

    @Test
    void 당첨번호와_보너스번호가_잘_저장되는지_확인(){
        DrawNumbers drawNumbers=new DrawNumbers(
                new WinningNumbers(List.of(1,2,3,4,5,6)),new BonusNumber(13));

        assertThat(drawNumbers).isInstanceOf(DrawNumbers.class);
    }

    @Test
    void 당첨번호와_보너스번호가_중복이면_예외_발생(){
        assertThatThrownBy(()->new DrawNumbers(
                new WinningNumbers(List.of(1,2,3,4,5,6)),new BonusNumber(5))).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_TO_WINNING_NUMBERS);
    }


}