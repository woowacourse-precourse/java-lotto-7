package lotto.committee.drawsystem;

import java.util.List;
import lotto.MessageCenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DrawMachineTest {

    WinningNumbers winningNumbers = WinningNumbers.forTest();;
    DrawMachine drawMachine = DrawMachine.forTest(winningNumbers);
    List<Integer> mainNumbers = winningNumbers.getMainNumbers();
    Integer bonusNumber = winningNumbers.getBonusNumber();

    @Test
    @DisplayName("추첨 후 재추첨을 시도하면 예외가 발생한다.")
    void 추첨_후_재추첨을_시도하면_예외가_발생한다() {
        // 이미 beforeEach를 통해 추첨 완료
        assertThatThrownBy(() -> drawMachine.runDraw())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_NOTNULL.get());
    }
}
