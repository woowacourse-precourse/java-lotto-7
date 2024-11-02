package lotto.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoWinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultAnalyzerTest {

    private final LottoResultAnalyzer lottoResultAnalyzer = new LottoResultAnalyzer();
    private final Lotto[] userLotto = new Lotto[3];
    LottoWinningNumbers winningLotto = new LottoWinningNumbers("1,2,3,4,5,6", "7");

    @BeforeEach
    void init(){
        // 사용자 로또 발행
        userLotto[0] = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        userLotto[1] = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        userLotto[2] = new Lotto(List.of(1, 2, 3, 4, 5, 10));

        // 당첨 번호 생성
        winningLotto.generate();
    }

    @Test
    void 사용자_로또_추첨_결과_확인_테스트(){
        Map<LottoPrize, Integer> analyzedResult = lottoResultAnalyzer.analyze(userLotto, winningLotto);
        assertThat(analyzedResult).containsValues(1, 1, 1, 0, 0); // 1등:1, 2등:1, 3등:1, 4등:0, 5등:0
    }

    @Test
    void 수익률_계산_테스트(){
        // 추첨 결과 확인 후
        lottoResultAnalyzer.analyze(userLotto, winningLotto);

        // 수익률 계산
        int totalYield = lottoResultAnalyzer.computeYield();
        assertEquals(2_031_500_000, totalYield);
    }

}