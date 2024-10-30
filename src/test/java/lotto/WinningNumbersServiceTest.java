package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.WinningNumbers;
import lotto.service.WinningNumbersService;
import org.junit.jupiter.api.Test;

public class WinningNumbersServiceTest {

    @Test
    void 당첨번호_생성(){
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        String input = "1,2,3,4,5,6";
        WinningNumbers expect = new WinningNumbers(List.of(1,2,3,4,5,6));
        WinningNumbers actual = winningNumbersService.createWinningNumbers(input);

        assertEquals(expect, actual);
    }

}
