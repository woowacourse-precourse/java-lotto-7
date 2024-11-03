package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultViewTest {

    @DisplayName("로또 구매 후 로또 개수와 로또 번호를 출력한다.")
    @Test
    void viewFormat() {
        // given
        int[] matchCnts = {0, 0, 0, 0, 0, 1};
        double rateOfReturn = 62.5;
        LottoResultView view = new LottoResultView(matchCnts, rateOfReturn);
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