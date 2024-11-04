package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.ValueSources;

import java.util.List;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("구입 양 만큼의 6개 번호를 가진 로또를 리스트를 반환한다.")
    @ParameterizedTest(name = "로또의 개수가 {0}이면 크기가 6인 {0}개의 로또를 반환한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    void 로또_리스트_반환_테스트(int lottoAmount) {
        List<List<Integer>> lottos = lottoService.publishLotto(lottoAmount);
        Assertions.assertAll(() ->
                        Assertions.assertEquals(lottoAmount, lottos.size()),
                () -> {
                    for (List<Integer> lotto : lottos) {
                        Assertions.assertEquals(6, lotto.size());
                    }
                }
        );
    }


}
