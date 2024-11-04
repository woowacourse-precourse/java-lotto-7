package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @DisplayName("번호 일치 갯수가 2개 이하일 경우 LOSE 가 반환되어야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"0, false, LOSE", "1, false, LOSE", "2, false, LOSE", "0, true, LOSE"})
    void returnLoseLotto(int correctCount, boolean containBonusNumber, Rank expected) {

        Rank rank = Rank.determineRank(correctCount, containBonusNumber);

        assertThat(rank).isEqualTo(expected);
    }

    @DisplayName("번호 일치 갯수가 3개 이상일 경우 그에 맞는 등급이 반환된다.")
    @ParameterizedTest
    @CsvSource(value = {"3, false, FIFTH", "4, false, FOURTH", "6, false, FIRST"})
    void deterMineRank(int correctCount, boolean containBonusNumber, Rank expected) {

        Rank rank = Rank.determineRank(correctCount, containBonusNumber);

        assertThat(rank).isEqualTo(expected);
    }

    @DisplayName("번호 일치 갯수가 5개 일때 보너스 번호을 맞출경우 2등이 되고 아니면 3등이 된다.")
    @ParameterizedTest
    @CsvSource(value = {"5, false, THIRD", "5, true, SECOND"})
    void determineSecondRank(int correctCount, boolean containBonusNumber, Rank expected) {

        Rank rank = Rank.determineRank(correctCount, containBonusNumber);

        assertThat(rank).isEqualTo(expected);
    }
}