package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.model.LottoDrawMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoDrawMachineTest {

    private LottoDrawMachine lottoDrawMachine;
    private List<Integer> drawNumbers;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        drawNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
        lottoDrawMachine = new LottoDrawMachine(drawNumbers, bonusNumber);
    }

    @DisplayName("당첨 번호를 올바르게 반환하는지 확인")
    @Test
    void testGetWinningNumbers() {

        List<Integer> winningNumbers = lottoDrawMachine.getWinningNumbers();

        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호를 올바르게 반환하는지 확인")
    @Test
    void testGetBonusNumber() {
        int retrievedBonusNumber = lottoDrawMachine.getBonusNumber();

        assertThat(retrievedBonusNumber).isEqualTo(bonusNumber);
    }
}
