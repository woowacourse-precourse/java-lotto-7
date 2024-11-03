package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("출력할 문잘열을 반환한다.")
    void getResultForDisplay() {
        Map<Rank, Integer> map = settingMap();
        LottoResult lottoResult = LottoResult.of(map);

        String result = lottoResult.getResultForDisplay();

        assertThat(result).isEqualTo(
                "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }

    @Test
    @DisplayName("수익률을 반환한다.")
    void getRateOfReturn() {
        Map<Rank, Integer> map = settingMap();
        LottoResult lottoResult = LottoResult.of(map);

        double result = lottoResult.getRateOfReturn(Money.of(8000));

        assertThat(result).isEqualTo(0.0);
    }

    private static HashMap<Rank, Integer> settingMap() {
        HashMap<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIRST_PLACE, 0);
        map.put(Rank.SECOND_PLACE, 0);
        map.put(Rank.THIRD_PLACE, 0);
        map.put(Rank.FOURTH_PLACE, 0);
        map.put(Rank.FIFTH_PLACE, 0);
        return map;
    }

}