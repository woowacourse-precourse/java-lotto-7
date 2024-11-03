package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class LottoResultTest {

    @Test
    @DisplayName("LottoResult는 당첨 번호와 보너스 번호를 정확하게 저장해야 한다.")
    void LottoResult는_당첨_번호와_보너스_번호를_정확하게_저장해야_한다() {
        Set<Integer> winningNumbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        LottoResult result = new LottoResult(winningNumbers, bonusNumber);

        assertThat(result.getWinningNumbers()).isEqualTo(winningNumbers);
        assertThat(result.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("LottoResult의 당첨 번호는 외부에서 변경될 수 없어야 한다.")
    void LottoResult의_당첨_번호는_외부에서_변경될_수_없어야_한다() {
        Set<Integer> winningNumbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        LottoResult result = new LottoResult(winningNumbers, bonusNumber);

        winningNumbers.add(7);
        assertThat(result.getWinningNumbers()).doesNotContain(7);
    }
}
