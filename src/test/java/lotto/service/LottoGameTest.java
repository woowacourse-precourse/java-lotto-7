package lotto.service;

import lotto.dto.CalculateResultDto;
import lotto.dto.LottoResultDto;
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
    private LottoResultDto resultDto;

    @BeforeEach
    public void setUp() {
        lottoGame = new LottoGame();
        resultDto = new LottoResultDto();
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
    @DisplayName("rewardAmount 정상 반환")
    public void testCalculateMatchCount() {
        calculateResultDto.plusWinningNumberMatchCount();
        calculateResultDto.plusWinningNumberMatchCount();
        calculateResultDto.plusWinningNumberMatchCount();

        int rewardAmount = lottoGame.calculateMatchCount(resultDto, calculateResultDto, 1);

        assertEquals(5000, rewardAmount);
        assertEquals(1, resultDto.getThreeMatchCount());
    }
}