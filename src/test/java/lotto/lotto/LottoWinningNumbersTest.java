package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoWinningNumbersTest {

    Lotto lotto;
    Lottos lottos;

    @BeforeEach
    void setUp() throws Exception {
        lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Constructor<Lottos> constructor = Lottos.class.getDeclaredConstructor(List.class);
        constructor.setAccessible(true);
        lottos = constructor.newInstance(List.of(lotto));
    }

    @Test
    void 당첨_번호와_로또_번호가_일치한지_확인한다() throws Exception {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.of(winningNumbers, bonusNumber);

        // when
        List<Integer> result = lottoWinningNumbers.calculateWinningCount(lottos);

        // then
        assertThat(result.get(0)).isEqualTo(6);
    }

    @Test
    void 보너스_번호와_로또_번호가_일치한지_확인한다() throws Exception {
        // given
        List<Integer> winningNumbers = List.of(11, 12, 13, 14, 15, 16);
        int bonusNumber = 1;
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.of(winningNumbers, bonusNumber);

        // when
        List<Boolean> result = lottoWinningNumbers.calculateBonusCheck(lottos);

        // then
        assertThat(result.get(0)).isTrue();
    }

}