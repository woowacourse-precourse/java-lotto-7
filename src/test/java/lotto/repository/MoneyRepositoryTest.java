package lotto.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import lotto.domain.Money;
import lotto.repository.impl.MoneyRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyRepositoryTest {

    private final MoneyRepository moneyRepository = new MoneyRepository();

    @Test
    @DisplayName("save && get 테스트")
    void test1() {
        // given
        Money expect = Money.create("1000");
        moneyRepository.save(expect);

        // when
        Money result = moneyRepository.get().orElseThrow(NullPointerException::new);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("예외 : 저장 없이 GET")
    void test2() {
        // given
        // when
        Optional<Money> result = moneyRepository.get();

        // then
        assertThat(result).isEmpty();
    }
}
