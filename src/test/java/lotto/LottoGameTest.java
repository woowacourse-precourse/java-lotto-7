package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    public void setUp() {
        lottoGame = new LottoGame();
    }

    @DisplayName("초기화 잘 됐는지 확인")
    @Test
    void 초기화_잘_됐는지_확인() {
        Map<LottoResult, Integer> results = lottoGame.getTotalMatchCount();
        for (LottoResult result : LottoResult.values()) {
            assertEquals(0, results.get(result));
        }
    }

    @DisplayName("로또 한 줄 잘 들어오는지 확인")
    @Test
    void 로또_한_줄_잘_들어오는지_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoGame.purchaseLotto(lotto);
        assertEquals(1, lottoGame.getPurchasedLottos().size());
    }

    @DisplayName("결과 검증 테스트")
    @Test
    void 결과_검증_테스트() {
        Lotto winningLotto = new Lotto(List.of(2,4,6,8,10,42)); // 추첨번호
        int bonusNumber = 45; // 보너스번호
        Lotto userLotto = new Lotto(List.of(2,4,6,8,10,45)); // 생성된 내 로또 번호

        lottoGame.purchaseLotto(userLotto);
        lottoGame.evaluateResults(winningLotto, bonusNumber);

        Map<LottoResult, Integer> results = lottoGame.getTotalMatchCount();
        assertEquals(1, results.get(LottoResult.SECOND));
    }
}