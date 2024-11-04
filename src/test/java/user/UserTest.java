package user;

import lotto.Lotto;
import lotto.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("총 당첨금 금액 구하기")
    @Test
    void getTotalLottoWinnings() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 43, 44, 45))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 8;

        User user = lottoMachine.checkLottos(lottos, winningNumbers, bonusNumber, new User());

        // when
        long totalLottoWinnings = user.getTotalLottoWinnings();

        // then
        assertThat(totalLottoWinnings).isEqualTo(2_000_005_000);
    }
}