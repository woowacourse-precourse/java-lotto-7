package lotto.store.logger;

import lotto.store.lotto.Lotto;
import lotto.store.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoStoreLogFormatterTest {

    @DisplayName("로또 리스트를 출력할 수 있게 포맷팅")
    @Test
    void test1() {
        List<Lotto> lottos = List.of(
                toLotto(List.of(8, 21, 23, 41, 42, 43)),
                toLotto(List.of(3, 5, 11, 16, 32, 38)),
                toLotto(List.of(7, 11, 16, 35, 36, 44)),
                toLotto(List.of(1, 8, 11, 31, 41, 42)),
                toLotto(List.of(13, 14, 16, 38, 42, 45)),
                toLotto(List.of(7, 11, 30, 40, 42, 43)),
                toLotto(List.of(2, 13, 22, 32, 38, 45)),
                toLotto(List.of(1, 3, 5, 14, 22, 45))
        );

        LottoStoreLogFormatter formatter = new LottoStoreLogFormatter();
        String result = formatter.format(lottos);

        assertEquals(result, """
                8개를 구매했습니다.
                [8, 21, 23, 41, 42, 43]
                [3, 5, 11, 16, 32, 38]
                [7, 11, 16, 35, 36, 44]
                [1, 8, 11, 31, 41, 42]
                [13, 14, 16, 38, 42, 45]
                [7, 11, 30, 40, 42, 43]
                [2, 13, 22, 32, 38, 45]
                [1, 3, 5, 14, 22, 45]
                """);
    }

    private Lotto toLotto(List<Integer> numbers) {
        return new Lotto(toLottoNumbers(numbers));
    }

    private List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new).toList();
    }

}