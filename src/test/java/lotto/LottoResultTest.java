package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호로 LottoResult를 생성한다")
    void createLottoResult() {
        // given
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 7;

        // when
        LottoResult lottoResult = new LottoResult(winningNumber, bonusNumber);

        // then
        assertThat(lottoResult.toString()).contains(
                "3개 일치 (5,000원)-0개",
                "4개 일치 (50,000원)-0개",
                "5개 일치 (1,500,000원)-0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원)-0개",
                "6개 일치 (2,000,000,000원)-0개"
        );
    }

    @Test
    @DisplayName("1등 당첨을 정확히 계산한다")
    void calculateFirstWinner() {
        // given
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 7;
        LottoResult lottoResult = new LottoResult(winningNumber, bonusNumber);

        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        Lottos lottos = new Lottos(lottoList);

        // when
        lottoResult.calculate(lottos);
        lottoResult.calculateTotalBenefit();

        // then
        assertThat(lottoResult.toString()).contains("6개 일치 (2,000,000,000원)-1개");
        assertThat(lottoResult.getProfit(lottos)).isEqualTo(200000000000.0);
    }

    @Test
    @DisplayName("2등 당첨을 정확히 계산한다")
    void calculateSecondWinner() {
        // given
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 7;
        LottoResult lottoResult = new LottoResult(winningNumber, bonusNumber);

        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
        );
        Lottos lottos = new Lottos(lottoList);

        // when
        lottoResult.calculate(lottos);
        lottoResult.calculateTotalBenefit();

        // then
        assertThat(lottoResult.toString()).contains("5개 일치, 보너스 볼 일치 (30,000,000원)-1개");
        assertThat(lottoResult.getProfit(lottos)).isEqualTo(3000000000.0);
    }

    @Test
    @DisplayName("여러 등수의 당첨을 동시에 계산한다")
    void calculateMultipleWinners() {
        // given
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 7;
        LottoResult lottoResult = new LottoResult(winningNumber, bonusNumber);

        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9))
        );
        Lottos lottos = new Lottos(lottoList);

        // when
        lottoResult.calculate(lottos);
        lottoResult.calculateTotalBenefit();

        // then
        assertThat(lottoResult.toString())
                .contains("6개 일치 (2,000,000,000원)-1개")
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원)-1개")
                .contains("5개 일치 (1,500,000원)-1개")
                .contains("4개 일치 (50,000원)-1개")
                .contains("3개 일치 (5,000원)-1개");
    }

    @Test
    @DisplayName("수익률을 정확히 계산한다")
    void calculateProfit() {
        // given
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 7;
        LottoResult lottoResult = new LottoResult(winningNumber, bonusNumber);

        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new Lotto(Arrays.asList(4, 5, 6, 10, 11, 12)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        Lottos lottos = new Lottos(lottoList);

        // when
        lottoResult.calculate(lottos);
        lottoResult.calculateTotalBenefit();

        // then
        assertThat(lottoResult.getProfit(lottos)).isEqualTo(166600.00);
    }

    @Test
    @DisplayName("미당첨 로또의 수익률은 0%이다")
    void calculateProfitWithNoWinning() {
        // given
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 7;
        LottoResult lottoResult = new LottoResult(winningNumber, bonusNumber);

        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        Lottos lottos = new Lottos(lottoList);

        // when
        lottoResult.calculate(lottos);
        lottoResult.calculateTotalBenefit();

        // then
        assertThat(lottoResult.getProfit(lottos)).isEqualTo(0.0);
    }

    @Test
    @DisplayName("초기화 후에는 모든 당첨 결과가 0이어야 한다")
    void initializeResult() {
        // given
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 7;
        LottoResult lottoResult = new LottoResult(winningNumber, bonusNumber);

        // when
        lottoResult.initResult();

        // then
        assertThat(lottoResult.toString())
                .contains("6개 일치 (2,000,000,000원)-0개")
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원)-0개")
                .contains("5개 일치 (1,500,000원)-0개")
                .contains("4개 일치 (50,000원)-0개")
                .contains("3개 일치 (5,000원)-0개");
    }
}