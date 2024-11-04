package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @DisplayName("당첨 번호와 구매한 로또 번호를 비교하여 일치하는 번호의 개수를 반환한다")
    @Test
    void getMatchCount() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);

        LottoResult lottoResult = new LottoResult(winningNumbers, 7);
        assertThat(lottoResult.getMatchCount(lottoNumbers)).isEqualTo(5);
    }

    @DisplayName("보너스 번호 일치 여부를 확인한다")
    @Test
    void hasBonusNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);

        LottoResult lottoResult = new LottoResult(winningNumbers, 7);
        assertThat(lottoResult.hasBonusNumber(lottoNumbers)).isTrue();
    }

    @DisplayName("당첨 등수를 확인한다")
    @Test
    void checkRank() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);

        LottoResult lottoResult = new LottoResult(winningNumbers, 7);
        assertThat(lottoResult.getRank(lottoNumbers)).isEqualTo(2);
    }
}