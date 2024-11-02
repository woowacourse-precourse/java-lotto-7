package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningLotto 테스트")
public class WinningLottoTest {

    @Test
    void 당첨번호와_보너스번호로_당첨로또를_생성한다() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        //when
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);

        //then
        assertThat(winningLotto.getWinningLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }
}
