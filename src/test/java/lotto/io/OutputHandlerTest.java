package lotto.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoPrize;
import lotto.dto.IncomeStatics;
import lotto.dto.PrizeStatics;
import lotto.dto.PurchasedLottos;
import lotto.testUtil.testDouble.WriterFake;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OutputHandlerTest {

    @Test
    void 구매한_로또들을_출력한다() {
        //given
        WriterFake writerFake = new WriterFake();
        OutputParser outputParser = new OutputParser();
        OutputHandler sut = new OutputHandler(writerFake, outputParser);
        PurchasedLottos purchasedLottos = new PurchasedLottos(List.of(
                "1, 2, 3, 4, 5, 6",
                "5, 6, 7, 8, 9, 10"
        ));

        //when
        sut.handlePurchasedLottos(purchasedLottos);

        //then
        assertThat(writerFake.getOutputs().getFirst()).contains(
                "2개를 구매했습니다.",
                "1, 2, 3, 4, 5, 6",
                "5, 6, 7, 8, 9, 10"
        );
    }

    @Test
    void 당첨통계를_출력한다() {
        //given
        WriterFake writerFake = new WriterFake();
        OutputParser outputParser = new OutputParser();
        OutputHandler sut = new OutputHandler(writerFake, outputParser);
        Map<LottoPrize, Long> prizeCount = new HashMap<>();
        prizeCount.put(LottoPrize.FRIST_PRIZE, 1L);
        prizeCount.put(LottoPrize.THIRD_PRIZE, 2L);
        PrizeStatics prizeStatics = new PrizeStatics(new EnumMap<>(prizeCount));

        //when
        sut.handlePrizeStatics(prizeStatics);

        //then
        assertThat(writerFake.getOutputs().getFirst()).contains(
                "당첨 통계",
                "---",
                "5개 일치 (1,500,000원) - 2개",
                "6개 일치 (2,000,000,000원) - 1개"
        );
    }

    @ParameterizedTest
    @CsvSource({
            "27.36, 27.4",
            "27.350, 27.4",
            "27.349, 27.3",
            "27.34, 27.3",
            "27.31, 27.3",
    })
    void 수익통계를_출력한다(float incomeRate, String incomePercent) {
        //given
        WriterFake writerFake = new WriterFake();
        OutputParser outputParser = new OutputParser();
        OutputHandler sut = new OutputHandler(writerFake, outputParser);
        IncomeStatics incomeStatics = new IncomeStatics(incomeRate);

        //when
        sut.handleIncomeStatics(incomeStatics);

        //then
        assertThat(writerFake.getOutputs().getFirst()).contains(
                "총 수익률은 " + incomePercent + "%입니다."
        );
    }

    @Test
    void 예외메시지를_출력한다() {
        //given
        WriterFake writerFake = new WriterFake();
        OutputParser outputParser = new OutputParser();
        OutputHandler sut = new OutputHandler(writerFake, outputParser);
        Exception exception = new Exception("테스트예외");

        //when
        sut.handleExceptionMessage(exception);

        //then
        assertThat(writerFake.getOutputs().getFirst()).contains(
                "[ERROR] 테스트예외"
        );
    }
}
