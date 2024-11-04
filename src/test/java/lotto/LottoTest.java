package lotto;

import domain.BonusNumber;
import domain.Lotto;
import domain.WinningNum;
import domain.WinningResult;
import message.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

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

    @DisplayName("로또 번호에 빈 문자가 들어오면 예외가 발생한다.")
    @Test
    void 로또_번호에_빈_문자가_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of()))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 유효하지 않은 숫자가 들어오면 예외가 발생한다.")
    @Test
    void 로또_번호에_1부터_45_사이가_아닌_숫자가_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, -3, 4, 55, 65)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("숫자 6개가 일치하면 1등에 당첨된다.")
    public void 숫자_6개가_일치하면_1등에_당첨된다() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        WinningNum winningNum = new WinningNum();
        BonusNumber bonusNumber = new BonusNumber();

        List<Integer> winningNumbers = winningNum.splitInputtedWinningNums("1, 2, 3, 4, 5, 6");
        bonusNumber.generateBonusNumber("7");

        int matchCount = lotto.getMatchCount(winningNumbers);

        Prize result = WinningResult.getPrizeByMatch(matchCount, false);

        assertEquals(Prize.ALL_MATCHES, result);
    }

    @Test
    @DisplayName("숫자 5개가 일치하고 보너스 번호가 일치하면 2등에 당첨된다.")
    public void 숫자_5개가_일치하고_보너스_번호가_일치하면_2등에_당첨된다() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        WinningNum winningNum = new WinningNum();
        BonusNumber bonusNumber = new BonusNumber();
        WinningResult winningResult = new WinningResult();

        List<Integer> winningNumbers = winningNum.splitInputtedWinningNums("1, 2, 3, 4, 5, 12");
        int bonusNum = bonusNumber.generateBonusNumber("6");

        int matchCount = lotto.getMatchCount(winningNumbers);
        boolean matchBonus = lotto.getNumbers().contains(bonusNum);

        Prize result = WinningResult.getPrizeByMatch(matchCount, matchBonus);

        assertEquals(Prize.FIVE_BONUS_MATCHES, result);
    }

    @Test
    @DisplayName("숫자 5개가 일치하면 3등에 당첨된다.")
    public void 숫자_5개가_일치하면_3등에_당첨된다() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        WinningNum winningNum = new WinningNum();
        BonusNumber bonusNumber = new BonusNumber();

        List<Integer> winningNumbers = winningNum.splitInputtedWinningNums("1, 2, 3, 4, 5, 10");
        bonusNumber.generateBonusNumber("9");

        int matchCount = lotto.getMatchCount(winningNumbers);

        Prize result = WinningResult.getPrizeByMatch(matchCount, false);

        assertEquals(Prize.FIVE_MATCHES, result);
    }

    @Test
    @DisplayName("숫자 4개가 일치하면 4등에 당첨된다.")
    public void 숫자_4개가_일치하면_4등에_당첨된다() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        WinningNum winningNum = new WinningNum();
        BonusNumber bonusNumber = new BonusNumber();

        List<Integer> winningNumbers = winningNum.splitInputtedWinningNums("1, 2, 3, 4, 34, 10");
        bonusNumber.generateBonusNumber("9");

        int matchCount = lotto.getMatchCount(winningNumbers);

        Prize result = WinningResult.getPrizeByMatch(matchCount, false);

        assertEquals(Prize.FOUR_MATCHES, result);
    }

    @Test
    @DisplayName("숫자 3개가 일치하면 5등에 당첨된다.")
    public void 숫자_3개가_일치하면_5등에_당첨된다() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        WinningNum winningNum = new WinningNum();
        BonusNumber bonusNumber = new BonusNumber();

        List<Integer> winningNumbers = winningNum.splitInputtedWinningNums("1, 2, 3, 23, 24, 10");
        bonusNumber.generateBonusNumber("9");

        int matchCount = lotto.getMatchCount(winningNumbers);

        Prize result = WinningResult.getPrizeByMatch(matchCount, false);

        assertEquals(Prize.THREE_MATCHES, result);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
