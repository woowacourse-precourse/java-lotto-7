package lotto.domain.model.lotto;

import lotto.domain.model.user.Lotto;
import lotto.domain.model.user.UserPurchasedLotto;
import lotto.domain.utils.TestLotto;
import lotto.domain.utils.TestUserPurchasedLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserPurchasedLottoTest {

    @Nested
    @DisplayName("getUserPurchasedLotto 메서드는")
    class GetUserPurchasedLotto {
        @Test
        @DisplayName("항상 불변 객체를 반환한다.")
        void getNumbersTest() {

            //given
            Lotto lotto1 = TestLotto.createTestLotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto lotto2 = TestLotto.createTestLotto(List.of(6, 5, 4, 3, 2, 1));
            UserPurchasedLotto userLotto1 = TestUserPurchasedLotto.create(List.of(lotto1));
            UserPurchasedLotto userLotto2 = TestUserPurchasedLotto.create(List.of(lotto2));

            //when
            //then
            List<Lotto> numbers1 = userLotto1.getUserPurchasedLotto();
            List<Lotto> numbers2 = userLotto2.getUserPurchasedLotto();
            Assertions.assertThatThrownBy(numbers1::removeFirst)
                    .isInstanceOf(UnsupportedOperationException.class);
            Assertions.assertThatThrownBy(numbers2::removeFirst)
                    .isInstanceOf(UnsupportedOperationException.class);
        }

    }
}