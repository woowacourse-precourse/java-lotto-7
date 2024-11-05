package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyDTOTest {

    @Test
    public void testValidMoneyCreation() {
        MoneyDTO moneyDTO = new MoneyDTO(1000);
        assertEquals(1000, moneyDTO.getMoney());
    }

    @Test
    public void testInvalidMoneyCreation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new MoneyDTO(0);
        });
        assertEquals("[ERROR] 금액은 0이나 음수가 되면 안됩니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new MoneyDTO(-1000);
        });
        assertEquals("[ERROR] 금액은 0이나 음수가 되면 안됩니다.", exception.getMessage());
    }

    @Test
    public void testSetMoneyWithValidValue() {
        MoneyDTO moneyDTO = new MoneyDTO(1000);
        moneyDTO.setMoney(2000);
        assertEquals(2000, moneyDTO.getMoney());
    }

    @Test
    public void testSetMoneyWithInvalidValue() {
        MoneyDTO moneyDTO = new MoneyDTO(1000);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            moneyDTO.setMoney(0);
        });
        assertEquals("[ERROR] 금액은 0이나 음수가 되면 안됩니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            moneyDTO.setMoney(-500);
        });
        assertEquals("[ERROR] 금액은 0이나 음수가 되면 안됩니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            moneyDTO.setMoney(500);
        });
        assertEquals("[ERROR] 금액은 1000원 단위여야 합니다.", exception.getMessage());
    }


}
