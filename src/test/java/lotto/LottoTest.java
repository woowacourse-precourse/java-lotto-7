package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
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

    @DisplayName("로또 출력시 정상적으로 오름차순 출력이 되는지 확인")
    @Test
    void 로또_출력_오름차순_출력() {
        Lotto lotto = new Lotto(List.of(15,13,20,1,9,40));
        assertEquals("[1, 9, 13, 15, 20, 40]", lotto.printNumber());
    }

    @DisplayName("로또 출력시 정상적으로 오름차순 출력이 되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7:1", "1,2,3,4,5,8:6:2", "1,2,3,4,5,8:7:3", "1,2,3,4,8,9:10:4", "1,2,3,8,9,10:11:5"}, delimiter = ':')
    void 로또_당첨_등수_확인하기(String winnings, String bonus, String rank) {
        List<Integer> w = Arrays.stream(winnings.split(",")).mapToInt(Integer::valueOf).boxed().toList();
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertEquals(Integer.parseInt(rank), lotto.getWinningNumber(w, Integer.parseInt(bonus)));
    }
}
