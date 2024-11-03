package lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class IssuedLottoTest {

    @ParameterizedTest
    @MethodSource("lotto.parameterizedTest.MethodSource#provideLottoNumbers")
    void 정상적으로_생성된다(List<Integer> numbers) {
        // given
        Lotto lotto = new Lotto(numbers);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        // when
        IssuedLotto issuedLotto = new IssuedLotto(lottos);

        // then
        assertThat(issuedLotto.lottos()).isEqualTo(lottos);
    }
}