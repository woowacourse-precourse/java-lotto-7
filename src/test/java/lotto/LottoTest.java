package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private static List<Lotto> lottos = new ArrayList<>();
    private static List<Integer> winningNumbers = new ArrayList<>();
    private static int[] matchCount = new int[8];
    private static int bonusNumber;
    private static int pieces = 8;
    private static int revenue;
    private static int credit;
    private static double revenueRate;


    @BeforeEach
    void setup() {
        lottos.clear();
        winningNumbers = new ArrayList<>();
    }

    private void publishLotto() {
        for (int i = 0; i < pieces; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public static void getWinningNumbers(String input) {
        String[] winningNumbersString = input.split(",");
        for(String number : winningNumbersString) {
            winningNumbers.add(Integer.parseInt(number));
        }
    }

    public static void matchTest(Lotto lotto) {
        List<Integer> intersection = new ArrayList<>(winningNumbers);
        intersection.retainAll(lotto.getNumbers());
        if( intersection.size() == 5 && bonusMatchTest(lotto)) {
            matchCount[7]++;
        }
        matchCount[intersection.size()]++;
    }

    public static boolean bonusMatchTest(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public static void calculateRevenueRate() {
        revenueRate = Math.round((double) revenue / credit * 100 * 100) / 100.0;
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개가_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    @DisplayName("로또 번호 발행 테스트")
    void testPublishLotto() {
        publishLotto();
        assertEquals(pieces, lottos.size());
    }

    @Test
    @DisplayName("당첨 번호가 정상적으로 받아졌는지 테스트")
    void testGetWinningNumbers() {
        String input = "1,2,3,4,5,6";
        winningNumbers.clear();
        getWinningNumbers(input);
        assertThat(winningNumbers).contains(1,2,3,4,5,6);
    }

    @Test
    @DisplayName("일치하는 번호 개수 테스트")
    void testMatchTest() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        winningNumbers = List.of(1,2,3,4,5,6);
        matchTest(lotto);
        assertThat(matchCount[6]).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 번호 + 보너스 번호 일치 테스트")
    void test2nd() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        winningNumbers = List.of(1,2,3,4,5,7);
        bonusNumber = 6;
        matchTest(lotto);
        assertThat(matchCount[7]).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 테스트")
    void testRevenueRate() {
        revenue = 5000;
        credit = 8000;
        calculateRevenueRate();
        assertThat(revenueRate).isEqualTo(62.5);
    }
}
