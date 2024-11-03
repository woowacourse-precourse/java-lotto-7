package lotto.service;

import static lotto.eunm.WinningResult.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.dto.LottoDto;
import lotto.dto.WinningDto;
import lotto.eunm.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void init() {
        lottoService = new LottoService();
    }

    @DisplayName("당첨 번호가 모두 일치하지 않을때")
    @Test
    void noMatchingNumbers() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(20, 21, 22, 23, 24, 25)));

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoDto lottoDto = LottoDto.of(lottos, winningNumbers, 16);
        WinningDto winningDto = lottoService.statisticsNumbers(lottoDto);

        Map<WinningResult, Integer> winningCount = winningDto.getWinningCount();
        assertThat(winningCount.values()).containsAll(Arrays.asList(0, 0, 0, 0, 0));
        assertThat(winningDto.getPrice()).isEqualTo(0.0);
    }

    @DisplayName("부분 일치할 때 (3개 번호 일치)")
    @Test
    void matchThreeNumbers() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 20, 21)));

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 5, 6, 7);
        LottoDto lottoDto = LottoDto.of(lottos, winningNumbers, 10);
        WinningDto winningDto = lottoService.statisticsNumbers(lottoDto);

        Map<WinningResult, Integer> winningCount = winningDto.getWinningCount();
        assertThat(winningCount.values()).containsExactly(1, 0, 0, 0, 0);
        assertThat(winningCount.get(THREE)).isEqualTo(1);
        assertThat(winningDto.getPrice()).isEqualTo(calculateWinningPrice(THREE.prizeMoney));
    }

    @DisplayName("부분 일치할 때 (4개 번호 일치)")
    @Test
    void matchFourNumbers() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 20, 21)));

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 6, 7);
        LottoDto lottoDto = LottoDto.of(lottos, winningNumbers, 10);
        WinningDto winningDto = lottoService.statisticsNumbers(lottoDto);

        Map<WinningResult, Integer> winningCount = winningDto.getWinningCount();
        assertThat(winningCount.values()).containsExactly(0, 1, 0, 0, 0);
        assertThat(winningCount.get(FOUR)).isEqualTo(1);
        assertThat(winningDto.getPrice()).isEqualTo(calculateWinningPrice(FOUR.prizeMoney));
    }


    @DisplayName("보너스 번호와 당첨 번호 4개가 일치할 때")
    @Test
    void matchBonusNumbers() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 6, 8);
        LottoDto lottoDto = LottoDto.of(lottos, winningNumbers, 7);
        WinningDto winningDto = lottoService.statisticsNumbers(lottoDto);

        Map<WinningResult, Integer> winningCount = winningDto.getWinningCount();
        System.out.println(winningCount.values());
        assertThat(winningCount.values()).containsExactly(0, 0, 0, 1, 0);
        assertThat(winningCount.get(FIVE_AND_BONUS)).isEqualTo(1);
        assertThat(winningDto.getPrice()).isEqualTo(calculateWinningPrice(FIVE_AND_BONUS.prizeMoney));
    }

    @DisplayName("모든 번호 일치할 때")
    @Test
    void allNumbersMatch() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoDto lottoDto = LottoDto.of(lottos, winningNumbers, 10);
        WinningDto winningDto = lottoService.statisticsNumbers(lottoDto);

        Map<WinningResult, Integer> winningCount = winningDto.getWinningCount();
        Collection<Integer> values = winningCount.values();
        System.out.println(values);
        assertThat(winningCount.get(SIX)).isEqualTo(1);
        assertThat(winningDto.getPrice()).isEqualTo(calculateWinningPrice(SIX.prizeMoney));
    }

    private double calculateWinningPrice(int totalPrize) {
        return ((double) totalPrize / 1000) * 100;
    }
}