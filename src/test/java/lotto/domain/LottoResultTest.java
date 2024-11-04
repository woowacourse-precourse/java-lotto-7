package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {

    @Test
    @DisplayName("LottoResult는 당첨 번호와 보너스 번호를 정확하게 저장해야 한다.")
    void LottoResult는_당첨_번호와_보너스_번호를_정확하게_저장해야_한다() {
        List<Integer> winningNumbersSet = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> expectedWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoResult result = new LottoResult(winningNumbersSet, bonusNumber);

        List<Integer> actualWinningNumbers = result.getWinningNumbers();
        actualWinningNumbers.sort(Integer::compareTo); // 정렬하여 비교

        assertThat(actualWinningNumbers).isEqualTo(expectedWinningNumbers);
        assertThat(result.getBonusNumber()).isEqualTo(bonusNumber);
    }
}
