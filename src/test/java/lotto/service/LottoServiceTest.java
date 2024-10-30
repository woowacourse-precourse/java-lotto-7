package lotto.service;

import lotto.domain.lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoServiceTest {

    private LottoService lottoService;
    private Lotto lotto;

    @BeforeEach
    public void setUp() {
        lotto = new Lotto();
        this.lottoService = new LottoService(lotto);
    }

    @Test
    @DisplayName("로또의 당첨 번호를 입력할 수 있다.")
    void 당첨_번호_입력_테스트() throws Exception {
        // given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        // when
        lottoService.addWinningNumbers(winningNumbers);

        // then
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(winningNumbers);
    }
}
