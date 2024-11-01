package lotto;

import static lotto.LottoConstants.COUNT_OF_LOTTO_NUMBERS;
import static lotto.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.LottoConstants.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {
    private final LottoNumberGenerator lottoNumberGenerator
            = new LottoNumberGenerator(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_OF_LOTTO_NUMBERS);
    private final LottoMachine lottoMachine
            = new LottoMachine(lottoNumberGenerator);

    @DisplayName("Lotto 인스턴스를 1개 생성한다.")
    @Test
    void createALotto() {
        Object actual = lottoMachine.createLotto();

        assertThat(actual)
                .isInstanceOf(Lotto.class)
                .isNotNull()
                .hasNoNullFieldsOrProperties();
        assertThatCode(lottoMachine::createLotto)
                .doesNotThrowAnyException();
    }

    @DisplayName("Lotto 인스턴스를 주어진 개수만큼 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {COUNT_OF_LOTTO_NUMBERS, 0, 1, 10, 100, 950000})
    void createGivenQuantityOfLottos(int quantity) {
        List<Lotto> actual = lottoMachine.createLottos(quantity);

        assertThat(actual)
                .isNotNull()
                .hasSize(quantity);
        assertThatCode(() -> lottoMachine.createLottos(quantity))
                .doesNotThrowAnyException();
    }
}