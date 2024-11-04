package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("8개 로또 구매 후 5000원 당첨 시 수익률 62.5% 반환")
    void 수익률_계산(){
        Player player = Player.create(List.of(new Lotto(List.of(1, 23, 4, 5, 6, 7))), 8000);

        Assertions.assertThat(player.calculateReturnRate(5000L)).isEqualTo(62.5);
    }


}