package lotto.service;


import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoServiceTest {

    private LottoService lottoService = new LottoService();

    private static Stream<List<LottoNumber>> createTestLotto() {
        return Stream.of(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
        );
    }

    @Test
    @DisplayName("구매한 갯수만큼의 랜덤 로또를 생성한다")
    void make_lotto_as_ticket() {
        int ticket = 3;
        List<Lotto> testLottos = lottoService.createRandomLottos(ticket).lottos();

        Assertions.assertEquals(testLottos.size(), ticket);
    }

    @ParameterizedTest
    @MethodSource("createTestLotto")
    @DisplayName("입력한 당첨 번호로 로또를 생성한다")
    void make_lotto_with_winning_input(List<LottoNumber> numbers) {
        String winningInputs = "1,2,3,4,5,6";
        Lotto comparsionWinningLotto = new Lotto(numbers);
        Iterator<Integer> iterator = comparsionWinningLotto.getNumbers().iterator();

        Lotto winningLotto = lottoService.createWinningLottoNumbers(winningInputs);

        winningLotto.getNumbers().forEach(
                number -> Assertions.assertEquals(number, iterator.next())
        );
    }
}
