package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.draw.LottoNumbers;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {
    @Test
    void 당첨번호_입력_테스트() {
        // given
        String drawNumberInput = "1,2,3,4,5,6";

        // when
        LottoNumbers drawNumbers = new LottoNumbers(drawNumberInput);
        List<Integer> lottoNumbers = drawNumbers.getLottoNumbers();

        // then
        assertThat(lottoNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
