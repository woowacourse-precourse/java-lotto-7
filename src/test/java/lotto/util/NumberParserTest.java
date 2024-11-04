package lotto.util;


import lotto.model.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class NumberParserTest {

    @Test
    void 문자열을_로또_번호로_분리한다() {

        String input = "1,2,3,4,5,6";

        List<LottoNumber> lottoNumbers = NumberParser.parseWinningNumbers(input);

        assertThat(lottoNumbers).contains(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
    }

}
