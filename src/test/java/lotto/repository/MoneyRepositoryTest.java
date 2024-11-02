package lotto.repository;

import static org.assertj.core.api.Assertions.assertThat;

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
        Money result = moneyRepository.get().orElseThrow(EntityNotFoundException::new);

        assertThat(result).isEqualTo(expect);
    }
}
