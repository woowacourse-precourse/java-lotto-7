package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.ProfitRateResultDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitRateTest {

    @Test
    @DisplayName("값 반환 테스트")
    void test1() {
        List<LottoNumber> lottoNumbers = LottoTest.toLottoNumList(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);
        List<Lotto> lottoArrayList = List.of(lotto);

        LottoTickets lottoTickets = new LottoTickets(lottoArrayList);
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,7,8,9");
        winnerLotto.addBonusNumber(new LottoNumber(10));

        WinnerStatus winnerStatus = WinnerStatus.create(lottoTickets, winnerLotto);
        Money money = new Money("5000");
        ProfitRateResultDto result = ProfitRate.create(money, winnerStatus).toDto();

        assertThat(result.resultMessage()).contains("100.0%");
    }

    /**
     * 반복적으로 로또 티켓을 생성하여 최대 수익률을 테스트하는 코드.
     * repeat 수를 INT 최대값으로 설정할 경우 OutOfMemory 발생
     * 5,000,000 반복 시 약 1초의 수행 시간이 소요됨.
     */

    @Disabled("최대 반복 테스트 - 메모리 부족 및 긴 소요 시간 발생")
    @Test
    @DisplayName("최대 수익률 테스트")
    void test2() {
        // given
        List<LottoNumber> lottoNumbers = LottoTest.toLottoNumList(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);
        List<Lotto> lottoArrayList = new ArrayList<>();
        int repeat = 5000000;
        for (int i = 0; i < repeat; i++) {
            lottoArrayList.add(lotto);
        }

        LottoTickets lottoTickets = new LottoTickets(lottoArrayList);
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6");
        winnerLotto.addBonusNumber(new LottoNumber(10));

        WinnerStatus winnerStatus = WinnerStatus.create(lottoTickets, winnerLotto);
        Money money = new Money("1000");

        // when
        ProfitRateResultDto result = ProfitRate.create(money, winnerStatus).toDto();

        // then
        assertThat(result.resultMessage()).contains("%");
    }
}
