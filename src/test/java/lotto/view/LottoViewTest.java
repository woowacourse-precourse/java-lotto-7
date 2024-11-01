package lotto.view;

import lotto.domain.MoneyDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LottoViewTest {

    private final LottoView lottoView = new LottoView();

    @Test
    public void testParseAndValidateInputWithEmptyString() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            lottoView.parseAndValidateInput("");
        });
        assertEquals("[ERROR] 잘못된 입력입니다. 금액을 입력해 주세요.", exception.getMessage());
    }

    @Test
    public void testParseAndValidateInputWithNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            lottoView.parseAndValidateInput(null);
        });
        assertEquals("[ERROR] 잘못된 입력입니다. 금액을 입력해 주세요.", exception.getMessage());
    }

    @Test
    public void testParseAndValidateInputWithNonNumericString() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            lottoView.parseAndValidateInput("abc");
        });
        assertEquals("[ERROR] 숫자를 입력해 주세요.", exception.getMessage());
    }

    @Test
    public void testParseAndValidateInputWithValidNumber() {
        int result = lottoView.parseAndValidateInput("1000");
        assertEquals(1000, result);
    }

    @Test
    public void testGetMoneyInputWithValidInput() {
        // readLine이 "1000"을 읽도록 설정
        String simulatedInput = "1000\n";
        System.setIn(new java.io.ByteArrayInputStream(simulatedInput.getBytes()));

        MoneyDTO moneyDTO = lottoView.getMoneyInput();
        assertEquals(1000, moneyDTO.getMoney());
    }
}
