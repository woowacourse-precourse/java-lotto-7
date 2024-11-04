package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest extends LottoTest {

    @Test
    void 보너스번호가_로또번호와_중복된_숫자가_입력되면_예외가_발생한다() {
        //given
        List<Integer> lotto_number = List.of(1, 2, 3, 4, 5, 6);
        int bonus_number = 5;
        //when
        Throwable thrown = catchException(() -> new WinningLotto(lotto_number, bonus_number));
        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("보너스 번호가 1~45사이에 없으면 예외가 발생하한다.")
    @Test
    void 보너스_번호가_범위내에_없으면_예외가_발생한다() {
        //given
        List<Integer> lotto_number = List.of(1, 2, 3, 4, 5, 6);
        int bonus_number = 46;
        //when
        Throwable thrown = catchException(() -> new WinningLotto(lotto_number,bonus_number));
        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }


}
