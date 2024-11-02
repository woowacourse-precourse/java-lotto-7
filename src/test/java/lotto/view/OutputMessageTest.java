package lotto.view;

import static lotto.domain.WinningInfo.SECOND;
import static lotto.domain.WinningInfo.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OutputMessageTest {

    @Test
    void 로또_구매수량에_대한_메시지가_정확하게_들어있는지_확인() {

        int lottoQuantity = 3;

        assertThat(OutputMessage.OUTPUT_PURCHASE_QUANTITY.format(lottoQuantity))
                .isEqualTo(String.format("\n%d개를 구매했습니다.", lottoQuantity));
    }

    @Test
    void 로또_2등을_제외한_당첨내역에_대한_메시지가_정확하게_들어있는지_확인() {

        int matchingNumberCount = THIRD.getMatchingNumberCount();
        int prizeMoney = THIRD.getPrizeMoney();
        int winningTicketCount = THIRD.getWinningTicketCount();

        assertThat(OutputMessage.OUTPUT_EXCEPT_SECOND_PLACE_RESULT.format(matchingNumberCount, prizeMoney, winningTicketCount))
                .isEqualTo(String.format("%d개 일치 (%,d원) - %d개", matchingNumberCount, prizeMoney, winningTicketCount));
    }

    @Test
    void 로또_2등_당첨내역에_대한_메시지가_정확하게_들어있는지_확인() {

        int matchingNumberCount = SECOND.getMatchingNumberCount();
        int prizeMoney = SECOND.getPrizeMoney();
        int winningTicketCount = SECOND.getWinningTicketCount();

        assertThat(OutputMessage.OUTPUT_SECOND_PLACE_RESULT.format(matchingNumberCount, prizeMoney, winningTicketCount))
                .isEqualTo(String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", matchingNumberCount, prizeMoney, winningTicketCount));
    }

    @Test
    void 수익률에_대한_메시지가_정확하게_들어있는지_확인() {

        double testEarningRate = 77.7777;

        assertThat(OutputMessage.OUTPUT_EARNING_RATE.format(testEarningRate))
                .isEqualTo(String.format("총 수익률은 %.1f%%입니다", testEarningRate));
    }
}