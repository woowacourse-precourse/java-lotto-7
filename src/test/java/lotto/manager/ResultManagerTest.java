package lotto.manager;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultManagerTest {
    static ResultManager resultManager;

    @BeforeAll
    static void setUp() {
         resultManager = new ResultManager();
         resultManager.changeWinningLotto(createLotto(1), 7);
    }

    @Test
    void 올바른_당첨_결과를_계산한다() {
        Player player = createAllRankPlayer();

        Result result = resultManager.getResult(player);

        assertThat(result.getReturnRate())
                .isEqualTo(Arrays.stream(Prize.values()).mapToInt(Prize::getMoney).sum() / 6000.0f);
        for (Prize prize : Prize.values()) {
            assertEquals(1, result.getImmutablePrizeCount().get(prize));
        }
    }

    static Lotto createLotto(int rank) {
        if (rank <= 2) {
            return new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5 + rank));
        }

        if (rank <= 5) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            for (int i = 0; i < rank - 2; i++) {
                numbers.set(5 - i, 45 - i);
            }
            return new Lotto(numbers);
        }

        return new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45));
    }

    static Player createAllRankPlayer() {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 1; i < 7; i++) {
            lottos.add(createLotto(i));
        }

        return new Player(lottos, 6000);
    }
}
