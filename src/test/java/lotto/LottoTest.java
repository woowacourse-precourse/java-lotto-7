package lotto;

import lotto.controller.ResultJudging;
import lotto.model.Price;
import lotto.model.BonusLotto;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.util.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void 숫자_범위가_1부터_45가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다")
    void 구입금액이_1000원단위가_아닐경우_예외가_발생한다() {
        Executable invalidAmount = () -> new Price(550);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                invalidAmount,
                "Expected exception for non-1000 unit amount"
        );
        assertEquals("[ERROR] 1000원 단위의 가격을 입력하시오.", thrown.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 양수가 아닐 경우 예외가 발생한다.")
    void 구입금액이_양수가_아닐경우_예외가_발생한다() {
        Executable zeroAmount = () -> new Price(0);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                zeroAmount,
                "Expected exception for zero purchase amount"
        );
        assertEquals("[ERROR] 0초과의 값을 입력하시오.", thrown.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    void 보너스번호가_당첨번호와_중복될경우_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber = 3;
        Executable duplicateBonus = () -> new BonusLotto(duplicateBonusNumber).bonusDuplicate(duplicateBonusNumber, winningNumbers);

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                duplicateBonus,
                "Expected exception for bonus number within winning numbers"
        );
        assertEquals("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.", thrown.getMessage());
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 등수 판정")
    void 당첨번호와_일치하는_등수판정() {
        ResultJudging resultJudging = new ResultJudging();
        List<Integer> purchasedLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Result result = resultJudging.lottoResult(purchasedLotto, winningNumbers, bonusNumber);

        assertEquals(1, result.getSixCount(), "6개 번호 일치 - 1등 당첨자가 예상대로 확인되어야 합니다.");
        assertEquals(0, result.getBonusCount(), "보너스 번호 일치는 없으므로 보너스 등수는 0개여야 합니다.");
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void 수익률_계산_테스트() {
        ResultJudging resultJudging = new ResultJudging();
        Result result = new Result();

        result.updateStatistics(WinningRank.THREE);
        result.updateStatistics(WinningRank.FOUR);
        result.updateStatistics(WinningRank.FIVE);

        int totalCost = 10000;
        double profitRate = resultJudging.returnRate(totalCost, result);

        assertEquals(155.5, profitRate, 0.1, "수익률은 예상된 값과 일치해야 합니다.");
    }

    @Test
    @DisplayName("등수별 당첨 내역 출력")
    void 등수별_당첨내역_출력() {
        Result result = new Result();

        result.updateStatistics(WinningRank.THREE);
        result.updateStatistics(WinningRank.FOUR);
        result.updateStatistics(WinningRank.SIX);

        assertEquals(1, result.getThreeCount(), "3등 당첨 횟수가 예상과 일치해야 합니다.");
        assertEquals(1, result.getFourCount(), "4등 당첨 횟수가 예상과 일치해야 합니다.");
        assertEquals(1, result.getSixCount(), "1등 당첨 횟수가 예상과 일치해야 합니다.");
    }
}
