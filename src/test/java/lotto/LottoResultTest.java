package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 로또티켓_당첨결과_저장_테스트() {
        //Given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonus = 10;

        List<Lotto> lottoTickets = new ArrayList<>();
        //2등
        lottoTickets.add(new Lotto(List.of(1,2,3,4,5,10)));
        //3등
        lottoTickets.add(new Lotto(List.of(1,2,3,4,5,8)));
        lottoTickets.add(new Lotto(List.of(6,2,3,4,5,8)));

        //When
        LottoResult lottoResult = new LottoResult();
        Map<Rank,Integer> result = lottoResult.getFinalResult(lottoTickets,winningNumbers,bonus);

        //Then
        Assertions.assertThat(result.get(Rank.FIRST)).isEqualTo(0);
        Assertions.assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        Assertions.assertThat(result.get(Rank.THIRD)).isEqualTo(2);
        Assertions.assertThat(result.get(Rank.FOURTH)).isEqualTo(0);
        Assertions.assertThat(result.get(Rank.FIFTH)).isEqualTo(0);
        Assertions.assertThat(result.get(Rank.NONE)).isEqualTo(0);
    }
}