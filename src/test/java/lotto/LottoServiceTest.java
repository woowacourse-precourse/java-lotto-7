package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import lotto.dto.LottoResponseDTO;
import lotto.model.Lotto;
import lotto.model.LottoResults;
import lotto.model.Rank;
import lotto.service.LottoService;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    void 로또_구매_금액에_따라_정확한_개수의_로또를_생성해야_한다() {
        int purchaseAmount = 5000;
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);
        assertEquals(5, lottos.size());
    }

    @Test
    void 결과를_정확하게_계산해야_한다() {
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        );
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        LottoResponseDTO responseDTO = lottoService.calculateResult(userLottos, winningLotto, bonusNumber);
        LottoResults results = responseDTO.getResults();
        Map<Rank, Integer> expectedResults = Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 1,
                Rank.THIRD, 1,
                Rank.FOURTH, 0,
                Rank.FIFTH, 0,
                Rank.MISS, 0
        );
        assertEquals(expectedResults, results.getResultMap());
    }
}
