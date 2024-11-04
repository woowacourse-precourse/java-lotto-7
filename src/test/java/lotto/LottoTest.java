package lotto;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {

    private List<Integer> validNumbers;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        validNumbers = Arrays.asList(3, 7, 12, 19, 25, 32);
        winningNumbers = Arrays.asList(3, 7, 12, 25, 30, 32);
        bonusNumber = 19;
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 로또_번호에_1과_45사이가_아닌_값이_있으면_예외가_발생한다(){
        assertThatThrownBy(() -> new Lotto(List.of(46, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_랜덤_발행_시_1과_45사이의_6개의_수가_발행된다(){
        Lotto randomLotto = Lotto.makeRandomLotto();
        List<Integer> numbers = randomLotto.getNumbers();
        assertEquals(Lotto.LOTTO_SIZE, numbers.size(), "6개의 수를 갖고 있다.");
        assertTrue(numbers.stream().allMatch(num -> num >= Lotto.LOTTO_MIN_NUM && num <= Lotto.LOTTO_MAX_NUM),
                "1과 45 사이의 값으로 구성되어 있다.");
    }

    @Test
    void 당첨_번호와_발행_로또_번호_사이의_일치된_개수를_확인_가능하다(){
        int matchCount = Lotto.checkLotto(validNumbers, winningNumbers, bonusNumber);
        assertEquals(3, matchCount, "보너스 번호 제외 3개의 수가 일치한다.");
    }

    @Test
    void 이등인_경우_보너스_번호와_관련이_있다() {
        List<Integer> userNumbers = Arrays.asList(3, 7, 12, 19, 25, 32);
        int prize = Lotto.checkLotto(userNumbers, winningNumbers, bonusNumber);
        assertEquals(3, prize, "5개 수 일치, 보너스 번호 일치");
    }

    @Test
    void 삼등인_경우_보너스_번호와_관련이_있다() {
        List<Integer> userNumbers = Arrays.asList(3, 7, 12, 25, 32, 40);
        int prize = Lotto.checkLotto(userNumbers, winningNumbers, bonusNumber);
        assertEquals(2, prize, "5개 수 일치, 보너스 번호 불일치");
    }

    @Test
    void 보너스_번호_포함_등수_규칙_매칭_번호에_맞게_출력된다() {
        assertEquals(4, Lotto.getPrizeForMatchCount(6, false), "6개 일치");
        assertEquals(3, Lotto.getPrizeForMatchCount(5, true), "5개 일치, 보너스 볼 일치");
        assertEquals(2, Lotto.getPrizeForMatchCount(5, false), "5개 일치");
        assertEquals(1, Lotto.getPrizeForMatchCount(4, false), "4개 일치");
        assertEquals(0, Lotto.getPrizeForMatchCount(3, false), "3개 일치");
        assertEquals(-1, Lotto.getPrizeForMatchCount(2, false), "3개 미만 일치");
    }

}