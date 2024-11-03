package lotto;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult;
    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() throws Exception {
        lottoResult = new LottoResult();

        // Rank Enum의 count 필드를 초기화
        for (Rank rank : Rank.values()) {
            Field countField = Rank.class.getDeclaredField("count");
            countField.setAccessible(true);
            countField.setInt(rank, 0);
        }

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        lottoNumbers = new LottoNumbers(numbers, bonusNumber);
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

        lottoResult.evaluateLottoResults(lottoTicket, lottoNumbers);

        assertThat(Rank.FIRST.getCount()).isEqualTo(1);
        assertThat(Rank.SECOND.getCount()).isEqualTo(1);
        assertThat(Rank.THIRD.getCount()).isEqualTo(1);
        assertThat(Rank.FOURTH.getCount()).isEqualTo(1);
        assertThat(Rank.FIFTH.getCount()).isEqualTo(1);
    }

    @Test
    void 수익률을_올바르게_계산한다() {
        Rank.FIFTH.increaseCount();// 5등 1회 당첨

        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);

        double rateOfReturn = lottoResult.calculateRateOfReturn(purchaseAmount);
        assertThat(rateOfReturn).isEqualTo(62.5);

    }

}
