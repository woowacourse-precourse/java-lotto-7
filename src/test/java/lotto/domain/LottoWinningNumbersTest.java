package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LottoWinningNumbersTest {

    @DisplayName("보너스 번호가 중복될 시 예외를 발생시킨다.")
    @Test
    void validateDuplicateBonusNumber() {

        // given
        Set<Integer> winningNumbers = new HashSet<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        // when then
        Assertions.assertThatThrownBy(() -> LottoWinningNumbers.createLottoWinningNumbers(winningNumbers, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 보너스 번호는 기존의 당첨 번호들과 중복일 수 없습니다.");

    }

}