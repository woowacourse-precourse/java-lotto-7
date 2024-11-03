package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.constant.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.service.WinningNumbersService;
import org.junit.jupiter.api.Test;

public class WinningNumbersServiceTest {
    WinningNumbersService winningNumbersService = new WinningNumbersService();


    @Test
    void 당첨번호_생성() {
        String input = "1,2,3,4,5,6";
        WinningNumbers expect = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers actual = winningNumbersService.createWinningNumbers(input);

        assertEquals(expect, actual);
    }

    @Test
    void 로또_랭크_체크() {
        String input = "1,2,3,4,5,6";
        int bonus = 7;
        LottoRank expect = LottoRank.NONE;
        Lotto lotto = new Lotto(List.of(1, 8, 11, 31, 41, 42));

        WinningNumbersService winningNumbersService = new WinningNumbersService();

        WinningNumbers winningNumbers = winningNumbersService.createWinningNumbers(input);
        LottoRank actual = winningNumbersService.getLottoRank(lotto, winningNumbers, bonus);
        assertEquals(expect, actual);
    }


}
