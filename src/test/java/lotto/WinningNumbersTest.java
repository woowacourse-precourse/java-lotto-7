package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void seUp() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        lottoNumbers = new LottoNumbers(numbers, bonusNumber);
    }

    @Test
    void 당첨번호가_6개가_아니면_예외가_발생한다() {
        List<Integer> invalidWinningNumbers = Arrays.asList(1, 2, 3, 4, 5); // 5개만 넣어봄

        assertThatThrownBy(() -> new LottoNumbers(invalidWinningNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_중복되면_예외가_발생한다() {
        List<Integer> duplicateWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5); // 중복된 번호 5

        assertThatThrownBy(() -> new LottoNumbers(duplicateWinningNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber = 5; // 당첨 번호에 포함된 번호

        assertThatThrownBy(() -> new LottoNumbers(winningNumbers, duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호와_보너스번호가_정상적인_경우_객체가_생성된다() {
        List<Integer> validWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int validBonusNumber = 7;

        LottoNumbers winningNumbers = new LottoNumbers(validWinningNumbers, validBonusNumber);

        assertThat(winningNumbers).isNotNull();
    }

    @Test
    void 당첨번호와_일치하는_숫자_개수를_반환한다(){
        //6개 일치
        Lotto lottoWith6Matches = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int matchCount = lottoNumbers.countMatchingNumbers(lottoWith6Matches);
        assertThat(matchCount).isEqualTo(6);

        //0개 일치
        Lotto lottoWithZeroMatches = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));
        matchCount = lottoNumbers.countMatchingNumbers(lottoWithZeroMatches);
        assertThat(matchCount).isEqualTo(0);

        //3개 일치
        Lotto lottoWith3Matches = new Lotto(Arrays.asList(1, 2, 3, 14, 15, 16));
        matchCount = lottoNumbers.countMatchingNumbers(lottoWith3Matches);
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    void 보너스_번호가_포함되어_있는지_확인한다() {
        // 포함된 경우
        Lotto lottoWithBonusNumber = new Lotto(Arrays.asList(7, 10, 11, 12, 13, 14));
        boolean isBonusMatched = lottoNumbers.isBonusMatched(lottoWithBonusNumber);
        assertThat(isBonusMatched).isTrue();

        // 포함되지 않은 경우
        Lotto lottoWithoutBonusNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        isBonusMatched = lottoNumbers.isBonusMatched(lottoWithoutBonusNumber);
        assertThat(isBonusMatched).isFalse();
    }


}
