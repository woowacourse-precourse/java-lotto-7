package lotto.service;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {

    private LottoService lottoService;
    private Lotto lotto;
    private BonusNumber bonusNumber;

    @BeforeEach
    public void setUp() {
        this.lotto = new Lotto();
        this.bonusNumber = new BonusNumber();
        this.lottoService = new LottoService(lotto, bonusNumber);
    }

    @Test
    @DisplayName("로또의 당첨 번호를 입력할 수 있다.")
    void 당첨_번호_입력_테스트() throws Exception {
        // given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        // when
        lottoService.addWinningNumbers(winningNumbers);

        // then
        assertThat(lotto.getNumbers()).isEqualTo(winningNumbers);
    }

    @Test
    @DisplayName("로또의 보너스 번호를 입력할 수 있다.")
    void 보너스_번호_입력_테스트() throws Exception {
        // given
        int number = 7;

        // when
        lottoService.updateBonusNumber(number);

        // then
        assertThat(lotto.getNumbers()).isEqualTo(number);
    }
}
