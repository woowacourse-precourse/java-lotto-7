package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.HashSet;

public class LottoPurchaserTest {

    private LottoPurchaser lottoPurchaser;

    @BeforeEach
    void setup() {
        lottoPurchaser = new LottoPurchaser("5000");
    }

    @Test
    @DisplayName("구입한 로또의 개수가 올바른지 확인")
    void purchaseLotto() {
        List<List<Integer>> purchasedLottos = lottoPurchaser.purchaseLotto();
        assertThat(purchasedLottos.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("구입한 로또 번호의 개수와 범위 및 중복을 확인")
    void generateLotto() {
        List<List<Integer>> purchaseLottos = lottoPurchaser.purchaseLotto();
        for (List<Integer> purchasedLotto : purchaseLottos) {
            assertThat(purchasedLotto).hasSize(6);
            assertThat(new HashSet<>(purchasedLotto).size()).isEqualTo(6);
            assertThat(purchasedLotto).allMatch(num -> num >= 1 && num <= 45);
        }
    }
}
