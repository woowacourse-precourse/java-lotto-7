package lotto.service;

import lotto.dto.CalculateResultDto;
import lotto.dto.LottoResultDto;
import lotto.model.Lotto;
import lotto.model.UserLottos;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {
    private LottoGame lottoGame;
    private WinningLotto winningLotto;
    private CalculateResultDto calculateResultDto;

    @BeforeEach
    public void setUp() {
        lottoGame = new LottoGame();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;
        winningLotto = new WinningLotto(winningNumbers, bonusNum);
        calculateResultDto = new CalculateResultDto();
    }

    @Test
    @DisplayName("calculateResultDto 변수 정상 갱신")
    public void testCheckUserLotto() {
        List<Integer> userLottoNumbers = Arrays.asList(1, 2, 3, 8, 9, 10);

        lottoGame.checkUserLotto(userLottoNumbers, winningLotto, calculateResultDto);

        assertEquals(3, calculateResultDto.getWinningNumberMatchCount());
        assertEquals(0, calculateResultDto.getBonusNumberMatchCount());
    }

    @Test
    @DisplayName("3개 일치하는 경우 수익률 계산")
    public void testCalculateResultWithThreeMatch() {
        List<Integer> userLottoNumbers = Arrays.asList(1, 2, 3, 8, 9, 10);
        UserLottos userLottos = new UserLottos(1, 1000) {
            @Override
            public List<Lotto> getLottos() {
                return Arrays.asList(new Lotto(userLottoNumbers));
            }
        };

        LottoResultDto result = lottoGame.calculateResult(userLottos, winningLotto);

        assertEquals(1, result.getThreeMatchCount());
        assertEquals(500.0, result.getProfitRate());
    }
}