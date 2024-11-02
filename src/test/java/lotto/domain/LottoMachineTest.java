package lotto.domain;

import static lotto.domain.LottoConstants.COUNT_OF_LOTTO_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {
    @DisplayName("Lotto 인스턴스를 1개 생성한다.")
    @Test
    void createALotto() {
        LottoMachine lottoMachine = LottoMachineFixture.createLottoMachine();

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
        LottoMachine lottoMachine = LottoMachineFixture.createLottoMachine();

        List<Lotto> actual = lottoMachine.createLottos(quantity);

        assertThat(actual)
                .isNotNull()
                .hasSize(quantity);
        assertThatCode(() -> lottoMachine.createLottos(quantity))
                .doesNotThrowAnyException();
    }

    @DisplayName("주어진 로또 번호를 가진 Lotto 인스턴스 1개로 구성된 리스트를 생성한다.")
    @Test
    void createListConsistingOfALottoThatHasGivenNumbers() {
        LottoMachine lottoMachine = LottoMachineFixture.createLottoMachine();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Lotto> actual = lottoMachine.createLotto(numbers);

        assertThat(actual)
                .isNotNull()
                .hasSize(1);
        assertThatCode(() -> lottoMachine.createLotto(numbers))
                .doesNotThrowAnyException();
    }
}