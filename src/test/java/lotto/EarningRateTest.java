package lotto;

import java.util.List;
import lotto.model.Amount;
import lotto.model.EarningRate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EarningRateTest {
    @Test
    public void 수익률을_확인한다(){
        Amount amount = new Amount("8000");
        EarningRate earningRate =  new EarningRate(List.of(0,0,0,0,1),amount);
        assertEquals(62.5,earningRate.getEarningRate());
    }
}
