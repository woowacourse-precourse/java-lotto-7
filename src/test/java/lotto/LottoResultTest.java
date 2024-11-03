package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("로또 번호와 당첨 번호를 비교하여 당첨 결과를 계산한다.")
    @Test
    void 로또_당첨_결과를_계산한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,7");
        BonusNumber bonusNumber = new BonusNumber(6, winningNumbers);

        Rank rank = lotto.match(winningNumbers, bonusNumber);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
