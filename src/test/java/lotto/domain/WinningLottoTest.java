package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 정상적으로_당첨_로또_번호_클래스_생성() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int number = 7;

        Lotto winningLotto = new Lotto(numbers);
        LottoNumber bonusNumber = new LottoNumber(number);

        // when
        WinningLotto winningLottoResult = new WinningLotto(winningLotto, bonusNumber);

        // then
        assertThat(winningLottoResult.getWinningLotto().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLottoResult.getBonusNumber()).isEqualTo(7);
    }

    @Test
    void 당첨된_로또_번호_개수_확인() {
        // given
        List<Integer> lottoNumbers = List.of(4, 5, 6, 7, 8, 9);
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusLottoNumber = 7;

        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        LottoNumber bonusNumber = new LottoNumber(bonusLottoNumber);

        // when
        WinningLotto winningLottoResult = new WinningLotto(winningLotto, bonusNumber);
        Integer matchedNumbersCount = winningLottoResult.matchCount(lotto);

        // then
        assertThat(matchedNumbersCount).isEqualTo(3);
    }

    @Test
    void 로또_번호에_보너스_번호가_포함_되어있는_경우() {
        // given
        List<Integer> lottoNumbers = List.of(4, 5, 6, 7, 8, 9);
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusLottoNumber = 7;

        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        LottoNumber bonusNumber = new LottoNumber(bonusLottoNumber);

        // when
        WinningLotto winningLottoResult = new WinningLotto(winningLotto, bonusNumber);
        Boolean isBonusMatch = winningLottoResult.isBonusMatch(lotto);

        // then
        assertThat(isBonusMatch).isTrue();
    }

    @Test
    void 로또_번호에_보너스_번호가_포함_되어있지_않는_경우() {
        // given
        List<Integer> lottoNumbers = List.of(4, 5, 6, 7, 8, 9);
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusLottoNumber = 10;

        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        LottoNumber bonusNumber = new LottoNumber(bonusLottoNumber);

        // when
        WinningLotto winningLottoResult = new WinningLotto(winningLotto, bonusNumber);
        Boolean isBonusMatch = winningLottoResult.isBonusMatch(lotto);

        // then
        assertThat(isBonusMatch).isFalse();
    }

    @Test
    void 예외_당첨_로또_번호와_보너스_번호가_중복되는_경우() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int number = 6;

        Lotto winningLotto = new Lotto(numbers);
        LottoNumber bonusNumber = new LottoNumber(number);

        // when & then
        assertThatThrownBy(() -> new WinningLotto(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호에 중복된 번호가 존재합니다.");
    }
}