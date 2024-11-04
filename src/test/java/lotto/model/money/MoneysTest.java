package lotto.model.money;

import lotto.dto.MatchDto;
import lotto.model.match.Match;
import lotto.model.match.Matches;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MoneysTest {
    @Test
    void 수익률을_반환한다() {
        //given
        Matches matches = new Matches(List.of(
                Match.of(3, false),
                Match.of(3, false),
                Match.of(5, true)
        ));
        List<MatchDto> matchDtos = matches.getMatchDtos();

        //when
        Moneys moneys = Moneys.of(matchDtos);
        double rateOfReturn = moneys.getRateOfReturn(Money.from(5000));

        //then
        assertThat(rateOfReturn).isEqualTo(600200.0);
    }
}