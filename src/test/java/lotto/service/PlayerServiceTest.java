package lotto.service;

import lotto.domain.lotto.Bonus;
import lotto.Lotto;
import lotto.domain.player.Player;
import lotto.domain.player.PlayerLotto;
import lotto.domain.player.PlayerResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerServiceTest {

    private PlayerService playerService;
    private Player player;
    private Lotto lotto;
    private Bonus bonus;

    @BeforeEach
    public void setUp() {
        player = new Player();
        lotto = new Lotto();
        bonus = new Bonus();

        playerService = new PlayerService(player, lotto, bonus);

        lotto.addNumbers(List.of(1, 2, 3, 4, 5, 6));
        bonus.updateNumber(7);

        player.updateLottoCount(5);

        PlayerLotto playerLotto1 = new PlayerLotto(List.of(1, 2, 3, 4, 5, 6));
        PlayerLotto playerLotto2 = new PlayerLotto(List.of(1, 2, 3, 4, 5, 7));
        PlayerLotto playerLotto3 = new PlayerLotto(List.of(1, 2, 3, 4, 5, 8));
        PlayerLotto playerLotto4 = new PlayerLotto(List.of(1, 2, 3, 4, 8, 9));
        PlayerLotto playerLotto5 = new PlayerLotto(List.of(1, 2, 3, 8, 9, 10));

        playerService.calculateWinningCount(playerLotto1);
        playerService.calculateWinningCount(playerLotto2);
        playerService.calculateWinningCount(playerLotto3);
        playerService.calculateWinningCount(playerLotto4);
        playerService.calculateWinningCount(playerLotto5);

        player.addLotto(playerLotto1);
        player.addLotto(playerLotto2);
        player.addLotto(playerLotto3);
        player.addLotto(playerLotto4);
        player.addLotto(playerLotto5);
    }

    @Test
    @DisplayName("금액을 입력 받고 구매한 로또의 개수를 저장할 수 있다.")
    void 로또_구매_테스트() throws Exception {
        // given
        int price = 10000;

        // when
        int lottoCount = playerService.updateLottoCount(price);

        // then
        assertThat(lottoCount).isEqualTo(10);
    }

    @Test
    @DisplayName("구매할 수 있는 로또의 개수만큼 로또를 생성하고 저장할 수 있다.")
    void 로또_생성_테스트() throws Exception {
        // given
        int newLottoCount = 10;
        int initialLottoCount = player.getLottoCount();

        // when
        playerService.addLottos(newLottoCount);

        // then
        assertThat(player.getLottos().size()).isEqualTo(initialLottoCount + newLottoCount);
    }

    @Test
    @DisplayName("로또에서 당첨된 번호 개수를 알려줄 수 았다.")
    void 당첨_개수_확인_테스트() throws Exception {
        // given
        PlayerLotto playerLotto = new PlayerLotto(List.of(1, 2, 3, 4, 5, 7));

        // when
        playerService.calculateWinningCount(playerLotto);

        // then
        assertEquals(playerLotto.getWinningCount(), 5);
        assertEquals(playerLotto.getBonusCount(), 1);
    }

    @Test
    @DisplayName("당첨된 로또의 순위를 저장할 수 있다.")
    void 당첨_로또_순위_저장_테스트() throws Exception {
        // given
        List<PlayerLotto> playerLottos = player.getLottos();
        PlayerResult playerResult = player.getPlayerResult();

        // when
        playerService.calculateWinningRanks(playerLottos, playerResult);

        // then
        assertEquals(1, player.getPlayerResult().getFirstPlace());
        assertEquals(1, player.getPlayerResult().getSecondPlace());
        assertEquals(1, player.getPlayerResult().getThirdPlace());
        assertEquals(1, player.getPlayerResult().getFourthPlace());
        assertEquals(1, player.getPlayerResult().getFifthPlace());
    }

    @Test
    @DisplayName("당첨된 금액의 총합을 구할 수 있다")
    void 당첨_금액_계산_테스트() throws Exception {
        // given
        PlayerResult playerResult = new PlayerResult(1, 1, 1, 1, 1);

        // when
        long profit = playerService.calculateProfit(playerResult);

        // then
        assertThat(profit).isEqualTo(2031555000);
    }

    @Test
    @DisplayName("당첨된 금액의 총합으로 수익률을 구할 수 있다")
    void 수익률_계산_테스트() throws Exception {
        // given
        long profit = 2031555000;
        int price = 5000;

        // when
        float profitRate =  playerService.calculateProfitRate(price, profit);

        // then
        assertThat(profitRate).isEqualTo(40631100f);
    }

    @Test
    @DisplayName("당첨된 로또의 순위를 저장할 수 있다.")
    void 로또_결과_수정_테스트() throws Exception {
        // given & when
        playerService.updatePlayerResult(player);

        // then
        assertEquals(1, player.getPlayerResult().getFirstPlace());
        assertEquals(1, player.getPlayerResult().getSecondPlace());
        assertEquals(1, player.getPlayerResult().getThirdPlace());
        assertEquals(1, player.getPlayerResult().getFourthPlace());
        assertEquals(1, player.getPlayerResult().getFifthPlace());
        assertThat(player.getPlayerResult().getProfit()).isEqualTo(2031555000);
        assertThat(player.getPlayerResult().getProfitRate()).isEqualTo(40631100f);
    }

}
