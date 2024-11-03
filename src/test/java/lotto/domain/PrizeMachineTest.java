package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeMachineTest {
    PrizeMachine prizeMachine;
    List<Lotto> lottos;
    DrawNumbers drawNumbers;

    @BeforeEach
    void setUp(){
        lottos=List.of(
                new Lotto(List.of(1,2,3,10,11,12)),
                new Lotto(List.of(4,5,6,7,8,13)),
                new Lotto(List.of(4,5,6,7,8,12)),
                new Lotto(List.of(4,5,6,7,8,9)),
                new Lotto(List.of(4,5,6,15,16,17))
        );

        prizeMachine=new PrizeMachine(lottos);
        drawNumbers=new DrawNumbers(new WinningNumbers(List.of(4,5,6,7,8,9)),new BonusNumber(13));
    }

    @Test
    void 등수를_잘_반환하는지_확인한다(){

        Map<Rank, Integer> expected = new EnumMap<>(Rank.class);

        expected.put(Rank.UNDER_TWO_HIT, 1);
        expected.put(Rank.THREE_HIT, 1);
        expected.put(Rank.FOUR_HIT, 0);
        expected.put(Rank.FIVE_HIT_WITHOUT_BONUS, 1);
        expected.put(Rank.FIVE_HIT_WITH_BONUS, 1);
        expected.put(Rank.SIX_HIT, 1);

        assertThat(prizeMachine.getAmountOfPrize(drawNumbers))
                .isEqualTo(expected);
    }

}