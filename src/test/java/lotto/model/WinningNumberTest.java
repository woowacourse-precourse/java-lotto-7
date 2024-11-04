package lotto.model;

import lotto.dto.WinningNumberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningNumberTest {
    @DisplayName("당첨 번호 문자열이 쉼표로 구분되어 리스트로 올바르게 생성되었는지 확인")
    @Test
    public void 당첨_번호_생성_확인() {
        WinningNumberDto winningNumberDto = new WinningNumber("1,2,3,4,5,6", 8).toWinningNumberDto();

        assertThat(winningNumberDto.numbers()).hasSize(6);
        assertAll(
                () -> assertThat(winningNumberDto.numbers().get(0)).isEqualTo(1),
                () -> assertThat(winningNumberDto.numbers().get(2)).isEqualTo(3),
                () -> assertThat(winningNumberDto.numbers().get(5)).isEqualTo(6)
        );
    }
}
