package lotto;

import lotto.model.Price;
import lotto.model.BonusLotto;
import lotto.model.Lotto;
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

}
