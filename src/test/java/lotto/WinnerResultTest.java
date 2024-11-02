package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.Field;
import java.util.Map;
import lotto.constant.Rank;
import lotto.domain.WinnerResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinnerResultTest extends NsTest {
    private WinnerResult winnerResult;

    @BeforeEach()
    void setUp() {
        winnerResult = new WinnerResult(8000);
    }

    @Test
    void Rank를_등록하면_해당_랭크에_대한_당첨_내역이_증가한다() throws NoSuchFieldException, IllegalAccessException {
        Field winningResultField = WinnerResult.class.getDeclaredField("winningResult");
        winningResultField.setAccessible(true);
        Map<Rank, Integer> winningResultMap = (Map<Rank, Integer>) winningResultField.get(winnerResult);
        winnerResult.add(Rank.FIRST);
        winnerResult.add(Rank.FIRST);

        assertThat(winningResultMap.get(Rank.FIRST)).isEqualTo(2);
    }

    @Test
    void 당첨된_내역을_토대로_통계를_출력한다() {
        winnerResult.add(Rank.FIFTH);
        winnerResult.add(Rank.FOURTH);

        assertSimpleTest(() -> {
            winnerResult.display();
            assertThat(output()).contains("687.5%");
        });
    }

    @Override
    protected void runMain() {
    }
}
