package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.Rank;
import lotto.dto.LottoResult;
import lotto.dto.LottoResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerLottoTest {
    private final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    private final Lotto winningTicket = Lotto.of(numbers);

    @Test
    @DisplayName("고객의 로또와 당첨로또를 비교하면 해당하는 결과들이 나온다")
    void compareWinningLottoTest() {
        // given
        int number = 10;
        List<Lotto> tickets = new ArrayList<>(List.of(
                //1등 로또
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                //2등 로또
                Lotto.of(List.of(2, 3, 4, 5, 6, number)),
                //3등 로또
                Lotto.of(List.of(2, 3, 4, 5, 6, 7)),
                //4등 로또
                Lotto.of(List.of(3, 4, 5, 6, 7, 8)),
                //5등 로또
                Lotto.of(List.of(4, 5, 6, 7, 8, 9))
        ));
        CustomerLotto customerLotto = CustomerLotto.of(tickets);

        BonusNumber bonusNumber = BonusNumber.of(number, numbers);
        WinningLotto winningLotto = WinningLotto.of(winningTicket, bonusNumber);
        // when
        LottoResults lottoResults = customerLotto.compareWinningLotto(winningLotto);
        List<LottoResult> result = lottoResults.getResults();
        // then
        assertSoftly(softly -> {
            assertThat(result.get(0).getRank()).isEqualTo(Rank.FIRST);

            assertThat(result.get(1).getRank()).isEqualTo(Rank.SECOND);

            assertThat(result.get(2).getRank()).isEqualTo(Rank.THIRD);

            assertThat(result.get(3).getRank()).isEqualTo(Rank.FOURTH);

            assertThat(result.get(4).getRank()).isEqualTo(Rank.FIFTH);
        });

    }
}