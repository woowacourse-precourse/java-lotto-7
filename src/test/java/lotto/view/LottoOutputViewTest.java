package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

class LottoOutputViewTest {

    @DisplayName("구매한 로또 수량을 출력한다")
    @Test
    void printLottoCount() {
        LottoOutputView outputView = new LottoOutputView();
        assertThat(outputView.getLottoCountMessage(3)).isEqualTo("3개를 구매했습니다.");
    }

    @DisplayName("로또 번호를 출력한다")
    @Test
    void printLottoNumbers() {
        LottoOutputView outputView = new LottoOutputView();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(outputView.getLottoNumbersMessage(numbers)).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("당첨 통계를 출력한다")
    @Test
    void printWinningStatistics() {
        LottoOutputView outputView = new LottoOutputView();
        assertThat(outputView.getWinningStatisticsHeader())
                .isEqualTo("당첨 통계\n---\n");
    }

    @DisplayName("3개 일치 당첨 내역을 출력한다")
    @Test
    void printWinningResultThreeMatch() {
        LottoOutputView outputView = new LottoOutputView();
        assertThat(outputView.getWinningResultMessage(3, 5000, 1))
                .isEqualTo("3개 일치 (5,000원) - 1개");
    }

    @DisplayName("4개 일치 당첨 내역을 출력한다")
    @Test
    void printWinningResultFourMatch() {
        LottoOutputView outputView = new LottoOutputView();
        assertThat(outputView.getWinningResultMessage(4, 50000, 1))
                .isEqualTo("4개 일치 (50,000원) - 1개");
    }

    @DisplayName("5개 일치 당첨 내역을 출력한다")
    @Test
    void printWinningResultFiveMatch() {
        LottoOutputView outputView = new LottoOutputView();
        assertThat(outputView.getWinningResultMessage(5, 1500000, 1))
                .isEqualTo("5개 일치 (1,500,000원) - 1개");
    }

    @DisplayName("5개 일치와 보너스 볼 일치 당첨 내역을 출력한다")
    @Test
    void printWinningResultFiveMatchWithBonus() {
        LottoOutputView outputView = new LottoOutputView();
        assertThat(outputView.getWinningResultMessage(5, 30000000, 1))
                .isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
    }

    @DisplayName("6개 일치 당첨 내역을 출력한다")
    @Test
    void printWinningResultSixMatch() {
        LottoOutputView outputView = new LottoOutputView();
        assertThat(outputView.getWinningResultMessage(6, 2000000000, 1))
                .isEqualTo("6개 일치 (2,000,000,000원) - 1개");
    }

    @DisplayName("수익률을 출력한다")
    @Test
    void printProfitRate() {
        LottoOutputView outputView = new LottoOutputView();
        assertThat(outputView.getProfitRateMessage(150.0))
                .isEqualTo("총 수익률은 150.0%입니다.");
    }
}