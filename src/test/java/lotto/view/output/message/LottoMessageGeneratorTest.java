package lotto.view.output.message;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class LottoMessageGeneratorTest {

    LottoMessageGenerator lottoMessageGenerator = new LottoMessageGenerator();

    @Test
    void 로또_수량에_대한_메세지를_생성할_수_있다() {
        // given
        int quantity = 3;

        // when
        String message = lottoMessageGenerator.getPurchaseQuantityMessage(quantity);

        // then
        assertThat(message).isEqualTo("3개를 구매했습니다.");
    }

    @Test
    void 번호를_오름차순으로_정렬한_메세지를_생성할_수_있다() {
        // given
        Lotto lotto = Lotto.of(List.of(4, 5, 6, 1, 2, 3));

        // when
        String message = lottoMessageGenerator.getSortedNumbersMessage(lotto);

        // then
        assertThat(message).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

}
