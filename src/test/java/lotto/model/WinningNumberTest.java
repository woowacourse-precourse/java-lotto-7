package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningNumberTest {
    @DisplayName("당첨 번호 문자열이 쉼표로 구분되어 리스트로 올바르게 생성되었는지 확인")
    @Test
    public void 당첨_번호_생성_확인() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", 8);

        assertThat(winningNumber.getNumbers()).hasSize(6);
        assertAll(
                () -> assertThat(winningNumber.getNumbers().get(0)).isEqualTo(1),
                () -> assertThat(winningNumber.getNumbers().get(2)).isEqualTo(3),
                () -> assertThat(winningNumber.getNumbers().get(5)).isEqualTo(6)
        );
    }
}
