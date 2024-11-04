package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoVerificationTest {

    @DisplayName("로또 당첨 개수에 맞게 설정된다.")
    @Test
    void 기능_테스트_로또_당첨_개수() {
        LottoVerification lottoVerification = new LottoVerification(List.of(1,2,3,4,5,6), 7);

        // 일치하는 로또 번호 하나씩 생성
        List<Lotto> purchasedLottos = new ArrayList<>();
        purchasedLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        purchasedLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        purchasedLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        purchasedLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)));
        purchasedLottos.add(new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)));
        purchasedLottos.add(new Lotto(Arrays.asList(1, 2, 8, 9, 10, 11)));

        lottoVerification.calculateRank(purchasedLottos);
        Map<Rank, Integer> expectedRanks = new HashMap<>();
        expectedRanks.put(Rank.FIRST, 1);
        expectedRanks.put(Rank.SECOND, 1);
        expectedRanks.put(Rank.THIRD, 1);
        expectedRanks.put(Rank.FOURTH, 1);
        expectedRanks.put(Rank.FIFTH, 1);

        Map<Rank, Integer> actualRanks = new HashMap<>();
        actualRanks = lottoVerification.getRankCounts();

        // expectedRanks - actualRanks 비교
        for(Rank rank: expectedRanks.keySet()) {
            Integer expectedRank = expectedRanks.get(rank);
            Integer actualRank = actualRanks.get(rank);
            assertThat(expectedRank).isEqualTo(actualRank);
        }

    }
}
