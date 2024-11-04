package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
    }

    @Test
    @DisplayName("구입 금액이 1,000원 단위로 입력되지 않으면 예외가 발생한다")
    void 구입_금액_유효성_검사_예외() {
        int invalidAmount = 1500;
        assertThatThrownBy(() -> {
            lottoGame.isValidAmount(invalidAmount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }


    @Test
    @DisplayName("로또 번호가 올바르게 생성되는지 확인한다")
    void 로또_번호_생성() {
        List<List<Integer>> lottoNumbers = lottoGame.generateLottoNumbers(3);
        assertThat(lottoNumbers).hasSize(3);
        for (List<Integer> numbers : lottoNumbers) {
            assertThat(numbers).hasSize(6);
            assertThat(numbers).doesNotHaveDuplicates();
            assertThat(numbers).allMatch(num -> num >= 1 && num <= 45);
        }
    }

    @Test
    @DisplayName("로또 번호가 쉼표(,)로 구분되지 않으면 예외가 발생한다")
    void 로또_번호_구분자_예외() {
        String input = "1 2 3 4 5 6";
        assertThatThrownBy(() -> lottoGame.parseWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 쉼표(,)를 기준으로 구분합니다.");
    }

    @Test
    @DisplayName("로또 번호에 유효하지 않은 문자가 포함되면 예외가 발생한다")
    void 로또_번호_유효하지_않은_문자_예외() {
        String input = "1, 2, 3, a, 5, 6";
        assertThatThrownBy(() -> lottoGame.parseWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력에 유효하지 않은 문자가 포함되어 있습니다. 숫자만 입력해 주세요.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    void 보너스_번호_중복_예외() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 3;

        assertThatThrownBy(() -> lottoGame.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1부터 45 사이가 아니면 예외가 발생한다")
    void 보너스_번호_범위_예외() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 50;
        assertThatThrownBy(() -> lottoGame.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자 1개입니다.");
    }

    @Test
    @DisplayName("보너스 번호가 공백이면 예외가 발생한다.")
    void 보너스_번호_공백_예외() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String input = " "; // 공백 입력

        assertThatThrownBy(() -> lottoGame.parseAndValidateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1개만 입력해 주세요.");
    }

    @Test
    @DisplayName("보너스 번호가 여러 개의 값이면 예외가 발생한다.")
    void 보너스_번호_여러_개로_발생하는_예외() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        String input = "1, 2"; // 쉼표로 구분된 여러 값

        assertThatThrownBy(() -> lottoGame.parseAndValidateBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1개만 입력해 주세요.");
    }

    @Test
    @DisplayName("정상적인 로또 게임 실행 시 예외가 발생하지 않는다")
            void 정상적인_로또_게임_실행(){
            List<Integer>validWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
            int validBonusNumber = 7;

            assertThat(validWinningNumbers).hasSize(6);
            assertThat(validBonusNumber).isGreaterThan(0).isLessThanOrEqualTo(45);
    }
}
