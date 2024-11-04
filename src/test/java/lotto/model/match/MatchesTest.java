package lotto.model.match;

import lotto.dto.MatchDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchesTest {
    @Test
    void 매치_정보에_맞는_매치의_개수를_조회한다() {
        //given
        Matches matches = new Matches(List.of(
                Match.of(3, false),
                Match.of(3, false),
                Match.of(5, true)
        ));

        //when
        List<MatchDto> matchDtos = matches.getMatchDtos();

        //then
        int threeEqualCount = matchDtos.stream()
                .filter(matchDto -> matchDto.matchInformation() == MatchInformation.THREE_MATCH)
                .mapToInt(MatchDto::count)
                .findFirst()
                .orElse(0);

        int fiveAndBonusEqualCount = matchDtos.stream()
                .filter(matchDto -> matchDto.matchInformation() == MatchInformation.FIVE_AND_BONUS_MATCH)
                .mapToInt(MatchDto::count)
                .findFirst()
                .orElse(0);

        assertThat(threeEqualCount).isEqualTo(2);
        assertThat(fiveAndBonusEqualCount).isEqualTo(1);
    }
}