package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoDrawTest {
    @Test
    @DisplayName("로또 발행 수 테스트")
    void testGenerateLotto() {
        LottoDraw lottoDraw = new LottoDraw(8);
        lottoDraw.generateLottos();
        assertEquals(lottoDraw.getPieces(), lottoDraw.getLottos().size());
    }

    @Test
    @DisplayName("당첨 번호가 정상적으로 받아졌는지 테스트")
    void testGetWinningNumbers() {
        LottoDraw lottoDraw = new LottoDraw(8);
        lottoDraw.generateLottos();
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;
        lottoDraw.setWinningNumbers(winningNumbers, bonusNumber);
        assertThat(lottoDraw.getWinningNumbers()).contains(1,2,3,4,5,6);
    }
}
