package lotto;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoDataTest {
    @Test
    public void 통계_내용_테스트() {
        List<Lotto> generatedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8))
        );
        List<Integer> userPickedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        LottoData lottoData = new LottoData(generatedLottos, userPickedNumbers, bonusNumber);

        lottoData.produceStatistics();

        assertThat(lottoData.getMatches()).contains(EnumLottoPrice.MATCH_5);
        assertThat(lottoData.getMatches()).contains(EnumLottoPrice.MATCH_6);
    }
}
