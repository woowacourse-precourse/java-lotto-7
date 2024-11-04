package lotto;

import lotto.constant.ErrorMessage;
import lotto.constant.PrizeMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.PrizeMoney.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개를 넘으면 예외가 발생한다.")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_SIZE_ERROR.getMessage());
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_DUPLICATE_ERROR.getMessage());
    }

    @Test
    @DisplayName("로또 번호중 범위에 해당하지 않으면 예외가 발생한다.")
    void 로또_번호중_범위에_해당하지_않으면_예외가_발생한다() {
        //given //when //then
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBERS_RANGE_ERROR.getMessage());
    }

    @Test
    @DisplayName("로또번호를 비교하여 1등상금을 얻는다")
    void 로또번호를_비교하여_1등상금을_얻는다() {
        //given
        BonusNumber bonusNumber = new BonusNumber("7");
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber.getBonusNumber());

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        Long prize = lotto.calculatePrizeMoney(winningNumber, bonusNumber);

        //then
        assertThat(prize).isEqualTo(FIFTH_PRIZE.getPrize());
    }

    @Test
    @DisplayName("로또번호를 비교하여 2등상금을 얻는다")
    void 로또번호를_비교하여_2등상금을_얻는다() {
        //given
        BonusNumber bonusNumber = new BonusNumber("7");
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber.getBonusNumber());

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        //when
        Long prize = lotto.calculatePrizeMoney(winningNumber, bonusNumber);

        //then
        assertThat(prize).isEqualTo(SECOND_PRIZE.getPrize());
    }

    @Test
    @DisplayName("로또번호를 비교하여 3등상금을 얻는다")
    void 로또번호를_비교하여_3등상금을_얻는다() {
        //given
        BonusNumber bonusNumber = new BonusNumber("7");
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber.getBonusNumber());

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        //when
        Long prize = lotto.calculatePrizeMoney(winningNumber, bonusNumber);

        //then
        assertThat(prize).isEqualTo(THIRD_PRIZE.getPrize());
    }

    @Test
    @DisplayName("로또번호를 비교하여 4등상금을 얻는다")
    void 로또번호를_비교하여_4등상금을_얻는다() {
        //given
        BonusNumber bonusNumber = new BonusNumber("7");
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber.getBonusNumber());

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));

        //when
        Long prize = lotto.calculatePrizeMoney(winningNumber, bonusNumber);

        //then
        assertThat(prize).isEqualTo(FORTH_PRIZE.getPrize());
    }

    @Test
    @DisplayName("로또번호를 비교하여 5등상금을 얻는다")
    void 로또번호를_비교하여_5등상금을_얻는다() {
        //given
        BonusNumber bonusNumber = new BonusNumber("7");
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber.getBonusNumber());

        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        //when
        Long prize = lotto.calculatePrizeMoney(winningNumber, bonusNumber);

        //then
        assertThat(prize).isEqualTo(FIFTH_PRIZE.getPrize());
    }

    @Test
    @DisplayName("5등안에 들지 못하였을 경우 상금은 0원이다")
    void 당첨범위에_들지_못하였을_경우_상금은_0원이다() {
        //given
        BonusNumber bonusNumber = new BonusNumber("7");
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber.getBonusNumber());

        Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));

        //when
        Long prize = lotto.calculatePrizeMoney(winningNumber, bonusNumber);

        //then
        assertThat(prize).isEqualTo(0L);
    }
}
