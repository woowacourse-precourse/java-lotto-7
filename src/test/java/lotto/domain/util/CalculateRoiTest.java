package lotto.domain.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateRoiTest {

    @Test
    @DisplayName("적은 수익률을 계산한다.")
    void calculateTest1() {
        long totalAmount = 5000;
        int userAmount = 8000;

        String roi = CalculateRoi.calculate(totalAmount, userAmount);

        assertThat(roi).isEqualTo("62.5");
    }

    @Test
    @DisplayName("큰 수익률을 계산한다.")
    void calculateTest2() {
        long totalAmount = 2_000_000_000L;
        int userAmount = 8000;

        String roi = CalculateRoi.calculate(totalAmount, userAmount);

        assertThat(roi).isEqualTo("25000000.0");
    }
}