package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.LottoRankCounter;
import lotto.model.db.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankViewTest {

    @DisplayName("로또 구매 후 로또 개수와 로또 번호를 출력한다.")
    @Test
    void viewFormat() {
        // given
        LottoRankCounter rank = new LottoRankCounter(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                10);
        double rateOfReturn = 62.5;
        LottoResultView view = new LottoResultView(rank, rateOfReturn);
        // when
        String viewStr = view.render();
        // then
        assertThat(viewStr).
                matches("\n당첨 통계" +
                        "\n---" +
                        "\n3개 일치 \\(5,000원\\) - \\d+개" +
                        "\n4개 일치 \\(50,000원\\) - \\d+개" +
                        "\n5개 일치 \\(1,500,000원\\) - \\d+개" +
                        "\n5개 일치, 보너스 볼 일치 \\(30,000,000원\\) - \\d+개" +
                        "\n6개 일치 \\(2,000,000,000원\\) - \\d+개" +
                        "\n총 수익률은 \\d+\\.\\d%입니다\\.");
    }
}