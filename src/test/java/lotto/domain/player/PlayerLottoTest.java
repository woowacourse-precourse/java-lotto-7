package lotto.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayerLottoTest {

    private PlayerLotto playerLotto;

    @Test
    @DisplayName("로또에 중복되지 않은 숫자 6개를 저장할 수 있다")
    void 로또_숫자_저장_테스트() throws Exception {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        playerLotto = new PlayerLotto(lottoNumbers);

        // then
        Assertions.assertThat(playerLotto.getLottoNumbers()).containsExactly(1, 2, 3, 4, 5,6);
    }

    @Test
    @DisplayName("당첨된 번호 개수를 저장할 수 있다.")
    void 당첨_개수_저장_테스트() throws Exception {
        // given
        int winningCount = 3;
        playerLotto = new PlayerLotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        for (int i = 0; i < winningCount; i++) {
            playerLotto.increaseWinningCount();
        }

        // then
        Assertions.assertThat(playerLotto.getWinningCount()).isEqualTo(winningCount);

    }

    @Test
    @DisplayName("보너스 번호를 맞춘지 여부 저장할 수 있다.")
    void 보너스_번호_테스트() throws Exception {
        // given
        int bonusCount = 1;
        playerLotto = new PlayerLotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        playerLotto.increaseBonusCount();

        // then
        Assertions.assertThat(playerLotto.getBonusCount()).isEqualTo(bonusCount);
    }
}
