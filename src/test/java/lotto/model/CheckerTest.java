package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.constant.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckerTest {
    private WinningNumbers winningNumbers;
    private Checker checker;

    @BeforeEach
    public void setUp() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        checker = new Checker(winningNumbers);
    }

    @Test
    public void 모든_번호가_일치하면_제일_높은_등급의_로또_결과가_생성된다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoResult result = checker.check(lotto);

        assertThat(result.getLottoRank()).isEqualTo(LottoRank.FIRST.getRank());
    }

    @Test
    public void 보너스_번호_포함_6개의_숫자가_포함됐을_때를_확인하다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        LottoResult result = checker.check(lotto);

        assertThat(result.getLottoRank()).isEqualTo(LottoRank.SECOND.getRank());
    }

    @Test
    public void 보너스_번호_없이_5개만_일치했을_때를_확인한다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));

        LottoResult result = checker.check(lotto);

        assertThat(result.getLottoRank()).isEqualTo(LottoRank.THIRD.getRank());
    }
}
