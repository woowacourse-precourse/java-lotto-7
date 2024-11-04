package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    void 개수만큼_랜덤한_로또_객체가_생성된다() {
        int testLottoNumber = 8;
        LottoService lottoService = new LottoService(testLottoNumber);
        Assertions.assertThat(lottoService.getLotteries().size()).isEqualTo(8);
    }

    @Test
    void 당첨_통계를_확인한다() {
        //given
        int testLottoNumber = 8;
        LottoService lottoService = new LottoService(testLottoNumber);

        //when
        List<Integer> testWinningLottery = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            testWinningLottery.add(i);
        }
        int testBonusNumber = 7;

        lottoService.getStatistics(testWinningLottery, testBonusNumber);

        //then
        Assertions.assertThat(lottoService.getWinningCounts()).isNotNull();
    }
}
