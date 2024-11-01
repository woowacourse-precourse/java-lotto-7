package lotto.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

public class StringsToLottoNumbersConverterTest {

    @Test
    public void 문자에서_로또_숫자로_변환한다() {
        StringsToLottoNumbersConverter converter = new StringsToLottoNumbersConverter(List.of("1", "2", "3"));

        assertThat(converter.convert()).containsExactlyInAnyOrderElementsOf(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)));
    }
}
