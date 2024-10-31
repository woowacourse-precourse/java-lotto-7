package lotto.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsumerTest {
    @Test
    public void shouldCreateConsumerWithValidInput() {
        // Given
        String input = "5000\n"; // 가상의 입력을 설정합니다.
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        // When
        Consumer consumer = new Consumer();

        // Then
        assertThat(consumer.getTotalLottoCost()).isEqualTo(5000);
        assertThat(consumer.getLottoCount()).isEqualTo(5);
        assertThat(consumer.getLottoTickets().size()).isEqualTo(5);
    }

    @Test
    public void shouldThrowExceptionForInvalidCost() {
        // Given
        String input = "1500\n"; // 1000원 단위가 아님
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        // When & Then
        IllegalArgumentException thrown = org.junit.jupiter.api.Assertions.assertThrows(
                IllegalArgumentException.class,
                Consumer::new
        );
        assertThat(thrown.getMessage()).isEqualTo("[ERROR] 로또 구매 금액은 1,000원 단위여야 합니다.");
    }
}
