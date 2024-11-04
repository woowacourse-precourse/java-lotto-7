package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoWinningNumbers;
import org.junit.jupiter.api.Test;

class LottoResultAnalyzerTest {

    private final LottoResultAnalyzer lottoResultAnalyzer = new LottoResultAnalyzer();

    @Test
    void 사용자_로또_추첨_결과_확인_테스트(){
        // 사용자 로또 발행
        Lotto[] userLotto = new Lotto[3];
        userLotto[0] = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        userLotto[1] = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        userLotto[2] = new Lotto(List.of(1, 2, 3, 4, 5, 10));

        // 당첨 번호 생성
        LottoWinningNumbers winningLotto = new LottoWinningNumbers();
        winningLotto.setMainNumbers("1,2,3,4,5,6");
        winningLotto.setBonusNumber("7");
        winningLotto.generate();

        Map<LottoPrize, Integer> analyzedResult = lottoResultAnalyzer.analyze(userLotto, winningLotto);
        assertThat(analyzedResult).containsValues(1, 1, 1, 0, 0); // 1등:1, 2등:1, 3등:1, 4등:0, 5등:0
    }
}