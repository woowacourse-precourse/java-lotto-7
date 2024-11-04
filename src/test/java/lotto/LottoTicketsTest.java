package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTicketsTest{
    @Test
    void getValidatedPurchaseAmount_형식에_맞는_입력() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        String input = "13000";

        // when
        int purchaseAmount = lottoTickets.getValidatedPurchaseAmount(input);

        // then
        assertThat(purchaseAmount).isEqualTo(13000);
    }
    @Test
    void getValidatedPurchaseAmount_정수로_변환할_수_없는_입력() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        String input = "abcd";

        // then
        assertThatThrownBy(() -> lottoTickets.getValidatedPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void getValidatedPurchaseAmount_양의_정수로_변환할_수_없는_입력() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        String input = "-100";

        // then
        assertThatThrownBy(() -> lottoTickets.getValidatedPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void getValidatedPurchaseAmount_1000으로_나누어_떨어지는_양의_정수로_변환할_수_없는_입력() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        String input = "1234";

        // then
        assertThatThrownBy(() -> lottoTickets.getValidatedPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validatePurchaseAmount_형식에_맞는_입력() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        String input = "24000";

        // then
        assertThatNoException().isThrownBy(() -> lottoTickets.validatePurchaseAmount(input));
    }
    @Test
    void validatePurchaseAmount_정수로_변환할_수_없는_입력() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        String input = "정수";

        // then
        assertThatThrownBy(() -> lottoTickets.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validatePurchaseAmount_양의_정수로_변환할_수_없는_입력() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        String input = "-2000";

        // then
        assertThatThrownBy(() -> lottoTickets.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validatePurchaseAmount_1000으로_나누어_떨어지는_양의_정수로_변환할_수_없는_입력() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        String input = "150";

        // then
        assertThatThrownBy(() -> lottoTickets.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateLottoTickets() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        int purchaseAmount = 23000;

        // when
        lottoTickets.generateLottoTickets(purchaseAmount);

        // then
        assertThat(lottoTickets.getList()).isNotNull();
        assertThat(lottoTickets.size()).isEqualTo(23);
    }

    @Test
    void calculateLottoCount() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        int purchaseAmount = 8000;

        // when
        int lottoCount = lottoTickets.calculateLottoCount(purchaseAmount);

        // then
        assertThat(lottoCount).isEqualTo(8);
    }

    @Test
    void getList() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        int purchaseAmount = 4000;

        lottoTickets.generateLottoTickets(purchaseAmount);

        // then
        assertThat(lottoTickets.getList()).isNotNull();
        assertThat(lottoTickets.getList().size()).isEqualTo(4);
    }

    @Test
    void size() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        int purchaseAmount = 11000;

        lottoTickets.generateLottoTickets(purchaseAmount);

        // when
        int size = lottoTickets.size();

        // then
        assertThat(size).isEqualTo(11);
    }
}