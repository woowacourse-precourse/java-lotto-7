package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MethodTest {

    @DisplayName("구입한 금액 만큼의 로또 갯수를 반환한다.")
    @Test
    void test() {
        int expected = 12;
        int given = 12000;
        
        int result = Application.calculateLottoQuantity(given);

        assertEquals(expected, result);
    }
}
