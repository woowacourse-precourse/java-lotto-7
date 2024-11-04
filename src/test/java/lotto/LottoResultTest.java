package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    void 당첨번호와_보너스번호에_따른_당첨_결과_반환() {
        //Given
        LottoResult lottoResult = new LottoResult();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumbers = List.of(2,3,4,5,6,9);
        int bonus = 14;
        //When
        Rank result = lottoResult.getLottoResult(lotto,winningNumbers,bonus);
        //Then
        Assertions.assertThat(result).isEqualTo(Rank.THIRD);
    }

    @Test
    void 로또티켓_당첨결과_저장_테스트() {
        //Given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 10;

        List<Lotto> lottoTickets = new ArrayList<>();
        //2등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 10)));
        //3등
        lottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottoTickets.add(new Lotto(List.of(6, 2, 3, 4, 5, 8)));

        //When
        LottoResult lottoResult = new LottoResult();
        Map<Rank, Integer> result = lottoResult.getFinalResult(lottoTickets, winningNumbers, bonus);

        //Then
        Assertions.assertThat(result.get(Rank.FIRST)).isEqualTo(0);
        Assertions.assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        Assertions.assertThat(result.get(Rank.THIRD)).isEqualTo(2);
        Assertions.assertThat(result.get(Rank.FOURTH)).isEqualTo(0);
        Assertions.assertThat(result.get(Rank.FIFTH)).isEqualTo(0);
        Assertions.assertThat(result.get(Rank.NONE)).isEqualTo(0);
    }
}