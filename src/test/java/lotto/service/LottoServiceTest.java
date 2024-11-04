package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.Lotto;
import lotto.WinningLotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    public static LottoService lottoService;

    @BeforeAll
    public static void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("당첨_번호와_일치하는_번호_갯수를_반환한다")
    void 당첨_번호와_일치하는_번호_갯수를_반환한다() {
        //Given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto machineLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        //When
        int accordCount = lottoService.countMatchNumbers(machineLotto, winningLotto);
        //Then
        assertThat(accordCount).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스_볼이_당첨_번호에_포함되는지_여부를_반환한다")
    void 보너스_볼이_당첨_번호에_포함되는지_여부를_반환한다() {
        //Given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto machineLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        //When
        boolean accordCount = lottoService.checkBonusNumberMatch(machineLotto, winningLotto);
        //Then
        assertThat(accordCount).isTrue();
    }
}