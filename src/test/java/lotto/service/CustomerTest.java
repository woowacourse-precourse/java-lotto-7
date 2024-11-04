package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.constants.Ranking;
import lotto.constants.lottoType.CalculateType;
import lotto.constants.lottoType.LottoType;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoHandler;
import lotto.model.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest extends NsTest {

    private static int clientTestMoney = 10000;
    private Customer customer;
    private LottoHandler lottoHandler;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        lottoHandler = new LottoHandler();
    }

    @Test
    @DisplayName("구매 금액 만큼 티켓 구매 테스트")
    void 티켓_구매_테스트() {

        customer.buyLottoTickets(clientTestMoney);

        assertEquals(10,customer.getLottoTickets());
    }

    @Test
    @DisplayName("티켓 개수만큼 로또 구매하는지 테스트")
    void 티켓_개수만큼_로또_구매_테스트() {

        customer.buyLottoTickets(clientTestMoney);
        int expectedLottoTickets = clientTestMoney / LottoType.LOTTO_PRICE.getValue();

        lottoHandler.buyLottos(customer.getLottoTickets());
        List<Lottos> purchasedLottos = lottoHandler.getLottos();

        assertEquals(purchasedLottos.size(), expectedLottoTickets);
    }

    @Test
    @DisplayName("유저의 수익률 계산 테스트")
    void 수익률_계산_테스트() {
        customer.buyLottoTickets(clientTestMoney);
        lottoHandler.buyLottos(customer.getLottoTickets());
        customer.initializeRankingResults();

        customer.updateLottoRanking(Ranking.THREE);
        customer.updateLottoRanking(Ranking.THREE);

        double expectedYield = (Ranking.THREE.getWinnings() * 2)  / (double) clientTestMoney * CalculateType.PERCENT_100.getValue();
        double yield = customer.getWinningsYield(clientTestMoney);

        assertEquals(expectedYield, yield);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
