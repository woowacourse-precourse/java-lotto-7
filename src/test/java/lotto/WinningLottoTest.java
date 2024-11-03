package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("당첨 로또의 보너스 번호가 로또의 번호와 중복되면 예외가 발생한다.")
    @Test
    void 로또_번호에_당첨_로또의_보너스_번호가_포함되어있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 3, 6, 9, 13, 15), 15))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void 보너스_번호에_허동되는_범위_이외의_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 3, 6, 8, 13, 45),48))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
