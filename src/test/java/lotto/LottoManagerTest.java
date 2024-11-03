package lotto;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoManagerTest {
    private LottoManager lottoManager;

    @BeforeEach
    void setUp() {
        lottoManager = new LottoManager();
    }

    @Test
    void 로또번호를_Lotto_인스턴스로_변환하는_기능() {
        String input = "1, 2, 3 ,4 ,5 ,6";
        Lotto lottoResult = lottoManager.parseWinningNumbersToLotto(input);
        List<Integer> expectedNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lottoResult.getLotto()).isEqualTo(expectedNumber);
    }
    @Test
    void 로또_당첨_분석_기능() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        List<Lotto> lottoSets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 15)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 14, 15)),
                new Lotto(Arrays.asList(1, 2, 3, 12, 33, 44)),
                new Lotto(Arrays.asList(11, 12, 13, 15, 16,17))
        );

        Map<LottoRank, Long> expectedResults = new HashMap<>();
        expectedResults.put(LottoRank.FIRST, 1L);
        expectedResults.put(LottoRank.SECOND, 1L);
        expectedResults.put(LottoRank.THIRD, 1L);
        expectedResults.put(LottoRank.FOURTH, 1L);
        expectedResults.put(LottoRank.FIFTH, 1L);
        expectedResults.put(LottoRank.MISS, 1L);

        Map<LottoRank,Long> result = lottoManager.analyzeLottoResults(lottoSets, winningNumbers, bonusNumber);
        assertThat(result).isEqualTo(expectedResults);
    }


}
