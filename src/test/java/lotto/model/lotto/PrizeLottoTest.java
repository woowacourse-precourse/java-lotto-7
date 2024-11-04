package lotto.model.lotto;

import java.util.List;
import lotto.exception.LottoErrorStatus;
import lotto.exception.LottoException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 로또를 관리하는 모델 테스트")
class PrizeLottoTest {

    @Test
    public void 당첨_로또_정상_생성() {
        // given
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        PrizeLotto prizeLotto = PrizeLotto.from(winningLottoNumbers, bonusNumber);

        // then
        Assertions.assertThat(prizeLotto).isNotNull();
    }

    @Test
    public void 보너스_번호_중복시_예외_발생() {
        // given
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        // when, then
        Assertions.assertThatThrownBy(() -> PrizeLotto.from(winningLottoNumbers, bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorStatus.LOTTO_NUMBER_DUPLICATED.getMessage());
    }

    @Test
    public void 우승_번호_중복시_예외_발생() {
        // given
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 6, 6);
        int bonusNumber = 7;

        // when, then
        Assertions.assertThatThrownBy(() -> PrizeLotto.from(winningLottoNumbers, bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage(LottoErrorStatus.LOTTO_NUMBER_DUPLICATED.getMessage());
    }

    @Test
    public void 우승번호_갯수_세기() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> prizeLottoNumbers = List.of(10, 20, 3, 4, 5, 6);
        int bonusNumber = 7;
        PrizeLotto prizeLotto = PrizeLotto.from(prizeLottoNumbers, bonusNumber);

        // when
        int matched = prizeLotto.countWinningLottoMatched(lotto);

        // then
        Assertions.assertThat(matched).isEqualTo(4);
    }

    @Test
    public void 보너스번호_맞춤_판단() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> prizeLottoNumbers = List.of(10, 20, 3, 4, 5, 6);
        int bonusNumber = 7;
        PrizeLotto prizeLotto = PrizeLotto.from(prizeLottoNumbers, bonusNumber);

        // when
        boolean isBonusNumberMatched = prizeLotto.isBonusNumberMatched(lotto);

        // then
        Assertions.assertThat(isBonusNumberMatched).isTrue();
    }
}
