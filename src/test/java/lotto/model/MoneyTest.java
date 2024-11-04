package lotto.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {

    @Test
    public void 로또_개수_계산_테스트() {
        Money money = new Money(5000);
        assertEquals(5, money.getLottoCount());
    }

    @Test
    public void 금액_반환_테스트() {
        Money money = new Money(7000);
        assertEquals(7000, money.getAmount());
    }
}
