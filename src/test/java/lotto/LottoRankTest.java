package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"0:FIRST", "1:SECOND", "2:THIRD", "3:FOURTH", "4:FIFTH"}, delimiter = ':')
    void 이름을_통한_당첨_등수_생성_확인(int index, String name) {
        assertThat(LottoRank.values()[index].name()).isEqualTo(name);
    }
}
