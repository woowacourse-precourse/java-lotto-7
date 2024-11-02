package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Service.EarningRateService;
import lotto.View.OutputEarningRateView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class EarningRateTest extends NsTest {
    EarningRateService earningRateService = new EarningRateService();
    OutputEarningRateView outputEarningRateView = new OutputEarningRateView();

    @DisplayName("수익률을 알맞게 계산하여 형식에 맞게 출력하면 통과")
    @Test
    void 수익률을_계산하여_출력한다() {
        int price = 8000;
        Map<String, Integer> testMap = Map.of("FIRST", 0, "SECOND", 0, "THIRD", 0, "FOURTH", 0, "FIFTH", 1);
        assertSimpleTest(
                () -> {
                    assertThat(earningRateService.calculateEarningRate(price, testMap)).isEqualTo(62.5);
                }
        );
    }

    @DisplayName("수익률을 소숫점 둘째자리에서 반올림하고, 구분점을 찍어 출력하면 통과")
    @Test
    void 소수를_형식에_따라_출력한다() {
        assertSimpleTest(
                () -> {
                    outputEarningRateView.printEarningRate(10000000.38);
                    assertThat(output()).contains(
                            "총 수익률은 10,000,000.4%입니다."
                    );
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
