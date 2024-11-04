package lotto.domain.lotto;

import lotto.dto.PrizeResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.exception.ErrorMessage.LOTTO_NUMBER_DUPLICATED;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("당첨 번호 및 보너스 번호 테스트")
class WinningLottoWithBonusTest {
    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외를 발생시킨다.")
    @Test
    void 당첨_번호와_보너스_번호가_중복되면_예외를_발생시킨다() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(6);

        // when, then
        assertThatThrownBy(() -> new WinningLottoWithBonus(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_DUPLICATED.getMessage());
    }

    @DisplayName("구매한 로또들을 당첨 번호 및 보너스 번호와 비교하여 당첨 결과를 반환한다.")
    @Test
    void 구매한_로또들을_당첨_번호_및_보너스_번호와_비교하여_당첨_결과를_반환한다() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLottoWithBonus winningLottoWithBonus = new WinningLottoWithBonus(winningLotto, bonusNumber);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));
        lottos.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 7, 8, 9, 10)));
        lottos.add(new Lotto(List.of(1, 7, 8, 9, 10, 11)));

        // when
        List<PrizeResponse> winningResult = winningLottoWithBonus.findWinningResult(lottos);

        // then
        assertEquals(winningResult.get(0).matchingNumberCount(), 0);
        assertEquals(winningResult.get(1).matchingNumberCount(), 3);
        assertEquals(winningResult.get(2).matchingNumberCount(), 4);
        assertEquals(winningResult.get(3).matchingNumberCount(), 5);
        assertEquals(winningResult.get(4).matchingNumberCount(), 5);
        assertEquals(winningResult.get(5).matchingNumberCount(), 6);
    }
}