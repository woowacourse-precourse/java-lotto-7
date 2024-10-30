package lotto;

import lotto.dto.InputDTO;


import lotto.service.InputDTOSaveService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SavingTest {

    private InputDTOSaveService inputDTOSaveService;
    private InputDTO inputDTO;

    @BeforeEach
    public void setUp() {
        inputDTOSaveService = new InputDTOSaveService();
        inputDTO = inputDTOSaveService.getInputDTO();
    }

    @Test
    public void 돈_입력_예외처리_전() {
        String money = "1000";
        inputDTOSaveService.setMoney(money);
        assertEquals(1000, inputDTO.getMoney(), "The money should be set correctly.");
    }

    @Test
    public void 입력받은_숫자들_합치기_예외처리_전() {
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "7";

        inputDTOSaveService.mergeAllNumbers(winningNumbers, bonusNumber);

        List<Integer> expectedAllNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertEquals(expectedAllNumbers, inputDTO.getAllNumbers(), "당첨 숫자는 보너스 숫자도 합쳐져야 합니다.");
    }
}
