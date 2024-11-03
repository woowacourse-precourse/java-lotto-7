package lotto.threaed;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import lotto.Application;
import lotto.core.domain.model.Lotto;
import lotto.core.domain.model.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationMultiTest extends NsTest {

    private Lottos lottos;
    private List<List<Integer>> arr;
    private int ticketAmount = 10000 ;
    private final String ticketCost = ticketAmount+"000";
    @BeforeEach
    protected void setUp() {
        lottos = new Lottos();
        this.arr = lottos.buyLottoByTicketAmount(ticketAmount).stream()
                .map(Lotto::getNumbersForMessage)
                .collect(Collectors.toList());
    }
    @Test
    protected void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(()->run(ticketCost, "1,2,3,4,5,6", "7"), arr.get(0), arr.toArray(new List[0]));
    }
    @Test
    protected void thread_pool_apply_test() {
        List<Lotto> testLottosResource = this.lottos.buyLottoByTicketAmount(ticketAmount);
        Lottos testLottos = new Lottos(testLottosResource);
        int coreCount = 3; // 기본 사용
        int maxPoolSize = coreCount * 2;
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(coreCount,maxPoolSize,60, TimeUnit.HOURS,queue);
        testLottos.matchUp(testLottosResource.get(0),testLottosResource.get(0).getNumbersForMessage().get(0),threadPool);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
