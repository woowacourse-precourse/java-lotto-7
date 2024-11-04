package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.data.Lotto;
import lotto.data.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest extends NsTest {

    private OutputView outputView = new OutputView();

    @DisplayName("구매한 로또를 출력한다.")
    @Test
    void printPurchaseLottoTest() {
        // given
        List<Lotto> lottoList = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        // when
        outputView.printPurchaseLotto(lottoList);
        // then
        assertThat(output()).contains(
                "2개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "[7, 8, 9, 10, 11, 12]"
        );
    }

    @DisplayName("당첨 결과를 출력한다.")
    @Test
    void printResultTest() {
        // given
        Result result = new Result();
        result.addThreeNumberMatch();
        result.addFourNumberMatch();
        // when
        outputView.printResult(result);
        // then
        assertThat(output()).contains(
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }

    @DisplayName("수익률을 출력한다.")
    @Test
    void printProfitRateTest() {
        // given
        Result result = new Result();
        result.addThreeNumberMatch();
        result.addFourNumberMatch();
        // when
        outputView.printProfitRate(result, 10000L);
        // then
        assertThat(output()).contains("총 수익률은 550.0%입니다.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
