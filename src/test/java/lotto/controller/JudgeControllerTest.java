package lotto.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.util.Grade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JudgeControllerTest {
    private JudgeController judgeController;
    private List<Lotto> lottos;
    private Lotto winning;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 44, 45)),
                new Lotto(List.of(1, 2, 3, 43, 44, 45)),
                new Lotto(List.of(1, 2, 42, 43, 44, 45)),
                new Lotto(List.of(1, 41, 42, 43, 44, 45)),
                new Lotto(List.of(40, 41, 42, 43, 44, 45))
        );
        winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        judgeController = new JudgeController(lottos, winning, bonusNumber);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 6",
            "1, 5",
            "2, 5",
            "3, 4",
            "4, 3",
            "5, 2",
            "6, 1",
            "7, 0"
    })
    void 당첨_번호와_로또_번호가_일치하는_개수를_구한다(int lottoIndex, int expectedCount) {
        Lotto lotto = lottos.get(lottoIndex);
        assertThat(judgeController.countMatchingDigits(lotto))
                .isEqualTo(expectedCount);
    }
}
