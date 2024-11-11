package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.model.Judge;
import lotto.model.Lotto;
import lotto.util.Grade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JudgeTest {
    private Judge judge;
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
        judge = Judge.from(lottos, winning, bonusNumber);
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
        assertThat(judge.countMatchingDigits(lotto))
                .isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource({
            "6, FIRST",
            "4, FORTH",
            "3, FIFTH"

    })
    void 일치개수에_따라_등급을_지정한다(int matchCount, Grade expectedGrade) {
        assertThat(judge.assignGrade(matchCount, false))
                .isEqualTo(expectedGrade);
    }

    @Test
    void matchCount_5_일때_BONUS포함하면_SECOND_반환() {
        assertThat(judge.assignGrade(5, true)).isEqualTo(Grade.SECOND);
    }

    @Test
    void matchCount_5_일때_BONUS포함하지_않으면_THIRD_반환() {
        assertThat(judge.assignGrade(5, false)).isEqualTo(Grade.THIRD);
    }

    @ParameterizedTest
    @CsvSource({
            "2",
            "1",
            "0"

    })
    void matchCount_0이상_3미만_일때_NULL_반환(int matchCount) {
        assertThat(judge.assignGrade(matchCount, false)).isNull();
    }

    @Test
    void 유효하지_않은_matchCount_입력시_예외_발생() {
        assertThatThrownBy(() -> judge.assignGrade(-1, false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 matchCount입니다.");
    }
}
