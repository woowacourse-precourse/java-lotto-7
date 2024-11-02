package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoBuyServiceTest {

    private LottoBuyService lottoBuyService;

    @BeforeEach
    void setUp() {
        lottoBuyService = new LottoBuyService();
    }

    @DisplayName("로또 구입 금액만큼 로또를 발행한다.")
    @Test
    void buyLotto() {
        // given
        String purchaseAmount = "10000";

        // when
        Lottos lottos = lottoBuyService.buyLotto(purchaseAmount);

        // then
        assertThat(lottos.getLottos().size()).isEqualTo(10);
    }

    @RepeatedTest(100)
    @DisplayName("1개의 로또를 발행할 때 1~45 사이의 6개의 숫자를 랜덤으로 생성해서 발행한다")
    void selectLottoNumbers() {
        // given
        int START_NUMBER = 1;
        int END_NUMBER = 45;
        int NUMBER_COUNT = 6;

        // when
        Lotto lotto = lottoBuyService.selectLottoNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();

        // then
        assertThat(lottoNumbers)
                .hasSize(NUMBER_COUNT)
                .allMatch(number -> number >= START_NUMBER && number <= END_NUMBER)
                .doesNotHaveDuplicates();
    }
}