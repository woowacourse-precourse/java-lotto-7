package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningNumbers;
import lotto.service.Calculator;
import lotto.service.LottoResult;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    void 로또_결과_출력_형식과_반환율_확인() {
        //Given
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(9, 10, 11, 12, 13, 14), 7);
        List<Lotto> purchasedLotto = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), //6개 일치(1등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), //5개 + 보너스 일치(2등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), //5개 일치(3등)
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), //4개 일치(4등)
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)) //3개 일치(5등)
        );
        Calculator calculator = new Calculator(winningNumbers);

        //When
        LottoResult lottoResult = new LottoResult(purchasedLotto, winningNumbers, calculator);
        Map<Ranking, Long> results = lottoResult.getResults();
        double returnRate = lottoResult.getReturnRate();

        //Then
        assertThat(returnRate).isEqualTo(100);
        String expectOutput = "3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 0개";

        assertThat(lottoResult.formatResults()).isEqualTo(expectOutput);
    }
}
