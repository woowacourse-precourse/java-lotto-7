package lotto.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstantValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {
    @Test
    public void 돈을_입력받으면_금액에_맞게_로또를_여러개_뽑는다() throws Exception {
        //given
        int money = 3000;
        LottoMachine lottoMachine = new LottoMachine(money);

        //when
        int lottoCount = money / LottoConstantValue.LOTTO_PRICE.getValue();
        List<Lotto> lottoBundle = lottoMachine.multipleLottoGenerator();

        //then
        assertEquals(lottoMachine.getLottoCount(), lottoCount);
        assertEquals(lottoBundle.size(), lottoCount);
    }

    @Test
    public void 돈이_최대량을_초과하면_예외가_발생한다() throws Exception {
        //given
        int money = LottoConstantValue.LOTTO_MAX_PAYMENT.getValue() + 5000;

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> new LottoMachine(money),
                ErrorMessage.IS_PAYMENT_OVER_MAX_LIMIT_VALIDATOR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1, 999, 1001, 1010, 1100})
    public void 돈이_로또_가격으로_나누어_떨어지지_않으면_예외가_발생한다(int value) throws Exception {
        //given
        int money = value;

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> new LottoMachine(money),
                ErrorMessage.IS_PAYMENT_DIVISION_BY_LOTTO_PRICE_VALIDATOR.getMessage());
    }
}