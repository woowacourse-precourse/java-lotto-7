package lotto.service;

import lotto.domain.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {

    private LottoService lottoService;
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
        lottoService = new LottoService(player);
    }

    @Test
    @DisplayName("금액을 입력 받고 구매한 로또의 개수를 저장할 수 있다.")
    void 로또_구매_테스트() throws Exception {
        // given
        int price = 10000;

        // when
        lottoService.updateLottoCount(price);

        // then
        assertThat(player.getLottoCount()).isEqualTo(10);
    }
}
