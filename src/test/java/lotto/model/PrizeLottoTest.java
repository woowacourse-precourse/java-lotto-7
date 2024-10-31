package lotto.model;

import java.util.List;
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
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 우승_번호_중복시_예외_발생() {
        // given
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 6, 6);
        int bonusNumber = 7;

        // when, then
        Assertions.assertThatThrownBy(() -> PrizeLotto.from(winningLottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}