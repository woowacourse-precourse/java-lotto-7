package lotto.service;


import java.util.Iterator;
import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;
import lotto.fixture.LottoFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private List<LottoNumber> testLotto = LottoFixture.createTestLotto();
    private LottoService lottoService = new LottoService();

    @Test
    @DisplayName("구매한 갯수만큼의 랜덤 로또를 생성한다")
    void make_lotto_as_ticket() {
        int ticket = 3;
        List<Lotto> testLottos = lottoService.createRandomLottos(ticket).lottos();

        Assertions.assertEquals(testLottos.size(), ticket);
    }

    @Test
    @DisplayName("입력한 당첨 번호로 로또를 생성한다")
    void make_lotto_with_winning_input() {
        String winningInputs = "1,2,3,4,5,6";
        Lotto comparsionWinningLotto = new Lotto(testLotto);
        Iterator<LottoNumber> iterator = comparsionWinningLotto.getNumbers().iterator();

        Lotto winningLotto = lottoService.createWinningLottoNumbers(winningInputs);

        winningLotto.getNumbers().forEach(
                number -> Assertions.assertEquals(number, iterator.next())
        );
    }
}
