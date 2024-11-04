package lotto.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    @Test
    @DisplayName("Player 객체에 로또 개수를 저장할 수 있다.")
    void 로또_개수_저장_테스트() throws Exception {
        // given
        int lottoCount = 10;

        // when
        player.updateLottoCount(10);

        // then
        assertThat(player.getLottoCount()).isEqualTo(lottoCount);
    }

    @Test
    @DisplayName("Player 객체에 로또를 추가할 수 있다.")
    void 로또_추가_테스트() throws Exception {
        // given
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);
        PlayerLotto lotto = new PlayerLotto(lottoNumbers);

        // when
        player.addLotto(lotto);

        // then
        assertThat(player.getLottos().size()).isEqualTo(1);
    }

}
