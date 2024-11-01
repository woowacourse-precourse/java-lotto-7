package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        int purchaseAmount = 2024;

        assertThatThrownBy(() -> new User(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입한_로또의_개수는_구입_금액에서_1000을_나눈_값이다() {
        int purchaseAmount = 8000;

        User user = new User(purchaseAmount);

        assertThat(user.getLottos().size()).isEqualTo(purchaseAmount / 1000);
    }

    @Test
    void 당첨_번호를_확인하지_않은_상태에서_당첨_통계를_확인하면_예외가_발생한다() {
        int purchaseAmount = 1000;
        User user = new User(purchaseAmount);

        assertThatThrownBy(user::getPrizes)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 수익률을_계산_확인() {
        int purchaseAmount = 8000;
        User user = new User(purchaseAmount);
        user.setPrize(Prize.FIFTH);
        user.setPrize(Prize.SECOND);

        double returnRate = user.getReturnRate();

        assertThat(returnRate).isEqualTo(0375062.5);
    }
}
