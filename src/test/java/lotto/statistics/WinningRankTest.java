package lotto.statistics;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningRankTest {

    @BeforeEach
    void set_up() {
        Arrays.stream(WinningRank.values()).forEach(WinningRank::resetSuccessMatch);
    }

    @AfterEach
    void 테스트_후_당첨_현황_초기화() {
        Arrays.stream(WinningRank.values()).forEach(WinningRank::resetSuccessMatch);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:NONE", "1:FIFTH", "2:FOURTH", "3:THIRD", "4:SECOND", "5:FIRST"}, delimiter = ':')
    void 이름을_통한_당첨_등수_생성_확인(int index, String expectedName) {
        String rankName = WinningRank.values()[index].name();

        assertThat(rankName).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @CsvSource(value = {"NONE:0", "FIFTH:3", "FOURTH:4", "THIRD:5", "SECOND:5", "FIRST:6"}, delimiter = ':')
    void 등수마다_필요한_로또_번호_매칭_개수(WinningRank rank, int requiredMatch) {
        assertThat(rank.getRequiredMatch()).isEqualTo(requiredMatch);
    }

    @ParameterizedTest
    @CsvSource(value = {"NONE:0", "FIFTH:5000", "FOURTH:50000", "THIRD:1500000", "SECOND:30000000",
            "FIRST:2000000000"}, delimiter = ':')
    void 등수별_당첨_금액(WinningRank rank, int reward) {
        assertThat(rank.getReward()).isEqualTo(reward);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:true:FIRST", "6:false:FIRST", "5:true:SECOND", "5:false:THIRD", "4:true:FOURTH",
            "4:false:FOURTH", "3:true:FIFTH", "3:false:FIFTH", "2:false:NONE", "2:true:NONE"}, delimiter = ':')
    void 당첨_랭킹_매칭(int requiredMatch, boolean hasBonus, String name) {
        WinningRank rank = WinningRank.match(requiredMatch, hasBonus);
        WinningRank expectedRank = WinningRank.valueOf(name);

        assertThat(rank).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:true", "5:true", "5:false", "4:true", "3:false"}, delimiter = ':')
    void 등수별_매칭_수_기록(int requiredMatch, boolean hasBonus) {
        WinningRank rank = WinningRank.match(requiredMatch, hasBonus);

        assertThat(rank.getSuccessMatch()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:true:2000000000", "5:true:30000000", "5:false:1500000", "4:true:50000",
            "3:false:5000"}, delimiter = ':')
    void 등수별_수익_계산(int requiredMatch, boolean hasBonus, int expectedRevenue) {
        WinningRank rank = WinningRank.match(requiredMatch, hasBonus);

        assertThat(rank.calculateRevenue()).isEqualTo(expectedRevenue);
    }
}
