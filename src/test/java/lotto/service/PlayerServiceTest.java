package lotto.service;

import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.player.Player;
import lotto.domain.player.PlayerLotto;
import org.junit.jupiter.api.Assertions;
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
    }

    @Test
    @DisplayName("금액을 입력 받고 구매한 로또의 개수를 저장할 수 있다.")
    void 로또_구매_테스트() throws Exception {
        // given
        int price = 10000;

        // when
        playerService.updateLottoCount(price);

        // then
        assertThat(player.getLottoCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("구매할 수 있는 로또의 개수만큼 로또를 생성하고 저장할 수 있다.")
    void 로또_생성_테스트() throws Exception {
        // given
        int lottoCount = 10;

        // when
        playerService.addLottos(lottoCount);

        // then
        assertThat(player.getLottos().size()).isEqualTo(lottoCount);
    }

    @Test
    @DisplayName("로또에서 당첨된 번호 개수를 알려줄 수 았다.")
    void 당첨_개수_확인_테스트() throws Exception {
        // given
        lotto.addNumbers(List.of(1,2,3,4,5,6));
        bonus.updateNumber(7);
        PlayerLotto playerLotto = new PlayerLotto(List.of(1,2,3,4,5,7));

        // when
        playerService.calculateWinningCount(playerLotto);

        // then
        assertEquals(playerLotto.getWinningCount(), 5);
        assertEquals(playerLotto.getBonusCount(), 1);
    }

}
