package lotto.model.db;

import static lotto.constant.UserId.BUYER;
import static lotto.constant.UserId.OWNER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserRepositoryTest {

    @DisplayName("싱글톤 객체 확인")
    @Test
    void singleton() {
        // given
        UserRepository existingRepository = UserRepository.getInstance();
        // when
        UserRepository newRepository = UserRepository.getInstance();
        // then
        assertThat(existingRepository)
                .isNotNull()
                .isEqualTo(newRepository);
    }

    @DisplayName("Buyer 저장 및 조회")
    @Test
    void savedBuyer() {
        // given
        UserRepository repository = UserRepository.getInstance();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Buyer buyer = Buyer.from(lotto);
        // when
        repository.save(buyer);
        Buyer saved = (Buyer) repository.findById(BUYER);
        // then
        assertThat(saved)
                .isNotNull()
                .isInstanceOf(Buyer.class)
                .isEqualTo(buyer);
        assertThat(saved.getId())
                .isEqualTo(BUYER);
        assertThat(saved.getLotties().getFirst())
                .isEqualTo(lotto);
    }

    @DisplayName("Owner 저장 및 조회")
    @Test
    void savedOwner() {
        // given
        UserRepository repository = UserRepository.getInstance();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Owner owner = Owner.from(lotto, 7);
        // when
        repository.save(owner);
        Owner saved = (Owner) repository.findById(OWNER);
        // then
        assertThat(saved)
                .isNotNull()
                .isInstanceOf(Owner.class)
                .isEqualTo(owner);
        assertThat(saved.getId())
                .isEqualTo(OWNER);
        assertThat(saved.getWinningLotto())
                .isEqualTo(lotto);
        assertThat(saved.getBonus())
                .isEqualTo(7);
    }
}