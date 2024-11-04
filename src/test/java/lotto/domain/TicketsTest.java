package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TicketsTest {

    @Test
    void WinningInfo를_매개변수로_받아_TotalResult_객체를_반환한다() {
        Tickets tickets = generateMockTickets();
        WinningInfo winningInfo = generateMockWinningInfo();
        TotalResult totalResult = new TotalResult(generateMockEnumMap());

        assertThat(tickets.compareTicketsToWinningInfo(winningInfo)).usingRecursiveComparison().isEqualTo(totalResult);
    }

    private Tickets generateMockTickets() {
        return new Tickets(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 20)),
                new Lotto(List.of(1, 2, 3, 4, 20, 21)),
                new Lotto(List.of(1, 2, 3, 20, 21, 22))
        ));
    }

    private WinningInfo generateMockWinningInfo() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(10);

        return new WinningInfo(winningNumbers, bonusNumber);
    }

    private EnumMap<Reward, Integer> generateMockEnumMap() {
        EnumMap<Reward, Integer> totalResult = new EnumMap<>(Reward.class);
        Arrays.stream(Reward.values()).forEach(reward -> totalResult.put(reward, 1));

        return totalResult;
    }
}
