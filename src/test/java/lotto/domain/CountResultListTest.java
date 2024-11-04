package lotto.domain;

import static lotto.utils.Reward.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountResultListTest {

    @Test
    @DisplayName("개수 확인 테스트")
    void test1() {
        // given
        List<LottoNumber> lottoNumbers = LottoTest.toLottoNumList(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);
        int expected = 50;
        List<Lotto> lottoArrayList = new ArrayList<>();

        for (int i = 0; i < expected; i++) {
            lottoArrayList.add(lotto);
        }

        LottoTickets lottoTickets = new LottoTickets(lottoArrayList);
        WinnerLotto winnerLotto = new WinnerLotto("1,3,4,5,6,7");
        winnerLotto.addBonusNumber(new LottoNumber(2));

        // when
        Integer result = CountResults.of(lottoTickets, winnerLotto)
                .calculateAllReward()
                .get(SECOND.getPrize());

        // then
        assertThat(result).isEqualTo(expected);
    }


}
