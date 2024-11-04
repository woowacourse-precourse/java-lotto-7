package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @Test
    @DisplayName("로또 번호가 6개인지 확인")
    void 로또_번호_개수_확인() {
        LottoGenerator generator = new LottoGenerator();
        Lottos lottos = generator.createLottos(1);

        List<Lotto> generatedLottos = lottos.getLottos();

        for (Lotto lotto : generatedLottos) {
            assertThat(lotto.getNumbers().size()).isEqualTo(6);
        }
    }

    @Test
    @DisplayName("로또 번호가 범위 내에 있는지 테스트")
    void 로또_번호_범위_확인() {
        LottoGenerator generator = new LottoGenerator();
        Lottos lottos = generator.createLottos(1);

        List<Lotto> generatedLottos = lottos.getLottos();

        for (Lotto lotto : generatedLottos) {
            List<Integer> lottoNumbers = lotto.getNumbers().stream()
                    .map(LottoNumber::lottoNumber)
                    .collect(Collectors.toList());

            assertThat(lottoNumbers).allMatch(number -> number >= 1 && number <= 45);
        }
    }

}