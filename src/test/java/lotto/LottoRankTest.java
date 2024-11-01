package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

    @BeforeEach
    void set_up() {
        Arrays.stream(WinningRank.values()).forEach(WinningRank::resetSuccessMatch);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:FIFTH", "1:FOURTH", "2:THIRD", "3:SECOND", "4:FIRST"}, delimiter = ':')
    void 이름을_통한_당첨_등수_생성_확인(int index, String expectedName) {
        String rankName = WinningRank.values()[index].name();

        assertThat(rankName).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:true:FIRST", "6:false:FIRST", "5:true:SECOND", "5:false:THIRD", "4:true:FOURTH",
            "4:false:FOURTH", "3:true:FIFTH", "3:false:FIFTH"}, delimiter = ':')
    void 당첨_랭킹_매칭(int requiredMatch, boolean hasBonus, String name) {
        WinningRank rank = WinningRank.of(requiredMatch, hasBonus);
        WinningRank expectedRank = WinningRank.valueOf(name);

        assertThat(rank).isEqualTo(expectedRank);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:true", "5:true", "5:false", "4:true", "3:false"}, delimiter = ':')
    void 등수별_매칭_수_기록(int requiredMatch, boolean hasBonus) {
        WinningRank rank = WinningRank.of(requiredMatch, hasBonus);

        assertThat(rank.getSuccessMatch()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:true:2000000000", "5:true:30000000", "5:false:1500000", "4:true:50000",
            "3:false:5000"}, delimiter = ':')
    void 등수별_수익_계산(int requiredMatch, boolean hasBonus, int expectedRevenue) {
        WinningRank rank = WinningRank.of(requiredMatch, hasBonus);

        assertThat(rank.calculateRevenue()).isEqualTo(expectedRevenue);
    }

    @Test
    void 당첨_현황() {
        WinningRank.of(3, false);
        WinningRank.of(5, true);

        assertThat(WinningRank.winningStatus()).isEqualTo("3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                + "6개 일치 (2,000,000,000원) - 0개");
    }
}
