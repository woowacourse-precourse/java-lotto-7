package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.ProfitRateResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitRateTest {

    @Test
    @DisplayName("값 반환 테스트")
    void test1() {
        List<LottoNum> lottoNums = LottoTest.toLottoNumList(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNums);
        List<Lotto> lottoArrayList = List.of(lotto);

        LottoList lottoList = new LottoList(lottoArrayList);
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,7,8,9");
        winnerLotto.addBonusNum(new LottoNum(10));

        WinnerCountList winnerCountList = WinnerCountList.of(lottoList, winnerLotto);
        WinnerStatus winnerStatus = WinnerStatus.create(winnerCountList);
        Money money = new Money("5000");
        ProfitRateResultDto result = ProfitRate.create(money, winnerStatus).toDto();

        assertThat(result.resultMessage()).contains("100.0%");
    }
}
