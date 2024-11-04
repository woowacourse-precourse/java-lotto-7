package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.Lotto;
import lotto.constant.PrizeTier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


public class LottoModelTest {

    @DisplayName("The Lotto creation logic should generate the same number of lotto numbers as the input count.")
    @ParameterizedTest
    @ValueSource( ints = {1,2,3,4,5})
    void testCreateLottoServiceLogic(int lottoCount){
        LottoModel lottoModel = new LottoModel();

        List<Lotto> lottos = lottoModel.createLotto(lottoCount);


        assertThat(lottos.size()).isEqualTo(lottoCount);

    }

    @DisplayName("The saving win Lotto logic should storage the win Lotto numbers and bonus number from input")
    @Test
    void testSetWinLottoNumbersAndBonusNumber(){
        LottoModel lottoModel = new LottoModel();

        List<Integer> winLottoNumber = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;

        lottoModel.setWinLottoWithBonusNumber(winLottoNumber,bonusNumber);

        assertThat(lottoModel.getWinLotto().getNumbers()).isEqualTo(winLottoNumber);
        assertThat(lottoModel.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("The winning Info should return number of each prize tier")
    @Test
    void testCheckPrizeTier(){
        assertRandomUniqueNumbersInRangeTest(()->{
            LottoModel lottoModel = new LottoModel();
            List<Lotto> createdLottos = lottoModel.createLotto(8);
            List<Integer> winLottoNumber = List.of(1,2,3,4,5,6);
            int bonusNumber = 7;

            lottoModel.setWinLottoWithBonusNumber(winLottoNumber,bonusNumber);
            Map<PrizeTier,Integer> result = lottoModel.getWinningInfo();

            assertThat(result.get(PrizeTier.FIRST)).isEqualTo(2);
            assertThat(result.get(PrizeTier.SECOND)).isEqualTo(1);
            assertThat(result.get(PrizeTier.THIRD)).isEqualTo(1);
            assertThat(result.get(PrizeTier.FORTH)).isEqualTo(1);
            assertThat(result.get(PrizeTier.FIFTH)).isEqualTo(1);
            assertThat(result.get(PrizeTier.NONE)).isEqualTo(2);

        },
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,7),
                List.of(1,2,3,4,5,45),
                List.of(1,2,3,4,44,45),
                List.of(1,2,3,43,44,45),
                List.of(1,2,42,43,44,45),
                List.of(1,41,42,43,44,45),
                List.of(1,2,3,4,5,6));
    }


}
