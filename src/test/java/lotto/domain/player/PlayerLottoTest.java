package lotto.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayerLottoTest {

    private PlayerLotto playerLotto;

    @BeforeEach
    public void setUp() {
        playerLotto = new PlayerLotto();
    }

    @Test
    @DisplayName("로또에 중복되지 않은 숫자 6개를 저장할 수 있다")
    void 로또_숫자_저장_테스트() throws Exception {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        playerLotto.updateLottoNumbers(lottoNumbers);

        // then
        Assertions.assertThat(playerLotto.getLottoNumbers()).containsExactly(1, 2, 3, 4, 5,6);
    }
}
