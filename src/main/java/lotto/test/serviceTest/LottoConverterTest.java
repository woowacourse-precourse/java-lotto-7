package lotto.test.serviceTest;

import lotto.Lotto;
import lotto.service.LottoConverter;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoConverterTest {
    @Test
    public void testLottoIntoNumber() {
        assertThat(new LottoConverter().LottoIntoNumber(new Lotto(List.of(1,2,3,4,5,6)))).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    public void testMoneyIntoLotto() {
        assertThat(new LottoConverter().MoneyToLotto(BigInteger.valueOf(2000))).isEqualTo(BigInteger.valueOf(2));
    }

    @Test
    public void run(){
        testLottoIntoNumber();
        testMoneyIntoLotto();
    }
}
