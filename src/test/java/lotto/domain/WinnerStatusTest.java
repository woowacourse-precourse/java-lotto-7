package lotto.domain;

import static lotto.utils.Reward.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerStatusTest {


    /**
     * expected =100000000 * 1등 상금 연산 => 20초 걸림
     */
    @Test
    @DisplayName("엄청 큰 수익률 발생시 에러 확인 테스트")
    void test1() {
        // given
        List<LottoNumber> lottoNumbers = LottoTest.toLottoNumList(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);
        int expected = 10000;
        List<Lotto> lottoArrayList = new ArrayList<>();

        for (int i = 0; i < expected; i++) {
            lottoArrayList.add(lotto);
        }

        LottoTickets lottoTickets = new LottoTickets(lottoArrayList);
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6");
        winnerLotto.addBonusNumber(new LottoNumber(7));

        BigDecimal sum = WinnerStatus.create(lottoTickets, winnerLotto).sum();

        assertThat(sum).isGreaterThan(BigDecimal.valueOf(expected));
    }

    @Test
    @DisplayName("값 확인 테스트")
    void test2() {
        List<LottoNumber> lottoNumbers = LottoTest.toLottoNumList(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);
        int cnt = 100;
        List<Lotto> lottoArrayList = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            lottoArrayList.add(lotto);
        }

        LottoTickets lottoTickets = new LottoTickets(lottoArrayList);
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,8");
        winnerLotto.addBonusNumber(new LottoNumber(7));

        BigDecimal result = WinnerStatus.create(lottoTickets, winnerLotto).sum();

        assertThat(result).isEqualTo(BigDecimal.valueOf(cnt).multiply(BigDecimal.valueOf(THIRD.getPrize())));
    }

    @Test
    @DisplayName("미당첨 0 반환 테스트")
    void test3() {
        List<LottoNumber> lottoNumbers = LottoTest.toLottoNumList(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);
        int cnt = 1000000;
        List<Lotto> lottoArrayList = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            lottoArrayList.add(lotto);
        }

        LottoTickets lottoTickets = new LottoTickets(lottoArrayList);
        WinnerLotto winnerLotto = new WinnerLotto("20,21,22,23,24,25");
        winnerLotto.addBonusNumber(new LottoNumber(7));

        BigDecimal result = WinnerStatus.create(lottoTickets, winnerLotto).sum();

        assertThat(result).isEqualTo(BigDecimal.ZERO);
    }


}
