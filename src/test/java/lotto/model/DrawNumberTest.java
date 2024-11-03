package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class DrawNumberTest {
    @Test
    void 당첨번호_보너스번호_입력테스트() {
        // given
        String drawNumberInput = "1,2,3,4,5,6";
        String bonusNumberInput = "7";

        // when
        LottoNumbers drawNumbers = new LottoNumbers(drawNumberInput);
        DrawNumber drawNumber = new DrawNumber(drawNumbers, bonusNumberInput);
        LottoNumbers drawNumbersResult = drawNumber.getDrawNumbers();
        Integer bonusNumberResult = drawNumber.getBonusNumber();

        // then
        assertThat(drawNumbersResult.getLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(bonusNumberResult).isEqualTo(7);
    }
}
