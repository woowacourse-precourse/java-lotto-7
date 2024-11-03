package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Collectors;
import lotto.core.domain.model.Lotto;
import lotto.core.domain.model.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationMultiTest extends NsTest {

    private Lottos lottos;
    private List<List<Integer>> arr;
    @BeforeEach
    public void setUp() {
        lottos = new Lottos();
        this.arr = lottos.buyLottoByTicketAmount(10).stream()
                .map(Lotto::getNumbersForMessage)
                .collect(Collectors.toList());
    }
    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(()->run("10000", "1,2,3,4,5,6", "7"), arr.get(0), arr.toArray(new List[0]));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
