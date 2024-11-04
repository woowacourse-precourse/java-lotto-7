package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

class PlayerTest {
    private Player player;
    private int purchaseAmount;
    private final List<Lotto> lottoBatch = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 6 matches
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),  // 5 matches + bonus
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)),  // 5 matches
            new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), // 4 matches
            new Lotto(Arrays.asList(1, 2, 3, 10, 11, 13)) // 3 matches
    );

    @BeforeEach
    void setUp() {
        purchaseAmount = 5000;
        player = new Player(purchaseAmount, lottoBatch);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    public void getProfitRate() {
        //given
        int totalPrize = 1500000;
        double expectedProfitRate = BigDecimal.valueOf((double) totalPrize / purchaseAmount * 100)
                .setScale(2, RoundingMode.HALF_UP).doubleValue();

        //when
        double actualProfitRate = player.getProfitRate(totalPrize);

        //then
        Assertions.assertThat(actualProfitRate).isEqualTo(expectedProfitRate);
    }
}
