package lotto.model;

import lotto.vo.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrizeTest {

    @Test
    void 수익률_계산() {
        Prize prize = new Prize(List.of(0, 0, 0, 0, 1), new Payment("8000"));

        assertEquals(62.5, prize.getProfitRate());
    }

    @Test
    void 투자금_0일_경우_수익률_계산() {
        Prize prize = new Prize(List.of(1, 0, 0, 0, 1), new Payment("0"));

        assertEquals(0, prize.getProfitRate());
    }
}
