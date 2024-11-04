package lotto.purchase.infrastructure;

import lotto.purchase.domain.Money;
import lotto.purchase.domain.Purchase;
import lotto.purchase.service.port.PurchaseRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseRepositoryImplTest {

    private PurchaseRepository repository;
    private Purchase purchase;

    @BeforeEach
    void setUp() {
        repository = PurchaseRepositoryImpl.getInstance();
        purchase = Purchase.of("LottoId", Money.of(1000));
    }

    @Test
    @DisplayName("repository에 Purchase 객체를 저장하고 찾는다.")
    void repositorySaveTest() {
        // given
        String id = purchase.getId();

        // when
        repository.save(id, purchase);

        // then
        Assertions.assertThat(repository.findById(id)).isEqualTo(purchase);
    }

    @Test
    @DisplayName("저장되어있지 않은 객체를 찾으려고 시도하면 IllegalArgumentException을 던진다")
    void repositoryNotFoundExceptionTest() {
        // given
        String id = purchase.getId();

        // when-then
        Assertions.assertThatThrownBy(() -> repository.findById(id)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("저장 시 null인 id로 시도하면 IllegalArgumentException을 던진다")
    void repositoryNullIdSaveExceptionTest() {
        // given
        String id = null;

        // when-then
        Assertions.assertThatThrownBy(() -> repository.save(id, purchase)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("저장 시 null인 객체로 시도하면 IllegalArgumentException을 던진다")
    void repositoryNullValueSaveExceptionTest() {
        // given
        String id = purchase.getId();
        Purchase purchase = null;

        // when-then
        Assertions.assertThatThrownBy(() -> repository.save(id, purchase)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("객체를 찾을 때 null인 id로 시도하면 IllegalArgumentException을 던진다.")
    void repositoryNullIdFindExceptionTest() {
        // given
        String id = null;

        // when-then
        Assertions.assertThatThrownBy(() -> repository.findById(id)).isInstanceOf(IllegalArgumentException.class);
    }
}
