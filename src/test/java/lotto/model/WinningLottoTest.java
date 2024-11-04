package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningLottoTest {
    @Test
    void 당첨_번호와_보너스_번호가_겹치는_경우_예외가_발생한다() {

        List<LottoNumber> winningNumbers = List.of(
                LottoNumber.valueOf("1"),
                LottoNumber.valueOf("2"),
                LottoNumber.valueOf("3"),
                LottoNumber.valueOf("4"),
                LottoNumber.valueOf("5"),
                LottoNumber.valueOf("6")
        );
        LottoNumber bonusNumber = LottoNumber.valueOf("5");

        assertThatThrownBy(() -> new WinningLotto(new Lotto(winningNumbers), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호와 보너스볼은 중복될 수 없습니다.");
    }

}
