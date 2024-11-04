package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("로또 구입 금액이 숫자가 아닐 경우 예외가 발생한다")
    void validateNonNumericAmount() {
        assertThatThrownBy(() -> lottoMachine.parseAndValidateAmount("1000won"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "0"})
    @DisplayName("로또 구입 금액이 0 이하일 경우 예외가 발생한다")
    void validateNegativeAmount(String input) {
        assertThatThrownBy(() -> lottoMachine.parseAndValidateAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액은 0보다 커야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1500", "2200"})
    @DisplayName("로또 구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다")
    void validateNonThousandAmount(String input) {
        assertThatThrownBy(() -> lottoMachine.parseAndValidateAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("올바른 금액을 입력하면 정상적으로 처리된다")
    void validateValidAmount() {
        int amount = lottoMachine.parseAndValidateAmount("2000");
        assertThat(amount).isEqualTo(2000);
    }

    @Test
    @DisplayName("로또 티켓이 요청한 수만큼 생성된다")
    void generateCorrectNumberOfTickets() {
        List<Lotto> tickets = lottoMachine.generateTickets(3);
        assertThat(tickets).hasSize(3);
    }

    @Test
    @DisplayName("생성된 각 로또 번호는 6개여야 한다")
    void generatedLottoShouldHaveSixNumbers() {
        List<Lotto> tickets = lottoMachine.generateTickets(1);
        assertThat(tickets.get(0).getNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("생성된 로또 번호는 정렬되어 있어야 한다")
    void generatedLottoShouldBeSorted() {
        List<Lotto> tickets = lottoMachine.generateTickets(1);
        List<Integer> numbers = tickets.get(0).getNumbers();
        assertThat(numbers).isSorted();
    }

    @Test
    @DisplayName("생성된 로또 번호는 1부터 45 사이의 숫자여야 한다")
    void generatedLottoNumbersShouldBeInRange() {
        List<Lotto> tickets = lottoMachine.generateTickets(1);
        List<Integer> numbers = tickets.get(0).getNumbers();
        assertThat(numbers).allMatch(n -> n >= 1 && n <= 45);
    }

}