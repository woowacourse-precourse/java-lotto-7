package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottosTest {

    public static final int FIRST_RANK_PRIZE = 2_000_000_000;
    Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 구매한_로또_개수_만큼_로또가_생성이_된다() throws Exception {
        // given
        int lottoCount = 5;

        // when
        Lottos lottos = Lottos.of(lottoCount);

        // then
        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }

    @Test
    void 당첨_번호와_로또_번호가_6개가_일치하면_1등이다() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Constructor<Lottos> constructor = Lottos.class.getDeclaredConstructor(List.class);
        constructor.setAccessible(true);
        Lottos lottos = constructor.newInstance(List.of(lotto));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.of(winningNumbers, bonusNumber);

        // when
        Map<String, Integer> lottoResult = lottos.lottoDraw(lottoWinningNumbers);

        // then
        assertThat(lottoResult.get("1등")).isEqualTo(1);
        assertThat(lottoResult.get("2등")).isEqualTo(0);
        assertThat(lottoResult.get("3등")).isEqualTo(0);
        assertThat(lottoResult.get("4등")).isEqualTo(0);
        assertThat(lottoResult.get("5등")).isEqualTo(0);
    }
    @Test
    void 당첨_번호와_로또_번호가_5개가_일치하고_보너스_번호까지_일치하면_2등이다() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Constructor<Lottos> constructor = Lottos.class.getDeclaredConstructor(List.class);
        constructor.setAccessible(true);
        Lottos lottos = constructor.newInstance(List.of(lotto));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 10);
        int bonusNumber = 6;

        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.of(winningNumbers, bonusNumber);

        // when
        Map<String, Integer> lottoResult = lottos.lottoDraw(lottoWinningNumbers);

        // then
        assertThat(lottoResult.get("1등")).isEqualTo(0);
        assertThat(lottoResult.get("2등")).isEqualTo(1);
        assertThat(lottoResult.get("3등")).isEqualTo(0);
        assertThat(lottoResult.get("4등")).isEqualTo(0);
        assertThat(lottoResult.get("5등")).isEqualTo(0);
    }

    @Test
    void 당첨_번호와_로또_번호가_5개만_일치하면_3등이다() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Constructor<Lottos> constructor = Lottos.class.getDeclaredConstructor(List.class);
        constructor.setAccessible(true);
        Lottos lottos = constructor.newInstance(List.of(lotto));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 10);
        int bonusNumber = 11;

        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.of(winningNumbers, bonusNumber);

        // when
        Map<String, Integer> lottoResult = lottos.lottoDraw(lottoWinningNumbers);

        // then
        assertThat(lottoResult.get("1등")).isEqualTo(0);
        assertThat(lottoResult.get("2등")).isEqualTo(0);
        assertThat(lottoResult.get("3등")).isEqualTo(1);
        assertThat(lottoResult.get("4등")).isEqualTo(0);
        assertThat(lottoResult.get("5등")).isEqualTo(0);
    }

    @Test
    void 당첨_번호와_로또_번호가_6개가_일치하면_1등_상금을_계산할_수_있다() throws Exception {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Constructor<Lottos> constructor = Lottos.class.getDeclaredConstructor(List.class);
        constructor.setAccessible(true);
        Lottos lottos = constructor.newInstance(List.of(lotto));

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.of(winningNumbers, bonusNumber);

        // when
        Map<String, Integer> lottoResult = lottos.lottoDraw(lottoWinningNumbers);
        int price = lottos.totalWinningPrice(lottoResult);

        // then
        assertThat(price).isEqualTo(FIRST_RANK_PRIZE);
    }

}