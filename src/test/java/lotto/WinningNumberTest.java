package lotto;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class WinningNumberTest {

    @DisplayName("당첨 번호와 보너스 번호 중 중복되는 것이 있으면 예외가 발생한다,")
    @Test
    void 당첨_번호와_보너스_번호_중_중복되는_것이_있으면_예외가_발생한다() {
        assertAll(
            () -> assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> {
                WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
                winningNumber.setBonusNumber(6);
            }).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
