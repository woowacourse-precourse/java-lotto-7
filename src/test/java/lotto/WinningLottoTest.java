package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import constants.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {

    @Test
    void 당첨_로또_생성() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        assertThat(winningLotto).isEqualTo(new WinningLotto("1,2,3,4,5,6", "7"));
    }

    @Test
    void 입력된_당첨_번호가_6개가_아닌_경우_예외() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,6,7", "8"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MATCH_LOTTO_SIZE);
    }

    @Test
    void 입력된_당첨_번호에_숫자가_중복된_경우_예외() {
        assertThatThrownBy(() -> new WinningLotto("1,2,3,4,5,5", "8"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EXISTS_DUPLICATE_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,3,4,5,6", "1:2:3:4:5:6"})
    void 입력된_당첨_번호가_유효하지_않은_경우_예외(String winningNumbers) {
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTERED_INVALID_NUMBER);
    }

    @Test
    void 입력된_보너스번호가_유효하지_않은_경우_예외() {
        assertThatThrownBy(() -> new WinningLotto("1:2:3:4:5:6", "7,8"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTERED_INVALID_NUMBER);
    }

    @Test
    void 로또와_당첨로또_매칭_개수_계산() {
        List<LottoNumber> lottoNumbers = List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6));

        WinningLotto winningLotto = new WinningLotto("1,2,3,4,43,44", "45");

        assertThat(winningLotto.countWinnings(lottoNumbers)).isEqualTo(4);
    }

    @Test
    void 로또와_당첨로또_매칭_시_보너스번호_일치_여부_확인() {
        List<LottoNumber> lottoNumbers = List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6));

        WinningLotto winningLotto1 = new WinningLotto("1,2,3,4,5,44", "6");
        WinningLotto winningLotto2 = new WinningLotto("1,2,3,4,5,44", "45");

        assertThat(winningLotto1.containsBonus(lottoNumbers)).isTrue();
        assertThat(winningLotto2.containsBonus(lottoNumbers)).isFalse();
    }
}
