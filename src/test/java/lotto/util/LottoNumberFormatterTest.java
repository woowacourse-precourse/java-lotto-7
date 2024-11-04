package lotto.util;


import lotto.model.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumberFormatterTest {

    @Test
    void 로또번호를_오름차순으로_정렬하고_출력형식으로_변경한다() {

        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(8),
                new LottoNumber(42),
                new LottoNumber(15),
                new LottoNumber(23),
                new LottoNumber(4),
                new LottoNumber(16)
        );

        String formattedNumbers = LottoNumberFormatter.formatLottoNumbers(lottoNumbers);

        assertThat(formattedNumbers).isEqualTo("[4, 8, 15, 16, 23, 42]");
    }

}
