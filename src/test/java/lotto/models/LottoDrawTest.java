package lotto.models;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.dto.BonusNumberRequestDTO;
import lotto.dto.WinningNumberRequestDTO;
import lotto.model.BonusNumber;
import lotto.model.LottoDraw;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoDrawTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복된 경우, 예외를 발생시킨다.")
    public void drawDuplicate() {
        assertThatThrownBy(() -> new LottoDraw(new WinningNumbers(new WinningNumberRequestDTO("1,2,3,4,5,6")),
                new BonusNumber(new BonusNumberRequestDTO("6")))).isInstanceOf(IllegalArgumentException.class);
    }
}
