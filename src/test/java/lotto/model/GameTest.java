package lotto.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    static Lotto lotto;
    static List<Lotto> lottoList = new ArrayList<>();
    static Lottos lottos;

    @BeforeAll
    static void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoList.add(lotto);
        lottos = new Lottos(lottoList);
    }

    @Test
    void 당첨_번호의_개수가_6개가_넘어가면_예외_발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_중복되면_예외_발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호의_개수가_당첨_번호와_중복되면_예외_발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}