package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.LottoPrize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final OutputView outputView = new OutputView();
    private ByteArrayOutputStream output;

    @BeforeEach
    void setup() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restore() {
        System.setOut(System.out);
        output.reset();
        Console.close();
    }

    @Test
    void 당첨_내역_출력_테스트() {
        // given
        Map<LottoPrize, Integer> prizeCount = new HashMap<>() {{
            put(LottoPrize.FIFTH, 1);
            put(LottoPrize.FOURTH, 2);
            put(LottoPrize.THIRD, 3);
            put(LottoPrize.SECOND, 1);
            put(LottoPrize.FIRST, 4);
            put(LottoPrize.NOTHING, 10);
        }};
        double rateOfReturn = 1234.5767;
        LottoStatisticsDto lottoStatisticsDto = new LottoStatisticsDto(prizeCount, rateOfReturn);

        // when
        outputView.printLottoStatistics(lottoStatisticsDto);

        // then
        assertThat(output.toString())
                .contains("당첨 통계",
                        "---",
                        "3개 일치 (5,000원) - 1개",
                        "4개 일치 (50,000원) - 2개",
                        "5개 일치 (1,500,000원) - 3개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                        "6개 일치 (2,000,000,000원) - 4개",
                        "총 수익률은 1,234.6%입니다."
                );

    }
}