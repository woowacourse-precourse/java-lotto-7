package lotto.temp;

import lotto.model.WinningNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberGeneratorTest {

    private WinningNumberGenerator winningNumberGenerator;

    @BeforeEach
    void setUp() {
        winningNumberGenerator = new WinningNumberGenerator();
    }

    @Test
    @DisplayName("입력받은 당첨번호 콤마를 기준으로 분리")
    void separateWinningNumber(){
        assertThat(winningNumberGenerator.createWinningNumbers("1,2,3,4,5,6").getNumbers())
                .containsExactly(1,2,3,4,5,6);
        assertThat(winningNumberGenerator.createWinningNumbers("3,5,14,26,34,45").getNumbers())
                .containsExactly(3,5,14,26,34,45);
    }


}