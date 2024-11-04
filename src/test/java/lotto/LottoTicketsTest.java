package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTicketsTest extends NsTest{
    @Test
    void getValidatedPurchaseAmount_형식에_맞는_입력() {
        LottoTickets lottoTickets = new LottoTickets();
        String input = "13000";

        int purchaseAmount = lottoTickets.getValidatedPurchaseAmount(input);

        assertThat(purchaseAmount).isEqualTo(13000);
    }
    @Test
    void getValidatedPurchaseAmount_정수로_변환할_수_없는_입력() {
        LottoTickets lottoTickets = new LottoTickets();
        String input = "abcd";

        assertThatThrownBy(() -> lottoTickets.getValidatedPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void getValidatedPurchaseAmount_양의_정수로_변환할_수_없는_입력() {
        LottoTickets lottoTickets = new LottoTickets();
        String input = "-100";

        assertThatThrownBy(() -> lottoTickets.getValidatedPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void getValidatedPurchaseAmount_1000으로_나누어_떨어지는_양의_정수로_변환할_수_없는_입력() {
        LottoTickets lottoTickets = new LottoTickets();
        String input = "1234";

        assertThatThrownBy(() -> lottoTickets.getValidatedPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validatePurchaseAmount_형식에_맞는_입력() {
        LottoTickets lottoTickets = new LottoTickets();
        String input = "24000";

        assertThatNoException().isThrownBy(() -> lottoTickets.validatePurchaseAmount(input));
    }
    @Test
    void validatePurchaseAmount_정수로_변환할_수_없는_입력() {
        LottoTickets lottoTickets = new LottoTickets();
        String input = "정수";

        assertThatThrownBy(() -> lottoTickets.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validatePurchaseAmount_양의_정수로_변환할_수_없는_입력() {
        LottoTickets lottoTickets = new LottoTickets();
        String input = "-2000";

        assertThatThrownBy(() -> lottoTickets.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validatePurchaseAmount_1000으로_나누어_떨어지는_양의_정수로_변환할_수_없는_입력() {
        LottoTickets lottoTickets = new LottoTickets();
        String input = "150";

        assertThatThrownBy(() -> lottoTickets.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateLottoTickets() {
        LottoTickets lottoTickets = new LottoTickets();
        int purchaseAmount = 23000;

        lottoTickets.generateLottoTickets(purchaseAmount);

        assertThat(lottoTickets.getList()).isNotNull();
        assertThat(lottoTickets.size()).isEqualTo(23);
    }

    @Test
    void calculateLottoCount() {
        LottoTickets lottoTickets = new LottoTickets();
        int purchaseAmount = 8000;

        int lottoCount = lottoTickets.calculateLottoCount(purchaseAmount);

        assertThat(lottoCount).isEqualTo(8);
    }

    @Test
    void getList() {
        LottoTickets lottoTickets = new LottoTickets();
        int purchaseAmount = 4000;

        lottoTickets.generateLottoTickets(purchaseAmount);

        assertThat(lottoTickets.getList()).isNotNull();
        assertThat(lottoTickets.getList().size()).isEqualTo(4);
    }

    @Test
    void size() {
        LottoTickets lottoTickets = new LottoTickets();
        int purchaseAmount = 11000;

        lottoTickets.generateLottoTickets(purchaseAmount);
        int size = lottoTickets.size();

        assertThat(size).isEqualTo(11);
    }

    @Override
    protected void runMain() {

    }
}