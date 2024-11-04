package lotto;

import lotto.Service.LottoService;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 로또서비스를_통해_로또클래스에_도달한다(){
        String input = "1,2,3,4,5,6";
        Lotto lotto = lottoService.WinningNumberSplit();
        List<Integer> expectedNumbers = Arrays.asList(1,2,3,4,5,6);

        assertThat(lotto.getNumbers()).isEqualTo(expectedNumbers);

    }


}
