package lotto.custom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.custom.model.Lotto;
import lotto.custom.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CaculateYieldServiceTest {
    private final CalculateYieldService calculateYieldService = new CalculateYieldService();

    @DisplayName("서비스_수익률계산_테스트")
    @Test
    void 서비스_수익률계산_테스트() {
        Lottos myLottoTickets = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)),
                new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11))
        ));

        List<Integer> result = Arrays.asList(1, 0, 0, 0, 0);

        double yield = calculateYieldService.run(result, myLottoTickets);

        assertEquals(250, yield);
    }
}