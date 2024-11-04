package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.error.ErrorCode;
import org.junit.jupiter.api.Test;

class WinnerLottoTest {

    @Test
    void 당첨번호가_중복_실패() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinnerLotto winnerLotto = new WinnerLotto(numbers);
        assertThatThrownBy(() -> winnerLotto.addBonusNumber("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATED_NUMBER.getMessage());
    }

    @Test
    void 보너스번호가_범위를_벗어나면_실패() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinnerLotto winnerLotto = new WinnerLotto(numbers);
        assertThatThrownBy(() -> winnerLotto.addBonusNumber("50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.OUT_OF_RANGE.getMessage());
    }

    @Test
    void WinnerLotto_보너스번호_정상추가_성공() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinnerLotto winnerLotto = new WinnerLotto(numbers);
        winnerLotto.addBonusNumber("7");
        assertEquals(7, winnerLotto.getBonusNumber());
    }

    @Test
    void WinnerLotto_당첨번호_생성_성공() {
        WinnerLotto winnerLotto = WinnerLotto.from("1,2,3,4,5,6");
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expectedNumbers, winnerLotto.getNumbers());
    }

    @Test
    void WinnerLotto_당첨금_계산_정상_성공() {
        WinnerLotto winnerLotto = WinnerLotto.from("1,2,3,4,5,6");
        winnerLotto.addBonusNumber("7");
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Prize prize = winnerLotto.cacluatePrize(lotto);
        // Assuming Prize has a method to get the prize rank or amount
        assertEquals(Prize.FIRST, prize);
    }
}