package lotto.model;

import java.util.List;
import java.util.stream.Stream;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


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

        assertThat(lottoModel.readWinLotto().getNumbers()).isEqualTo(winLottoNumber);
        assertThat(lottoModel.readBonusNumber()).isEqualTo(bonusNumber);
    }


}
