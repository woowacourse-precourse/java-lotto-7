package lotto.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JudgeControllerTest {
    private List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
    }

    @Test
    void 당첨_번호와_로또_번호가_일치하는_개수를_구한다() {
        Lotto lotto = lottos.getFirst();
        Lotto winning = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        assertThat(new JudgeController(lottos, winning).countMatchingDigits(lotto))
                .isEqualTo(6);
    }
}
