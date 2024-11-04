package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void User에_String값_넣으면_int값으로_정상반환() {
        User user = new User("3000");
        int buyingPrice = user.getBuyingPrice();
        assertThat(buyingPrice).isEqualTo(3000);
    }

    @Test
    void 천원단위_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new User("2500"))
                .isInstanceOf(IllegalArgumentException.class);


    }

}
