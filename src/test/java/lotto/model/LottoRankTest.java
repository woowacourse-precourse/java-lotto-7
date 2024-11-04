package lotto.model;

import lotto.model.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankTest {

    @Test
    @DisplayName("로또 번호와 당첨 번호의 일치 수를 계산한다")
    void 로또_번호와_당첨_번호의_일치_수를_계산한다() {
        // Given
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto myLotto = new Lotto(myNumbers);
        List<Integer> winningNumbers = Arrays.asList(4, 5, 6, 7, 8, 9);
        Lotto winningLotto = new Lotto(winningNumbers);

        // When
        int matchCount = myLotto.countMatches(winningLotto);

        // Then
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호와 일치여부를 확인한다")
    void 보너스_번호와_일치여부를_확인한다() {
        // Given
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto myLotto = new Lotto(myNumbers);
        int bonusNumber = 6;

        // When
        boolean isBonusMatched = myLotto.isBonusMatched(bonusNumber);

        // Then
        assertThat(isBonusMatched).isTrue();
    }

    @Test
    @DisplayName("보너스 번호와 일치하지 않으면 false 반환한다")
    void 보너스_번호가_일치하지_않으면_false를_반환한다() {
        // Given
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        Lotto myLotto = new Lotto(myNumbers);
        int bonusNumber = 6;

        // When
        boolean isBonusMatched = myLotto.isBonusMatched(bonusNumber);

        // Then
        assertThat(isBonusMatched).isFalse();
    }

    @Test
    @DisplayName("일치하는 번호 갯수와 보너스 번호 일치 유무에 따른 등수 출력")
    void 일치하는_번호_갯수와_보너스_번호_일치_유무에_따른_등수_출력() {
        assertEquals(LottoRank.FIRST, LottoRank.getRank(6, false));
        assertEquals(LottoRank.SECOND, LottoRank.getRank(5, true));
        assertEquals(LottoRank.THIRD, LottoRank.getRank(5, false));
        assertEquals(LottoRank.MISS, LottoRank.getRank(0, false));
    }

    @Test
    @DisplayName("각 순위별 상금 금액 확인")
    void 각_순위별_상금_금액_확인() {
        assertEquals(2000000000, LottoRank.FIRST.getPrice());
        assertEquals(30000000, LottoRank.SECOND.getPrice());
        assertEquals(1500000, LottoRank.THIRD.getPrice());
        assertEquals(50000, LottoRank.FOUR.getPrice());
        assertEquals(5000, LottoRank.FIVE.getPrice());
        assertEquals(0, LottoRank.MISS.getPrice());
    }

    @Test
    @DisplayName("각 순위별 메시지 출력 확인")
    void 각_순위별_메시지_출력_확인() {
        assertEquals("6개 일치 (2,000,000,000원)", LottoRank.FIRST.toString());
        assertEquals("5개 일치, 보너스 볼 일치 (30,000,000원)", LottoRank.SECOND.toString());
        assertEquals("5개 일치 (1,500,000원)", LottoRank.THIRD.toString());
        assertEquals("4개 일치 (50,000원)", LottoRank.FOUR.toString());
        assertEquals("3개 일치 (5,000원)", LottoRank.FIVE.toString());
        assertEquals("낙첨", LottoRank.MISS.toString());
    }
}
