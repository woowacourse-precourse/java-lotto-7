package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult;
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        winningNumbers = new WinningNumbers(numbers, bonusNumber);
    }

    @Test
    void 로또_티켓을_평가하여_등수별_횟수를_정확하게_기록한다() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등 (보너스 일치)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), // 4등
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)) // 5등
        );
        LottoTicket lottoTicket = new LottoTicket(lottos);

        lottoResult.evaluateLottoResults(lottoTicket, winningNumbers);

        assertThat(Rank.FIRST.getCount()).isEqualTo(1);
        assertThat(Rank.SECOND.getCount()).isEqualTo(1);
        assertThat(Rank.THIRD.getCount()).isEqualTo(1);
        assertThat(Rank.FOURTH.getCount()).isEqualTo(1);
        assertThat(Rank.FIFTH.getCount()).isEqualTo(1);
    }
}
