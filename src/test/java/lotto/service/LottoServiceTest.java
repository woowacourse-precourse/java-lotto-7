package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.model.LottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService(new LottoGenerator());
    }

    @Test
    void 금엑에_따른_로또_생성_개수_테스트() {
        int money = 5000;

        Lottos lottos = lottoService.makeLottos(money);

        assertEquals(money / 1000, lottos.lottos().size());
    }

    @Test
    void 문자열_파싱_테스트_1() {
        String winningNumbers = "1,2,3,4,5,6";

        Lotto lotto = lottoService.makeLottoBySplitting(winningNumbers);

        assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.numbers());
    }

    @Test
    void 문자열_파싱_테스트_2() {
        String winningNumbers = "  1, 2, 3,4 ,5  ,6  ";

        Lotto lotto = lottoService.makeLottoBySplitting(winningNumbers);

        assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.numbers());
    }

    @Test
    void 문자열_파싱_테스트_3() {
        String winningNumbers = "1,2,3,4,5,6,";

        Lotto lotto = lottoService.makeLottoBySplitting(winningNumbers);

        assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.numbers());
    }

    @Test
    void 문자열_파싱_실패_테스트_1() {
        String winningNumbers = ",1,2,3,4,5,6";

        assertThatThrownBy(() -> lottoService.makeLottoBySplitting(winningNumbers))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 문자열_파싱_실패_테스트_2() {
        String winningNumbers = ", , , , ,";

        assertThatThrownBy(() -> lottoService.makeLottoBySplitting(winningNumbers))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 문자열_파싱_실패_테스트_3() {
        String winningNumbers = "1,2,a,4,5,b";

        assertThatThrownBy(() -> lottoService.makeLottoBySplitting(winningNumbers))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 문자열_파싱_실패_테스트_4() {
        String winningNumbers = "1,2,3,4,#,5";

        assertThatThrownBy(() -> lottoService.makeLottoBySplitting(winningNumbers))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 문자열_파싱_실패_테스트_5() {
        String winningNumbers = "1,2,3, ,4,5";

        assertThatThrownBy(() -> lottoService.makeLottoBySplitting(winningNumbers))
                .isInstanceOf(NumberFormatException.class);
    }
}