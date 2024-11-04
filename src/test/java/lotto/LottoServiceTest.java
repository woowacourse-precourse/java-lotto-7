package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또 구매 테스트")
    void buyLottoTest() {
        int amount = 14000;
        List<Lotto> lottos = lottoService.buyLotto(amount);

        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 번호 정렬 테스트")
    void sortLottoTest() {
        List<Integer> numbers = List.of(3, 2, 1, 6, 5, 4);
        List<Integer> sortedNumbers = lottoService.sortLotto(numbers);

        assertThat(sortedNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
