package lotto.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

class IntegersToLottoNumbersConverterTest {
    @Test
    public void 숫자에서_로또_숫자로_변환한다() {
        IntegersToLottoNumbersConverter converter = new IntegersToLottoNumbersConverter(List.of(1, 2, 3));

        assertThat(converter.convert()).containsExactlyInAnyOrderElementsOf(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)));
    }
}
