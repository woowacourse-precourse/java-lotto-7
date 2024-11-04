package lotto.service;

import lotto.config.LottoConfiguration;
import lotto.domain.Lotto;
import lotto.domain.MatchResult;
import lotto.input.InputHandler;
import lotto.input.InputParser;
import lotto.utils.LottoUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    List<Lotto> lottos;
    int bonusNumber;
    LottoConfiguration configuration;
    LottoUtils utils;

    private static class FixedInputHandler extends InputHandler {
        @Override
        public int inputPurchaseAmount() {
            return 8000;
        }
        @Override
        public String inputWinningNumbers() {
            return "1,2,3,4,5,6";
        }
        @Override
        public int inputBonusNumber() {
            return 7;
        }
    }

    // 테스트용 파서 구현
    private static class FixedInputParser extends InputParser {
        @Override
        public List<Integer> splitWinningNumbers(String input) {
            return Arrays.asList(1, 2, 3, 4, 5, 6); // 고정된 당첨 번호 리스트 반환
        }
    }

    @BeforeEach
    void setUp() {
        lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24))
        );

        bonusNumber = 7;
        configuration = new LottoConfiguration(new FixedInputHandler(), new FixedInputParser());
        configuration.fixedLotto(lottos);
        utils = new LottoUtils();
    }

    @Test
    void 로또게임_실행_테스트() {
        LottoGame lottoGame = new LottoGame(configuration, utils);
        Map<MatchResult, Integer> matchResultMap = lottoGame.run();

        assertEquals(1, matchResultMap.get(MatchResult.THREE_MATCH), "3개 일치한 결과가 예상과 다릅니다.");
        assertEquals(0, matchResultMap.get(MatchResult.FOUR_MATCH), "4개 일치한 결과가 예상과 다릅니다.");
        assertEquals(0, matchResultMap.get(MatchResult.FIVE_MATCH), "5개 일치한 결과가 예상과 다릅니다.");
        assertEquals(0, matchResultMap.get(MatchResult.FIVE_MATCH_BONUS), "5개 일치와 보너스 볼 일치한 결과가 예상과 다릅니다.");
        assertEquals(0, matchResultMap.get(MatchResult.SIX_MATCH), "6개 일치한 결과가 예상과 다릅니다.");

        double rateOfResult = (double) utils.totalPrize / configuration.lottoPrice() * 100;
        assertEquals(62.5, rateOfResult, "수익률 결과가 예상과 다릅니다.");

    }
}