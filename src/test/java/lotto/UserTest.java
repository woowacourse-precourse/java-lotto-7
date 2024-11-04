package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void 로또_구입_금액은_1000으로_나누어_떨어져야_한다() {
        assertDoesNotThrow(() -> new User("2000"));
    }

    @Test
    void 로또_구입_금액이_1000원으로_나누어_떨어지지_않으면_에러() {
        assertThatThrownBy(() ->
                new User("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_금액은_숫자만_입력받을_수_있다() {
        assertDoesNotThrow(() -> new User("14000"));
    }

    @Test
    void 로또_구입_금액이_숫자가_아니면_에러() {
        assertThatThrownBy(() ->
                new User("1000i"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_금액으로_로또_개수를_계산한다() {
        User user = new User("14000");
        assertThat(user.getLottoCount()).isEqualTo(14);
    }

    @Test
    void 로또_개수만큼_로또를_발행받는다() {
        User user = new User("8000");
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
        user.buyLotto(randomNumbersGenerator);
        assertThat(user.getLottos().size()).isEqualTo(user.getLottoCount());
    }

    @Test
    void 당첨_결과와_수익률을_계산한다() {
        User user = new User("2000");
        TestNumbersGenerator testNumbersGenerator = new TestNumbersGenerator(List.of(1,2,3,4,5,6,5,6,7,8,9,10));
        user.buyLotto(testNumbersGenerator);
        LottoMachine lottoMachine = new LottoMachine(new Lotto(List.of(5,6,7,11,12,13)), "15");
        user.calculateFinalPrice(lottoMachine);

        assertThat(user.getReturns()).isEqualTo(250);
    }
}