package lotto.domain.player;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constant.Rank;
import lotto.random.LottoRandom;

@DisplayName("플레이어는")
class PlayerTest {

    private LottoRandom lottoRandom;

    @BeforeEach
    void setup() {
        lottoRandom = () -> List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또를_구입_금액에_맞게_구매한다() {
        Player player = new Player(3000);
        player.buyLottos(lottoRandom);
        assertThat(player.getLottoTicketCounts()).isEqualTo(3);
    }

    @Test
    void 구입_금액이_로또_가격으로_나누어떨어지지_않으면_예외를_반환한다() {
        assertThatThrownBy(() -> new Player(3333))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률을_올바르게_계산한다() {
        Player player = new Player(5000);
        player.buyLottos(lottoRandom);
        player.addRank(Rank.THIRD);
        assertThat(player.gain()).isEqualTo((double) 1_500_000 / 5_000 );
    }
}
