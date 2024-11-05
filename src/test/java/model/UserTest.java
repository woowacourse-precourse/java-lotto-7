package model;

import lotto.model.User;
import lotto.model.enums.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void addLotto_ShouldAddLottoNumbers() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        user.addLotto(lottoNumbers);

        // then
        List<List<Integer>> lottos = user.getLottos();
        assertThat(lottos).containsExactly(lottoNumbers);
    }

    @Test
    void addResult_ShouldIncreaseResultCount() {
        // given
        Prize prize = Prize.FIFTH_PRIZE;

        // when
        user.addResult(prize);

        // then
        Map<Prize, Integer> results = user.getResults();
        assertThat(results.get(prize)).isEqualTo(1);
    }

    @Test
    void getResults_ShouldReturnInitialResults() {
        // when
        Map<Prize, Integer> results = user.getResults();

        // then
        for (Prize prize : Prize.values()) {
            assertThat(results.get(prize)).isEqualTo(0);
        }
    }

    @Test
    void addResult_ShouldNotAcceptNullPrize() {
        // when
        user.addResult(null); // No exception should be thrown

        // then
        // Assert that the count for any prize remains 0
        Map<Prize, Integer> results = user.getResults();
        for (Prize prize : Prize.values()) {
            assertThat(results.get(prize)).isEqualTo(0);
        }
    }
}