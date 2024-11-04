package lotto.system.formater.winning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.system.unit.LottoNumber;
import lotto.system.unit.LottoTicket;
import lotto.system.utils.PrizeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoWinningAnalyzerTest {

    private LottoWinningAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        analyzer = new LottoWinningAnalyzer(winningNumbers, bonusNumber);
    }

    @Test
    void testAnalyzeWinningStatistics_withNoMatchingTickets() {
        List<LottoTicket> tickets = Collections.singletonList(
                new LottoTicket(Arrays.asList(new LottoNumber(10), new LottoNumber(11), new LottoNumber(12),
                        new LottoNumber(13), new LottoNumber(14), new LottoNumber(15)))
        );

        Map<PrizeType, Integer> statistics = analyzer.analyzeWinningStatistics(tickets);

        for (PrizeType prizeType : PrizeType.values()) {
            assertEquals(0, statistics.get(prizeType));
        }
    }

    @Test
    void testAnalyzeWinningStatistics_withSixMatchTicket() {
        List<LottoTicket> tickets = Collections.singletonList(
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))
        );

        Map<PrizeType, Integer> statistics = analyzer.analyzeWinningStatistics(tickets);

        assertEquals(1, statistics.get(PrizeType.getTypeByCode(7)));
    }

    @Test
    void testAnalyzeWinningStatistics_withFiveMatchAndBonusTicket() {
        List<LottoTicket> tickets = Collections.singletonList(
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(7)))
        );

        Map<PrizeType, Integer> statistics = analyzer.analyzeWinningStatistics(tickets);

        assertEquals(1, statistics.get(PrizeType.getTypeByCode(6)));
    }

    @Test
    void testAnalyzeWinningStatistics_withThreeMatchTicket() {
        List<LottoTicket> tickets = Collections.singletonList(
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(10), new LottoNumber(11), new LottoNumber(12))) // 3 matches
        );

        Map<PrizeType, Integer> statistics = analyzer.analyzeWinningStatistics(tickets);

        assertEquals(1, statistics.get(PrizeType.getTypeByCode(3)));
    }

    @Test
    void testCountMatchingNumbers() {
        LottoTicket ticket = new LottoTicket(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(8),
                new LottoNumber(9), new LottoNumber(10), new LottoNumber(11)
        ));

        int matchCount = analyzer.countMatchingNumbers(ticket);

        assertEquals(2, matchCount);
    }

    @Test
    void testHasBonusNumberMatch() {
        LottoTicket ticketWithBonus = new LottoTicket(Arrays.asList(
                new LottoNumber(1), new LottoNumber(7), new LottoNumber(8),
                new LottoNumber(9), new LottoNumber(10), new LottoNumber(11)
        ));
        LottoTicket ticketWithoutBonus = new LottoTicket(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(8),
                new LottoNumber(9), new LottoNumber(10), new LottoNumber(11)
        ));

        assertTrue(analyzer.hasBonusNumberMatch(ticketWithBonus));
        assertFalse(analyzer.hasBonusNumberMatch(ticketWithoutBonus));
    }
}