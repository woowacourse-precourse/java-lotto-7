package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.MatchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class LottoUtilsTest {

    LottoUtils lottoUtils = new LottoUtils();
    LottoResult lottoResut;
    int lottoRateOfReturn;
    List<Integer> winningNumbers;
    List<Lotto> lottos;
    int bonusNumber;


    @BeforeEach
    void setUp() {
        lottoUtils = new LottoUtils();
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))
        );
        bonusNumber = 8;
    }

    @Test
    void 로또_결과_계산_테스트() {
        lottoUtils.calculateWinningResult(winningNumbers, lottos, bonusNumber);

        // 예상 결과와 비교
        assertEquals(4, lottoUtils.lottoResults.size(), "로또 결과 개수가 맞지 않습니다.");
        assertEquals(MatchResult.FOUR_MATCH, lottoUtils.lottoResults.get(0), "첫 번째 로또 결과가 예상과 다릅니다.");
        assertEquals(MatchResult.SIX_MATCH, lottoUtils.lottoResults.get(1), "두 번째 로또 결과가 예상과 다릅니다.");
        assertEquals(MatchResult.THREE_MATCH, lottoUtils.lottoResults.get(2), "세 번째 로또 결과가 예상과 다릅니다.");
        assertEquals(MatchResult.FIVE_MATCH_BONUS, lottoUtils.lottoResults.get(3), "네 번째 로또 결과가 예상과 다릅니다.");

    }


}