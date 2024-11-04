package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.DrawNumbers;
import lotto.enums.ListEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class PurchaseServiceTest {
    private static List<DrawNumbers> drawSets;

    @Test
    void getRandomDrawNumbersByTicketCount() {
        //given
        int ticketCount = 5;
        drawSets = ListEnum.getDrawSets(); // 정해진 값이 ListEnum 에 존재
        PurchaseService purchaseService = new PurchaseService();
        //when
        Executable executable = () -> {
            List<DrawNumbers> result = purchaseService.getRandomDrawNumbersByTicketCount(ticketCount);
            // then
            assertThat(result).hasSize(ticketCount); // 결과의 크기가 ticketCount 와 동일한지 확인
            assertThat(result.get(0).getLottoNumbers()).isEqualTo(drawSets.get(0).getLottoNumbers());
            assertThat(result.get(1).getLottoNumbers()).isEqualTo(drawSets.get(1).getLottoNumbers());
            assertThat(result.get(2).getLottoNumbers()).isEqualTo(drawSets.get(2).getLottoNumbers());
            assertThat(result.get(3).getLottoNumbers()).isEqualTo(drawSets.get(3).getLottoNumbers());
            assertThat(result.get(4).getLottoNumbers()).isEqualTo(drawSets.get(4).getLottoNumbers());
        };

        assertRandomUniqueNumbersInRangeTest(
                executable,
                drawSets.get(0).getLottoNumbers(),
                drawSets.get(1).getLottoNumbers(),
                drawSets.get(2).getLottoNumbers(),
                drawSets.get(3).getLottoNumbers(),
                drawSets.get(4).getLottoNumbers()
        );

    }
}