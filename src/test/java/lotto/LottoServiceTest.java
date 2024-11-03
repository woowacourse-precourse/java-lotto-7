package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.MatchLevel;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private  LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 로또_생성_테스트() {
        List<Lotto> lottos = lottoService.generateLottos(5);

        assertEquals(5, lottos.size());
    }

    @Test
    void 당첨_결과_계산_테스트() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;

        List<Lotto> lottos = List.of(
            new Lotto(List.of(1,2,3,4,5,6)),
            new Lotto(List.of(1,2,3,4,5,7)),
            new Lotto(List.of(1,2,3,4,5,8)),
            new Lotto(List.of(1,2,3,4,8,9)),
            new Lotto(List.of(1,2,3,8,9,10)),
            new Lotto(List.of(1,2,8,9,10,11))
        );

        Map<MatchLevel, Integer> result = lottoService.caculateMatchLevel(lottos, winningNumbers, bonusNumber);

        assertEquals(1, result.get(MatchLevel.SIX_MATCHES));
        assertEquals(1, result.get(MatchLevel.FIVE_PLUS_BONUS));
        assertEquals(1, result.get(MatchLevel.FIVE_MATCHES));
        assertEquals(1, result.get(MatchLevel.FOUR_MATCHES));
        assertEquals(1, result.get(MatchLevel.THREE_MATCHES));
        assertEquals(1, result.get(MatchLevel.NO_MATCHES));
    }

    @Test
    void 수익률_계산_테스트() {
        Map<MatchLevel, Integer> result = new EnumMap<>(Map.of(
            MatchLevel.THREE_MATCHES, 1,
            MatchLevel.FOUR_MATCHES, 0,
            MatchLevel.FIVE_MATCHES, 0,
            MatchLevel.FIVE_PLUS_BONUS, 0,
            MatchLevel.SIX_MATCHES, 0
        ));

        double profit = lottoService.calculateProfit(result, 8000);
        assertEquals(62.5, profit, 0.1);
    }
}
