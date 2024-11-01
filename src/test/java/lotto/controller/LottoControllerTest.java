package lotto.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void testDuplicateLottoNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void testInvalidLottoNumberCount() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void testLottoNumberOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이의 숫자만 가능합니다.");
    }

    @DisplayName("당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void testDuplicateWinningNumbers() {
        String inputWinningNumbers = "1, 2, 3, 4, 5, 5";
        assertThatThrownBy(() -> LottoController.convertWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void testWinningNumberCountInvalid() {
        String inputWinningNumbers = "1, 2, 3, 4, 5";
        assertThatThrownBy(() -> LottoController.convertWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("당첨 번호가 1~45 범위를 초과하면 예외가 발생한다.")
    @Test
    void testWinningNumberOutOfRange() {
        String inputWinningNumbers = "1, 2, 3, 4, 5, 50";
        String inputBonusNumber = "10";
        assertThatThrownBy(() -> LottoController.convertWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이의 숫자만 가능합니다.");
    }

    @DisplayName("당첨 번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void testWinningNumberNotNumeric() {
        String inputWinningNumbers = "1, 2, 3, 4, abc, 6";
        String inputBonusNumber = "10";
        assertThatThrownBy(() -> LottoController.convertWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void testBonusNumberOutOfRange() {
        String inputBonusNumber = "0";
        assertThatThrownBy(() -> LottoController.convertBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다.");
    }

    @DisplayName("보너스 번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void testBonusNumberNotNumeric() {
        String inputBonusNumber = "abc";
        assertThatThrownBy(() -> LottoController.convertBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    public void testCountWinnings() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45))
        );
        Lottos lottoNumbers = new Lottos(lottos);
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 45);

        List<Integer> winnings = LottoController.countWinnings(lottoNumbers, winningLotto);

        assertEquals(1, winnings.get(0));
        assertEquals(1, winnings.get(1));
        assertEquals(0, winnings.get(2));
        assertEquals(0, winnings.get(3));
        assertEquals(0, winnings.get(4));
    }

    @Test
    public void testCalculateTotalEarnings() {
        List<Integer> result = Arrays.asList(1, 0, 0, 0, 1);
        double totalEarnings = LottoController.calculateTotalEarnings(result);
        assertEquals(LottoRank.FIRST.getPrizeAmount() + LottoRank.FIFTH.getPrizeAmount(), totalEarnings);
    }

    @Test
    public void testCalculateProfitRate() {
        double totalEarnings = 6000;
        int purchaseAmount = 2000;
        double profitRate = LottoController.calculateProfitRate(totalEarnings, purchaseAmount);
        assertEquals((6000 / 2000) * 100, profitRate);
    }
}
