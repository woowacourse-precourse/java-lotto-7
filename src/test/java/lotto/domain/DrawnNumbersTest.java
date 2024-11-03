package lotto.domain;

import lotto.error.LottoErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrawnNumbersTest {
    @Test
    void 보너스번호는_당첨번호와_중복될_수_없다() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(List.of("1", "2", "3", "4", "5", "6"));
        BonusNumber bonusNumber = new BonusNumber("2");

        //when & then
        Assertions.assertThatThrownBy(() -> new DrawnNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.DUPLICATED_NUMBER.getMessage());
    }

}