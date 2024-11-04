package lotto.domain;

import static lotto.constant.ExceptionMessage.INSUFFICIENT_BALANCE;
import static lotto.constant.ExceptionMessage.INVALID_PAYMENT_AMOUNT;
import static lotto.constant.ExceptionMessage.MINIMUM_PURCHASE_AMOUNT_REQUIRED;
import static lotto.constant.LottoConstants.SINGLE_TICKET_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import lotto.vo.Money;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPaymentTest {

    @Nested
    class 로또_결제_생성_테스트 {
        @Test
        void 티켓_가격의_배수로_결제를_생성한다() {
            // given
            Money amount = Money.from(5000);

            // when
            LottoPayment payment = LottoPayment.from(amount);

            // then
            assertThat(payment.getInitialAmount()).isEqualTo(amount);
        }

        @ParameterizedTest
        @ValueSource(longs = {1500L, 2200L, 999L, 1001L})
        void 티켓_가격의_배수가_아닌_금액으로_결제를_생성할_수_없다(long amount) {
            assertThatThrownBy(() -> LottoPayment.from(Money.from(amount)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_PAYMENT_AMOUNT.format(SINGLE_TICKET_PRICE.getValue()));
        }

        @Test
        void 결제_금액이_0원이면_예외가_발생한다() {
            // given
            Money amount = Money.from(0);

            // when & then
            assertThatThrownBy(() -> LottoPayment.from(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(MINIMUM_PURCHASE_AMOUNT_REQUIRED.message());
        }
    }

    @Nested
    class 단일_티켓_차감_테스트 {
        @Test
        void 단일_티켓_금액을_차감한다() {
            // given
            LottoPayment payment = LottoPayment.from(Money.from(2000));

            // when
            payment.deductSingleTicket();

            // then
            assertThat(payment.hasSufficientAmount()).isTrue();
        }

        @Test
        void 잔액이_부족하면_티켓을_차감할_수_없다() {
            // given
            LottoPayment payment = LottoPayment.from(Money.from(1000));
            payment.deductSingleTicket();  // 잔액 0원

            // when & then
            assertThatThrownBy(payment::deductSingleTicket)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INSUFFICIENT_BALANCE.message());
        }

        @Test
        void 정확히_티켓_가격만큼_남았을_때_차감이_가능하다() {
            // given
            LottoPayment payment = LottoPayment.from(Money.from(1000));

            // when & then
            assertSoftly(softly -> {
                softly.assertThat(payment.hasSufficientAmount()).isTrue();
                payment.deductSingleTicket();
                softly.assertThat(payment.hasSufficientAmount()).isFalse();
            });
        }
    }

    @Nested
    class 잔액_확인_테스트 {
        @Test
        void 티켓_구매_가능_여부를_확인한다() {
            // given
            LottoPayment payment = LottoPayment.from(Money.from(2000));

            // when & then
            assertSoftly(softly -> {
                softly.assertThat(payment.hasSufficientAmount()).isTrue();
                payment.deductSingleTicket();
                softly.assertThat(payment.hasSufficientAmount()).isTrue();
                payment.deductSingleTicket();
                softly.assertThat(payment.hasSufficientAmount()).isFalse();
            });
        }

        @Test
        void 초기_금액은_변경되지_않는다() {
            // given
            Money initialAmount = Money.from(3000);
            LottoPayment payment = LottoPayment.from(initialAmount);

            // when
            payment.deductSingleTicket();
            payment.deductSingleTicket();

            // then
            assertThat(payment.getInitialAmount()).isEqualTo(initialAmount);
        }
    }

    @Test
    void 연속적인_티켓_구매를_처리한다() {
        // given
        LottoPayment payment = LottoPayment.from(Money.from(5000));

        // when & then
        assertSoftly(softly -> {
            // 5000원
            softly.assertThat(payment.hasSufficientAmount()).isTrue();

            // 4000원
            payment.deductSingleTicket();
            softly.assertThat(payment.hasSufficientAmount()).isTrue();

            // 3000원
            payment.deductSingleTicket();
            softly.assertThat(payment.hasSufficientAmount()).isTrue();

            // 2000원
            payment.deductSingleTicket();
            softly.assertThat(payment.hasSufficientAmount()).isTrue();

            // 1000원
            payment.deductSingleTicket();
            softly.assertThat(payment.hasSufficientAmount()).isTrue();

            // 0원
            payment.deductSingleTicket();
            softly.assertThat(payment.hasSufficientAmount()).isFalse();
        });
    }
}
