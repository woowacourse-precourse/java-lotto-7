package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoResults;
import lotto.model.Rank;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {
    @Test
    void 초기화된_resultMap이_모든_Rank에_대해_0으로_설정되어야_한다() {
        LottoResults results = new LottoResults(List.of(), new Lotto(List.of()), 7);
        Map<Rank, Integer> expected = new HashMap<>();
        for (Rank rank : Rank.values()) {
            expected.put(rank, 0);
        }
        assertEquals(expected, results.getResultMap());
    }
}
