package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchNumbersTest {

    private MatchNumbers matchNumbers;

    @BeforeEach
    void setUp() {
        matchNumbers = new MatchNumbers();
    }

    @Test
    void 세_개_일치하면_세_개_일치_값이_증가한다() {
        List<List<Integer>> lottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6)
        );
        List<Integer> userNumbers = List.of(1, 2, 3, 10, 11, 12);
        int bonusNumber = 13;

        matchNumbers.count(lottoNumbers, userNumbers, bonusNumber);

        assertThat(matchNumbers.getThreeMatch()).isEqualTo(1);
        assertThat(matchNumbers.getFourMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFiveMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFiveAndBonusMatch()).isEqualTo(0);
        assertThat(matchNumbers.getSixMatch()).isEqualTo(0);
    }

    @Test
    void 네_개_일치하면_네_개_일치_값이_증가한다() {
        List<List<Integer>> lottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6)
        );
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 10, 11);
        int bonusNumber = 12;

        matchNumbers.count(lottoNumbers, userNumbers, bonusNumber);

        assertThat(matchNumbers.getThreeMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFourMatch()).isEqualTo(1);
        assertThat(matchNumbers.getFiveMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFiveAndBonusMatch()).isEqualTo(0);
        assertThat(matchNumbers.getSixMatch()).isEqualTo(0);
    }

    @Test
    void 다섯_개_일치하면_다섯_개_일치_값이_증가한다() {
        List<List<Integer>> lottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 9)
        );
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 10);
        int bonusNumber = 11;

        matchNumbers.count(lottoNumbers, userNumbers, bonusNumber);

        assertThat(matchNumbers.getThreeMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFourMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFiveMatch()).isEqualTo(1);
        assertThat(matchNumbers.getFiveAndBonusMatch()).isEqualTo(0);
        assertThat(matchNumbers.getSixMatch()).isEqualTo(0);
    }

    @Test
    void 다섯_개와_보너스값이_일치하면_다섯_개와_보너스_일치_값이_증가한다() {
        List<List<Integer>> lottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 9)
        );
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 10);
        int bonusNumber = 9;

        matchNumbers.count(lottoNumbers, userNumbers, bonusNumber);

        assertThat(matchNumbers.getThreeMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFourMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFiveMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFiveAndBonusMatch()).isEqualTo(1);
        assertThat(matchNumbers.getSixMatch()).isEqualTo(0);
    }

    @Test
    void 여섯_개_일치하면_여섯_개_일치_값이_증가한다() {
        List<List<Integer>> lottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6)
        );
        List<Integer> userNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        matchNumbers.count(lottoNumbers, userNumbers, bonusNumber);

        assertThat(matchNumbers.getThreeMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFourMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFiveMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFiveAndBonusMatch()).isEqualTo(0);
        assertThat(matchNumbers.getSixMatch()).isEqualTo(1);
    }

    @Test
    void 로또_번호가_여러_개_일_때_3개_일치가_2개_나온다() {
        List<List<Integer>> lottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 7, 8, 9)
        );
        List<Integer> userNumbers = List.of(1, 2, 3, 10, 11, 12);
        int bonusNumber = 45;

        matchNumbers.count(lottoNumbers, userNumbers, bonusNumber);

        assertThat(matchNumbers.getThreeMatch()).isEqualTo(2);
        assertThat(matchNumbers.getFourMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFiveMatch()).isEqualTo(0);
        assertThat(matchNumbers.getFiveAndBonusMatch()).isEqualTo(0);
        assertThat(matchNumbers.getSixMatch()).isEqualTo(0);
    }

}
