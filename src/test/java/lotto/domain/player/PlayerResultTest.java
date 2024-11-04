package lotto.domain.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerResultTest {

    private PlayerResult playerResult;

    @Test
    @DisplayName("1등 당첨 개수를 증가시킬 수 있다.")
    void 당첨_1등_테스트() throws Exception{
        // given
        playerResult = new PlayerResult();

        // when
        playerResult.increaseFirstPlace();

        // then
        assertEquals(1, playerResult.getFirstPlace());
    }

    @Test
    @DisplayName("2등 당첨 개수를 증가시킬 수 있다.")
    void 당첨_2등_테스트() throws Exception{
        // given
        playerResult = new PlayerResult();

        // when
        playerResult.increaseSecondPlace();

        // then
        assertEquals(1, playerResult.getSecondPlace());
    }

    @Test
    @DisplayName("3등 당첨 개수를 증가시킬 수 있다.")
    void 당첨_3등_테스트() throws Exception{
        // given
        playerResult = new PlayerResult();

        // when
        playerResult.increaseThirdPlace();

        // then
        assertEquals(1, playerResult.getThirdPlace());
    }

    @Test
    @DisplayName("4등 당첨 개수를 증가시킬 수 있다.")
    void 당첨_4등_테스트() throws Exception{
        // given
        playerResult = new PlayerResult();

        // when
        playerResult.increaseFourthPlace();

        // then
        assertEquals(1, playerResult.getFourthPlace());
    }

    @Test
    @DisplayName("5등 당첨 개수를 증가시킬 수 있다.")
    void 당첨_5등_테스트() throws Exception{
        // given
        playerResult = new PlayerResult();

        // when
        playerResult.increaseFifthPlace();

        // then
        assertEquals(1, playerResult.getFifthPlace());
    }

    @Test
    @DisplayName("총 수익을 수정할 수 있다.")
    void 수익_수정_테스트() throws Exception{
        // given
        playerResult = new PlayerResult();
        int profit = 500000;

        // when
        playerResult.updateProfit(profit);

        // then
        assertEquals(profit, playerResult.getProfit());
    }

    @Test
    @DisplayName("수익률을 수정할 수 있다.")
    void 수익률_수정_테스트() throws Exception{
        // given
        playerResult = new PlayerResult();
        float profitRate = 500.0f;

        // when
        playerResult.updateProfitRate(profitRate);

        // then
        assertEquals(profitRate, playerResult.getProfitRate());
    }
}
