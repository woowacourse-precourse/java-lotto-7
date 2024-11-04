package lotto.controller;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

class LottoControllerTest {

    @Test
    @DisplayName("로또 번호가 정상적으로 생성되는지 테스트")
    void 로또_번호_정상_생성_테스트() {
        LottoController lottoController = new LottoController();
        int inputCount = 5;
        List<Lotto> lottos = lottoController.generateLottos(inputCount);

        assertThat(lottos).hasSize(inputCount);
        for (Lotto lotto : lottos) {
            assertThat(lotto.toDTO().getNumbers()).hasSize(6);
            assertThat(lotto.toDTO().getNumbers())
                    .allMatch(num -> num >= 1 && num <= 45);
            assertThat(lotto.toDTO().getNumbers()).doesNotHaveDuplicates();
        }
    }

    @Test
    @DisplayName("사용자 입력만큼 로또가 생성되는지 테스트")
    void 로또_개수_입력에_따른_생성_테스트() {
        LottoController lottoController = new LottoController();
        int inputCount = 10;
        List<Lotto> lottos = lottoController.generateLottos(inputCount);

        assertThat(lottos).hasSize(inputCount);
    }
}
