package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView = new InputView();

    @Test
    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    void 로또_구입_금액이_1000원으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        //given
        int money = 13001;

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateInputMoney(money);
        });
    }

    @Test
    @DisplayName("당첨 번호에 숫자가 아닌 값이 존재한다면 예외가 발생한다.")
    void 당첨_번호에_숫자가_아닌_값이_존재한다면_예외가_발생한다() {
        //given
        List<String> winningNumbers = List.of("1", "a", "2", "3", "4", "5");

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.convertStringToInteger(winningNumbers);
        });
    }

    @Test
    @DisplayName("당첨 번호를 6개 미만이나 초과하여 받는다면 예외가 발생한다.")
    void 당첨_번호를_6개_미만이나_초과하여_받는다면_예외가_발생한다() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateNumberQuantity(winningNumbers);
        });
    }

    @Test
    @DisplayName("당첨 번호가 1 ~ 45 범위의 숫자가 아니라면 예외가 발생한다.")
    void 당첨_번호가_1_45_범위의_숫자가_아니라면_예외가_발생한다() {
        //given
        int number = 100;

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateInputNumber(number);
        });
    }

    @Test
    @DisplayName("당첨 번호들 중 중복된 숫자가 있는 경우 예외가 발생한다.")
    void 당첨_번호들_중_중복된_숫자가_있는_경우_예외가_발생한다() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateDuplicatedNumber(winningNumbers);
        });
    }

    @Test
    @DisplayName("보너스 번호가 1 ~ 45 범위의 숫자가 아니라면 예외가 발생한다.")
    void 보너스_번호가_1_45_범위의_숫자가_아니라면_예외가_발생한다() {
        //given
        int number = 100;

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateInputNumber(number);
        });
    }

    @Test
    @DisplayName("보너스 번호가 입력한 당첨 번호와 중복되는 숫자라면 예외가 발생한다.")
    void 보너스_번호가_입력한_당첨_번호와_중복되는_숫자라면_예외가_발생한다() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumbers = 5;

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateDuplicatedFromWinningNumbers(bonusNumbers, winningNumbers);
        });
    }
}