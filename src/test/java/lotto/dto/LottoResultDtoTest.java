package lotto.dto;

import static lotto.domain.LottoResult.FIFTH;
import static lotto.domain.LottoResult.FIRST;
import static lotto.domain.LottoResult.FOURTH;
import static lotto.domain.LottoResult.NONE;
import static lotto.domain.LottoResult.SECOND;
import static lotto.domain.LottoResult.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultDtoTest {
    @Test
    @DisplayName("of - 로또 결과를 보고 이익률을 계산하고 나올 수 있는 결과에 대해 정보를 재저장한다.")
    void successMakeLottoResultDto() {
        // given
        Map<LottoResult, Integer> result = createResult();
        int money = 10000;
        // when
        LottoResultDto lottoResultDto = LottoResultDto.of(result, money);
        // then
        Map<LottoResult, Integer> totalResult = lottoResultDto.result();
        assertThat(totalResult.get(FIRST)).isEqualTo(0);
        assertThat(totalResult.get(SECOND)).isEqualTo(0);
        assertThat(totalResult.get(THIRD)).isEqualTo(0);
        assertThat(totalResult.get(FOURTH)).isEqualTo(1);
        assertThat(totalResult.get(FIFTH)).isEqualTo(3);
        assertThat(totalResult.containsKey(NONE)).isFalse();
        assertThat(lottoResultDto.profitRate()).isEqualTo(650);
    }

    //  당첨 결과 : 5등 3번, 4등 1번
    private Map<LottoResult, Integer> createResult() {
        Map<LottoResult, Integer> result = new EnumMap<>(LottoResult.class);
        result.put(FIFTH, 3);
        result.put(FOURTH, 1);
        return result;
    }

}