package lotto.service;

import lotto.model.Lotto;
import lotto.message.IOMessage;
import lotto.message.WinningNumMessage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputServiceTest {

    private final OutputService outputService = new OutputService();

    @Test
    public void 구매_개수_메시지_테스트() {
        String message = outputService.getLottoCountMessage(5);
        assertEquals(String.format(IOMessage.NUMBER_OF_PURCHASES.getMessage(), 5), message);
    }

    @Test
    public void 로또_목록_메시지_테스트() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        String expectedMessage = "[1, 2, 3, 4, 5, 6]\n";
        assertEquals(expectedMessage, outputService.getLottosMessage(lottos));
    }

    @Test
    public void 당첨_통계_메시지_테스트() {
        int[] matchCounts = {1, 2, 3, 4, 5};
        String expectedMessage = IOMessage.WINNING_STATISTICS_OUTPUT.getMessage() +
                String.format(WinningNumMessage.MATCHES_3_WINNING.getMessage(), 1) +
                String.format(WinningNumMessage.MATCHES_4_WINNING.getMessage(), 2) +
                String.format(WinningNumMessage.MATCHES_5_WINNING.getMessage(), 3) +
                String.format(WinningNumMessage.MATCHES_BONUS_WINNING.getMessage(), 4) +
                String.format(WinningNumMessage.MATCHES_6_WINNING.getMessage(), 5);

        assertEquals(expectedMessage, outputService.getLottoStatisticsMessage(matchCounts));
    }

    @Test
    public void 수익률_메시지_테스트() {
        double yield = 500.0;
        String expectedMessage = String.format(IOMessage.RATE_OF_RETURN_OUTPUT.getMessage(), yield);
        assertEquals(expectedMessage, outputService.getYieldMessage(yield));
    }
}
