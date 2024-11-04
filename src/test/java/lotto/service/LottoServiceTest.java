package lotto.service;

import lotto.model.Lotto;
import lotto.utils.LottoRules;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    private static final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또 발행하기")
    void lottoGenerate() {
        Assertions.assertThat(lottoService.generateLotto()).isInstanceOf(Lotto.class);
    }

    @ParameterizedTest
    @DisplayName("구매 금액 만큼 로또 발행하기")
    @ValueSource(ints = {1, 30, 20, 15, 4})
    void purchaseLottoTickets(int count) {
        List<Lotto> lottoTickets = lottoService.purchaseLottoTickets(LottoRules.LOTTO_PRICE * count);
        assertEquals(lottoTickets.size(), count);
    }

    @ParameterizedTest
    @DisplayName("당첨번호와 보너스번호 중복 확인 기능 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void validateNoDuplicates(int bonusNumber) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
            lottoService.checkBonusNumberDuplication(winningNumbers, bonusNumber);
        });
        assertEquals("[ERROR] 보너스번호는 당첨번호 6개와 중복될 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("내 로또와 당첨 번호 비교")
    void calculateWinningRankCount() {
        List<Lotto> myLottoTickets = new ArrayList<>();
        myLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        Map<LottoRules.Winning, Integer> winningCount =
                lottoService.calculateWinningStatistics(myLottoTickets, winningNumbers, bonusNumber);
        assertEquals(winningCount.get(LottoRules.Winning.WINNING_RANK_1), 1);
    }

    @Test
    @DisplayName("수익률 계산")
    void calculateYieldRate() {
        int purchasePrice = 8000;
        Map<LottoRules.Winning, Integer> winningRankCount = new HashMap<>();
        winningRankCount.put(LottoRules.Winning.WINNING_RANK_5, 1);

        double yieldRate = lottoService.calculateYieldRate(purchasePrice, winningRankCount);

        assertEquals(62.5, yieldRate);
    }
}