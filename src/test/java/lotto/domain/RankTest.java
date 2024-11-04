package lotto.domain;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @BeforeEach
    void resetCounts() throws Exception {
        // Rank Enum의 count 필드를 초기화
        for (Rank rank : Rank.values()) {
            Field countField = Rank.class.getDeclaredField("count");
            countField.setAccessible(true);
            countField.setInt(rank, 0);
        }
    }

    @Test
    void 등수별_카운트_증가() {
        Rank.FIRST.increaseCount();
        Rank.FIRST.increaseCount();
        assertThat(Rank.FIRST.getCount()).isEqualTo(2);

        Rank.SECOND.increaseCount();
        assertThat(Rank.SECOND.getCount()).isEqualTo(1);
    }

    @Test
    void 출력_형식_확인() {
        Rank.FIRST.increaseCount();
        Rank.SECOND.increaseCount();
        Rank.THIRD.increaseCount();

        assertThat(Rank.FIRST.toString()).isEqualTo("6개 일치 (2,000,000,000원) - 1개");
        assertThat(Rank.SECOND.toString()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
        assertThat(Rank.THIRD.toString()).isEqualTo("5개 일치 (1,500,000원) - 1개");
    }
}
