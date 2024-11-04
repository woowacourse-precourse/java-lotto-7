package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    LottoService service = new LottoService();

    @RepeatedTest(100)
    void 로또_번호_생성() {
        List<Integer> numbers = service.getLottoNumbers();

        long expected = numbers.stream().distinct().count();

        Assertions.assertEquals(numbers.size(), expected);
    }

    @Test
    void 모든_로또_등수_계산() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),   // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),   // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),   // 3등
                new Lotto(List.of(1, 2, 3, 4, 9, 10)),  // 4등
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),  // 5등
                new Lotto(List.of(1, 2, 8, 9, 10, 11)), // 해당 없음
                new Lotto(List.of(1, 8, 9, 10, 11, 12)), // 해당 없음
                new Lotto(List.of(8, 9, 10, 11, 12, 13)) // 해당 없음
        );

        List<Integer> result = service.calculateLottoResult(lottos, winningNumbers, bonusNumber);

        List<Integer> expected = List.of(3, 1, 1, 1, 1, 1);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 수익률_계산() {
        int money = 2_000_000_000;
        List<Integer> lottoResults = List.of(0, 0, 4, 7, 1, 3); // 당첨금: 130_565_000

        double rate = service.calculateRate(money, lottoResults);

        assertThat(rate).isEqualTo(6.53);
    }

    @Test
    void 수익률_제로_계산() {
        int money = 1_000;
        List<Integer> lottoResults = List.of(0, 0, 0, 0, 0, 0); // 당첨금: 0

        double rate = service.calculateRate(money, lottoResults);

        assertThat(rate).isEqualTo(0);
    }
}
