package lotto.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    @Test
    @DisplayName("로또 개수를 저장할 수 있다.")
    public void testPlayer() {
        // given
        int lottoCount = 10;

        // when
        player.updateLottoCount(10);

        // then
        assertThat(player.getLottoCount()).isEqualTo(lottoCount);
    }
}
