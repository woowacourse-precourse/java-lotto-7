package lotto;

import lotto.View.OutputView;
import lotto.domain.Lotto;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.domain.Rank;
import lotto.domain.RankResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    LottoService lottoService = new LottoService();

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

    @Test
    void 로또_발행시_장수가_구매금액에서_1000을_나눈_개수만큼_발행된다() {
        LottoService lottoService = new LottoService();
        int purchase_amount = 6000;
        List<Lotto> lotto = lottoService.purchaseLotto(purchase_amount);
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("3000원으로 구매할 수 있는 로또 장수는 3장이다.")
    void 구매할수_있는_로또_장수(){
        LottoService lottoService = new LottoService();
        int purchase_amount = 3000;
        int number=lottoService.LottoNumber(purchase_amount);
        assertThat(number).isEqualTo(3);
    }
    @Test
    void 당첨_통계() {
        List<Lotto> userLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        RankResult rankResult = lottoService.winning_statistics(userLottos, winningNumbers, bonusNumber);
        assertThat(rankResult.getRank_Count().containsKey(Rank.FIRST)).isTrue();
        assertThat(rankResult.getRank_Count().get(Rank.FIRST)).isEqualTo(1);
    }

}


