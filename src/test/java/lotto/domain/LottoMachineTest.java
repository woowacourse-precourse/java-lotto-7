package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 50, 100})
    void 올바르지_않은_구입금액_테스트(int money) {
        LottoMachine lottoMachine = new LottoMachine(new CustomLottoGenerator());

        // when & then
        Assertions.assertThatThrownBy(() -> {
                    lottoMachine.generateLottos(money).size();
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 올바른 로또 구입금액이 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "3000:3"}, delimiter = ':')
    void 금액에_따른_로또_생성_개수_테스트(int money, int expected) {
        LottoMachine lottoMachine = new LottoMachine(new CustomLottoGenerator());

        // when
        int actual = lottoMachine.generateLottos(money).size();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}