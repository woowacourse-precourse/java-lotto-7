package lotto.model.draw;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class DrawTest {
    @Test
    void 당첨번호_보너스번호_입력테스트() {
        // given
        String drawNumberInput = "1,2,3,4,5,6";
        String bonusNumberInput = "7";

        // when
        DrawNumbers drawNumbers = new DrawNumbers(drawNumberInput);
        Draw draw = new Draw(drawNumbers, bonusNumberInput);
        DrawNumbers drawNumbersResult = draw.getDrawNumbers();
        Integer bonusNumberResult = draw.getBonusNumber();

        // then
        assertThat(drawNumbersResult.getDrawNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(bonusNumberResult).isEqualTo(7);
    }
}
