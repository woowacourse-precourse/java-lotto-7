package lotto.entity;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConsumerTest {
    private static final String INPUT_COST_VALID = "5000\n"; // 유효한 금액 입력
    private static final String INPUT_COST_INVALID = "1500\n"; // 유효하지 않은 금액 입력
    private static final String INPUT_COST_ZERO = "0\n"; // 0원 입력
    private static final String INPUT_COST_NEGATIVE = "-1000\n"; // 음수 입력

    @BeforeEach
    void setUp() {
        // 콘솔 입력을 모킹하는 설정
    }

    @Test
    void 생성자는_유효한_구매금액을_입력받아야_티켓을_생성한다() {
        setInput(INPUT_COST_VALID); // 콘솔 입력을 모킹
        Consumer consumer = new Consumer(); // Consumer 생성

        assertThat(consumer.getLottoCount()).isEqualTo(5); // 5000원으로 5개 티켓 구매
        assertThat(consumer.getLottoTickets()).hasSize(5); // 5개의 티켓 생성 확인
    }

    @Test
    void 생성자는_0원보다_작거나_유효하지않은_금액을_입력받으면_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            setInput(INPUT_COST_ZERO);
            new Consumer();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구매 금액은 1,000원 단위여야 합니다.");

        assertThatThrownBy(() -> {
            setInput(INPUT_COST_INVALID);
            new Consumer();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구매 금액은 1,000원 단위여야 합니다.");

        assertThatThrownBy(() -> {
            setInput(INPUT_COST_NEGATIVE);
            new Consumer();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구매 금액은 1,000원 단위여야 합니다.");
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
