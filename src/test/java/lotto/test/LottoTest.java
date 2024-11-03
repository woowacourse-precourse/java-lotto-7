package lotto.test;

import static lotto.constant.ErrorMessage.DUPLICATE_WINNING_NUMBER;
import static lotto.constant.ErrorMessage.NOT_SIX_WINNING_NUMBER;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.ArrayList;
import java.util.List;
import lotto.BonusNumber;
import lotto.Lotto;
import lotto.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 번호를 담는 Lotto에서")
public class LottoTest {

    @Test
    @DisplayName("정상적인 번호들이면 오류가 발생하지 않는다")
    public void normalNumber() {
        //given
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        //when

        //then
        assertThatNoException().isThrownBy(() -> new Lotto(numbers));
    }

    @Test
    @DisplayName("번호가 6개가 아니면 오류가 발생한다")
    public void notSixNumber() {
        //given
        List<Integer> numbers = new ArrayList<>();
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_SIX_WINNING_NUMBER.getMessage());
    }

    @Test
    @DisplayName("중복된 번호가 있으면 오류가 발생한다")
    public void duplicatedNumber() {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        for (int i = 1; i <= 5; i++) {
            numbers.add(i);
        }
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_WINNING_NUMBER.getMessage());
    }


    @Test
    @DisplayName("lotto 번호와 당첨번호를 비교해서 같은 수의 갯수를 반환한다")
    public void containWinningNumbers() {
        //given
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        Lotto lotto = new Lotto(numbers);

        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        //when
        //then
        Assertions.assertThat(lotto.compareWinningNumbers(winningNumbers)).isEqualTo(6);
    }

    @Test
    @DisplayName("lotto 번호와 bonus 번호를 비교해서 포함하면 1을 반환한다")
    public void containBonusNumber() {
        //given
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        Lotto lotto = new Lotto(numbers);
        BonusNumber bonusNumber = new BonusNumber(1);
        //when
        //then
        Assertions.assertThat(lotto.compareBonusNumber(bonusNumber)).isEqualTo(1);
    }

    @Test
    @DisplayName("lotto 번호와 bonus 번호를 비교해서 포함하지 않으면 0을 반환한다")
    public void notContainBonusNumber() {
        //given
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        Lotto lotto = new Lotto(numbers);
        BonusNumber bonusNumber = new BonusNumber(7);
        //when
        //then
        Assertions.assertThat(lotto.compareBonusNumber(bonusNumber)).isEqualTo(0);
    }
}
