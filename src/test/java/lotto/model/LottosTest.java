package lotto.model;

import lotto.enumerate.Rank;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {
    @Test
    void 로또의등수현황계산() {
        // given
        WinNumber winNumber = new WinNumber("1,2,3,4,5,6", "7");
        Lottos lottos = Lottos.init(List.of(List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)));

        Map<Rank, Integer> expectedRanks = new HashMap<>();
        expectedRanks.put(Rank.FIFTH, 1);
        expectedRanks.put(Rank.NONE, 7);

        // when
        System.out.println("=====Logic Start=====");

        Map<Rank, Integer> lottoRanks = lottos.findLottoRanks(winNumber);

        System.out.println("=====Logic End=====");
        // then
        assertEquals(expectedRanks, lottoRanks);
    }

    @Test
    void 초기화및로또개수테스트() {
        // given
        Lottos lottos = Lottos.init(List.of(List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)));

        // when
        System.out.println("=====Logic Start=====");

        System.out.println("=====Logic End=====");
        // then
        assertThat(lottos.getBuyLottoQuantity()).isEqualTo(8);

    }
}