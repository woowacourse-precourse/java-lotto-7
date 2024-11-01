package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

    @BeforeEach
    void set_up() {
        Arrays.stream(LottoRank.values()).forEach(LottoRank::resetMatch);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:FIRST", "1:SECOND", "2:THIRD", "3:FOURTH", "4:FIFTH"}, delimiter = ':')
    void 이름을_통한_당첨_등수_생성_확인(int index, String name) {
        assertThat(LottoRank.values()[index].name()).isEqualTo(name);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:true:FIRST", "6:false:FIRST", "5:true:SECOND", "5:false:THIRD", "4:true:FOURTH",
            "4:false:FOURTH", "3:true:FIFTH", "3:false:FIFTH"}, delimiter = ':')
    void 당첨_랭킹_매칭(int matchCount, boolean isMatchedBonus, String name) {
        LottoRank rank = LottoRank.matchRank(matchCount, isMatchedBonus);
        LottoRank expectedRank = LottoRank.valueOf(name);

        assertThat(rank).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:true", "5:true", "5:false", "4:true", "3:false"}, delimiter = ':')
    void 등수별_매칭_수_기록(int matchCount, boolean isMatchedBonus) {
        LottoRank rank = LottoRank.matchRank(matchCount, isMatchedBonus);

        assertThat(rank.getMatch()).isEqualTo(1);
    }
}
