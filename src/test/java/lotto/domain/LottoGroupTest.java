package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

class LottoGroupTest {
    LottoGroup lottoGroup;
    List<Lotto> lottos;
    DrawNumbers drawNumbers;

    @BeforeEach
    void setUp() {
        lottos = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(4, 5, 6, 7, 8, 13)),
                new Lotto(List.of(4, 5, 6, 7, 8, 12)),
                new Lotto(List.of(4, 5, 6, 7, 8, 9)),
                new Lotto(List.of(4, 5, 6, 15, 16, 17))
        );

        lottoGroup=new LottoGroup(lottos);
        drawNumbers = new DrawNumbers(new WinningNumbers(List.of(4, 5, 6, 7, 8, 9)), new BonusNumber(13));
    }

    @Test
    void 등수를_잘_반환하는지_확인한다() {

        Map<Rank, Integer> expectedRank = new EnumMap<>(Rank.class);

        expectedRank.put(Rank.UNDER_TWO_HIT, 1);
        expectedRank.put(Rank.THREE_HIT, 1);
        expectedRank.put(Rank.FOUR_HIT, 0);
        expectedRank.put(Rank.FIVE_HIT_WITHOUT_BONUS, 1);
        expectedRank.put(Rank.FIVE_HIT_WITH_BONUS, 1);
        expectedRank.put(Rank.SIX_HIT, 1);

        assertThat(lottoGroup.getEachLottoPrize(drawNumbers.getWinningNumbers(),drawNumbers.getBonusNumber()))
                .isEqualTo(expectedRank);
    }

}