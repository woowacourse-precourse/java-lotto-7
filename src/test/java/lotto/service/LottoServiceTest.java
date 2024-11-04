package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Map;
import lotto.config.AppConfig;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Player;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private AppConfig appConfig = new AppConfig();
    private LottoService lottoService = appConfig.getLottoService();
    private Player player;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        player = new Player("10000");
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    void 로또_구매() {
        //given
        int money = 5000;

        //when
        lottoService.buyLotto(player, money);

        //then
        assertEquals(5, player.getLottoTickets().size());
    }

    @Test
    void 로또등수계산_정확한등수카운트() {
        //given
        Lotto firstRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto thirdRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto noRankLotto = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15));

        player.addLottoTickets(Arrays.asList(firstRankLotto, secondRankLotto, thirdRankLotto, noRankLotto));

        //when
        Map<LottoRank, Integer> rankCounts = lottoService.getLottoRankCounts(player, winningLotto);

        //then
        assertEquals(1, rankCounts.get(LottoRank.FIRST));
        assertEquals(1, rankCounts.get(LottoRank.SECOND));
        assertEquals(1, rankCounts.get(LottoRank.THIRD));
        assertEquals(1, rankCounts.get(LottoRank.OTHER));
    }

    @Test
    void 총상금계산_정확한총상금반환() {
        //given
        Lotto firstRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등
        Lotto secondRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등
        Lotto thirdRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 3등

        player.addLottoTickets(Arrays.asList(firstRankLotto, secondRankLotto, thirdRankLotto));

        //when
        int totalPrize = lottoService.getTotalPrize(player, winningLotto);

        //then
        int expectedTotalPrize = LottoRank.FIRST.getPrizeAmount() +
                LottoRank.SECOND.getPrizeAmount() +
                LottoRank.THIRD.getPrizeAmount();
        assertEquals(expectedTotalPrize, totalPrize);
    }

}