package lotto.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    void 로또_구입_금액_성공_테스트() {
        String input = "10000";
        Assertions.assertEquals(lottoService.extractLottoCount(input), 10);
    }

    @Test
    void 당첨_번호_성공_테스트() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertEquals(lottoService.extractWinningNumbers(input), lottoNumbers);
    }

    @Test
    void 보너스_번호_성공_테스트() {
        String input = "45";
        Assertions.assertEquals(lottoService.extractBonusNumber(input), 45);
    }
}