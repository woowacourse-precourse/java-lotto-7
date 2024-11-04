package lotto;

import static lotto.common.config.LottoRank.MATCH_5;
import static lotto.common.config.LottoRank.MATCH_5_BONUS;
import static lotto.common.config.LottoRank.MATCH_6;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.MatchResult;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    private WinningNumbers winningNumbers;
    private Integer bonusNumber;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        winningNumbers = new WinningNumbers(lotto, bonusNumber);
    }

    @Test
    void 모든_번호_일치() {
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        MatchResult result = winningNumbers.match(purchasedLotto);
        assertThat(result.getRank()).isEqualTo(MATCH_6);
    }

    @Test
    void 모든_번호_불일치() {
        Lotto purchasedLotto = new Lotto(List.of(11, 22, 33, 14, 15, 16));
        MatchResult result = winningNumbers.match(purchasedLotto);
        assertThat(result.getRank()).isEqualTo(null);
    }

    @Test
    void 일치_개수_5에_보너스_일치() {
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        MatchResult result = winningNumbers.match(purchasedLotto);
        assertThat(result.getRank()).isEqualTo(MATCH_5_BONUS);
    }

    @Test
    void 일치_개수_5에_보너스_불일치() {
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        MatchResult result = winningNumbers.match(purchasedLotto);
        assertThat(result.getRank()).isEqualTo(MATCH_5);
    }
}
