package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoListTest {

    @Test
    void testGetMatchCounts() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 9)); // 6개 일치
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 일치 + 보너스
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8)); // 5개 일치
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 10, 11)); // 4개 일치
        Lotto lotto5 = new Lotto(List.of(7, 8, 6, 10, 11, 12)); // 0개 일치
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4, lotto5);
        LottoList lottoList = new LottoList(lottos);

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 9);
        int bonusNumber = 7;
        List<Integer> matchCounts = lottoList.getMatchCounts(winningNumbers, bonusNumber);

        assertThat(matchCounts).containsExactly(6, -1, 5, 4, 0);
    }
}