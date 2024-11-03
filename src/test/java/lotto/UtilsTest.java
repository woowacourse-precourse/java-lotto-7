package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    private final Utils utils = new Utils();

    @DisplayName("숫자가 아닌 다른 문자를 넣으면 예외가 발생한다.")
    @Test
    void 숫자가_아니면_예외가_발생한다() {
        String inputTest = "가나다";

        assertThatThrownBy(() -> utils.parseStringToInt(inputTest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자를 넣으면 정상 로직")
    @Test
    void 숫자면_정상로직이다() {
        String inputTest = "123";

        assertDoesNotThrow(() -> utils.parseStringToInt(inputTest));
    }

    @DisplayName("로또를 구매하면 1000원당 1개의 로또를 받는 로직")
    @Test
    void 구매금액_단위_1000당_로또_1개() {
        int inputTest = 10000;

        List<Lotto> lottos = utils.generateRandomLottoNumbers(inputTest);

        assertThat(lottos.size()).isEqualTo(inputTest / 1000);
    }

    @DisplayName("문자열을 받으면 ,단위로 숫자 리스트 반환하는 로직")
    @Test
    void 문자열_쉼표단위_숫자리스트_로직() {
        String inputTest = "1,2,3,4,5,6";

        assertThat(utils.convertToIntegerList(inputTest)).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호 6개가 맞으면 Map에 Rank.ONE부분이 +1이 된다.")
    @Test
    void 로또번호_6개정답_Map_ONE갯수추가_로직() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(numbers);
        int bonusNumber = 7;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(numbers));

        Map<Rank, Integer> resultCounts = utils.evaluateLottoRanks(winningNumber, bonusNumber, lottos);

        assertThat(resultCounts.get(Rank.ONE)).isEqualTo(1);
    }

    @DisplayName("로또 번호 5개와 보너스 번호가 맞으면 Map에 Rank.TWO부분이 +1이 된다.")
    @Test
    void 로또번호_5개일치_보너스번호_일치_Map_TWO갯수추가_로직() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(numbers);
        int bonusNumber = 7;
        List<Integer> myNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(myNumbers));

        Map<Rank, Integer> resultCounts = utils.evaluateLottoRanks(winningNumber, bonusNumber, lottos);

        assertThat(resultCounts.get(Rank.TWO)).isEqualTo(1);
    }
}
