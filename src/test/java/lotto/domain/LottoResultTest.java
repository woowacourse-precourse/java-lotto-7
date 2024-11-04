package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @DisplayName("lottoResult를 생성했을 때, WinningPrice의 모든 값을 가지고 있어야한다")
    @Test
    void create_lotto_result() {
        LottoResult lottoResult = LottoResult.create();
        assertThat(lottoResult.getResult().size()).isEqualTo(WinningPrice.values().length);
    }

    @DisplayName("increaseWinningCount를 호출했을 경우, value의 값은 +1 증가되어야 한다")
    @Test
    void validate_increase_winning_count() {
        LottoResult lottoResult = LottoResult.create();

        lottoResult.increaseWinningCount(WinningPrice.FIFTH_PLACE);
        lottoResult.increaseWinningCount(WinningPrice.FIFTH_PLACE);

        lottoResult.increaseWinningCount(WinningPrice.SECOND_PLACE);

        Map<WinningPrice, Integer> result = lottoResult.getResult();

        assertThat(result.get(WinningPrice.FIFTH_PLACE)).isEqualTo(2);
        assertThat(result.get(WinningPrice.SECOND_PLACE)).isEqualTo(1);
    }

}
