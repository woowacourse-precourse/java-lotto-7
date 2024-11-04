package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {
    @Test
    void 로또번호와_당첨번호_일치() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = List.of(1, 12, 13, 4, 5, 16);
        assertThat(countMatchingWinningNumbers(lottoNumbers, winningNumbers))
                .isEqualTo(3);
    }

    @DisplayName("당첨번호 6개와 보너스번호 0개가 일치")
    @Test
    void 로또_1등_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoService lottoService = new LottoService(winningNumbers, bonusNumber);
        assertThat(lottoService.match(lotto))
                .isEqualTo(Rank.FIRST);
    }

    @DisplayName("당첨번호 5개와 보너스번호 1개가 일치")
    @Test
    void 로또_2등_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 8);
        int bonusNumber = 6;

        LottoService lottoService = new LottoService(winningNumbers, bonusNumber);
        assertThat(lottoService.match(lotto))
                .isEqualTo(Rank.SECOND);
    }

    @DisplayName("당첨번호 5개와 보너스번호 0개가 일치")
    @Test
    void 로또_3등_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 45;

        LottoService lottoService = new LottoService(winningNumbers, bonusNumber);
        assertThat(lottoService.match(lotto))
                .isEqualTo(Rank.THIRD);
    }

    @DisplayName("당첨번호 4개와 보너스번호 0개가 일치")
    @Test
    void 로또_4등_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 7, 8);
        int bonusNumber = 45;

        LottoService lottoService = new LottoService(winningNumbers, bonusNumber);
        assertThat(lottoService.match(lotto))
                .isEqualTo(Rank.FOURTH);
    }

    @DisplayName("당첨번호 3개와 보너스번호 0개가 일치")
    @Test
    void 로또_5등_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        int bonusNumber = 45;

        LottoService lottoService = new LottoService(winningNumbers, bonusNumber);
        assertThat(lottoService.match(lotto))
                .isEqualTo(Rank.FIFTH);
    }

    @DisplayName("당첨번호 2개 이하와 보너스번호 0개가 일치")
    @Test
    void 로또_꽝_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 7, 8, 9, 10);
        int bonusNumber = 45;

        LottoService lottoService = new LottoService(winningNumbers, bonusNumber);
        assertThat(lottoService.match(lotto))
                .isEqualTo(Rank.NONE);
    }

    int countMatchingWinningNumbers(List<Integer> sourceNumbers, List<Integer> targetNumbers) {
        int count = 0;
        for (Integer targetNumber : targetNumbers) {
            if (sourceNumbers.contains(targetNumber)) {
                count++;
            }
        }
        return count;
    }

}
