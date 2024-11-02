package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameTest extends NsTest {
    
    private static final String ERROR_MESSAGE = "[ERROR]";
    
    
    // ------------------ inputMoney 관련 테스트 시작 --------------------
    @Test
    @DisplayName("입력한 금액이 1000원 단위가 아니면 예외가 발생한다")
    void 입력한_금액이_1000원_단위가_아니면_예외가_발생한다() {
        
        assertSimpleTest(() -> {
            runException("100001");
            assertThat(output()).contains(ERROR_MESSAGE, "1000원 단위로 입력하세요.");
        });
    }
    
    @Test
    @DisplayName("입력값이 숫자가 아닌 경우 예외가 발생한다")
    void 입력값이_숫자가_아닌_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("abc");
            assertThat(output()).contains(ERROR_MESSAGE, "입력한 값은 숫자로 변환할 수 없습니다.");
        });
    }

    // Scanner를 해야하는데 null 값이 안들어가서 어떻게 해야 할지 모르겠음
    // 실제 실행 했을 때는 아무것도 안치고 엔터 누를시 원하는 상태 확인
    // TODO: 나중에 추가 수정하기
    @ParameterizedTest
    @DisplayName("입력값이 비어있는 경우 예외가 발생한다")
    @EmptySource
    void 입력값이_비어있는_경우_예외가_발생한다(String input) {
        assertSimpleTest(() -> {
            runException("\n");
            assertThat(output()).contains(ERROR_MESSAGE, "입력한 값이 없습니다.");
        });
    }
    // ------------------ inputMoney 관련 테스트 끝 --------------------
    // ------------------ generateLottos 관련 테스트 시작 --------------------
    @Test
    @DisplayName("로또 번호가 올바르게 생성되는지 확인")
    void 로또_번호가_올바르게_생성되는지_확인() {
        // given
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        // when & then
        assertThat(numbers.size()).isEqualTo(6);  // 6개 숫자 확인
        assertThat(numbers.stream()
                .allMatch(num -> num >= 1 && num <= 45)).isTrue();  // 범위 확인
        assertThat(numbers.size())
                .isEqualTo(numbers.stream().distinct().count());  // 중복 확인
    }

    @Test
    @DisplayName("금액 입력 시 1000원 단위로 로또가 출력되는지 확인")
    void 금액_입력_시_1000원_단위로_로또가_출력되는지_확인() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "7");
                    assertThat(output())
                            .contains("3개를 구매했습니다.")
                            .contains("[1, 2, 3, 4, 5, 6]")
                            .contains("[7, 8, 9, 10, 11, 12]")
                            .contains("[13, 14, 15, 16, 17, 18]");
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(13, 14, 15, 16, 17, 18)
        );
    }
    // ------------------ generateLottos 관련 테스트 끝 --------------------
    // ------------------ generateWinningLotto 관련 테스트 끝 --------------------
    @Test
    @DisplayName("올바른 로또 번호 입력시 정상적으로 처리된다")
    void validateValidLottoNumbers() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output())
                            .contains("1개를 구매했습니다.")
                            .contains("[1, 2, 3, 4, 5, 6]")
                            .contains("당첨 통계")
                            .contains("3개 일치")
                            .contains("4개 일치")
                            .contains("5개 일치")
                            .contains("6개 일치")
                            .doesNotContain("[ERROR]");
                },
                List.of(1, 2, 3, 4, 5, 6)  // 구매한 로또 번호를 당첨 번호와 동일하게 설정
        );
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닌 경우 예외가 발생한다")
    void validateWrongSizeLottoNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE, "로또 번호는 6개여야 합니다.");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    @DisplayName("로또 번호가 1~45 범위를 벗어나는 경우 예외가 발생한다")
    void validateOutOfRangeLottoNumbers(String input) {
        assertSimpleTest(() -> {
            runException("1000", input);
            assertThat(output()).contains(ERROR_MESSAGE, "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }

    // 이것 또한 null을 어떻게 테스트해야 할지 모르겠음
    @Test
    @DisplayName("로또 번호가 비어있는 경우 예외가 발생한다")
    void validateEmptyLottoNumbers() {
        assertSimpleTest(() -> {
            runException("1000", "\n");
            assertThat(output()).contains(ERROR_MESSAGE, "로또 번호가 비어있습니다.");
        });
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,,5", "1/2,3,4,5,46"})
    void validateInvalidCommaFormat(String input) {
        assertSimpleTest(() -> {
            runException("1000", input);
            assertThat(output()).contains(ERROR_MESSAGE, "입력한 값은 Integer 배열로 변환할 수 없습니다.");
        });
    }

    @Test
    @DisplayName("공백이 포함된 입력도 정상적으로 처리된다")
    void validateLottoNumbersWithSpaces() {
        assertSimpleTest(() -> {
            runException("1000", "1, 2, 3, 4, 5,   6", "7");
            assertThat(output())
                    .doesNotContain(ERROR_MESSAGE);
        });
    }
    // ------------------ generateWinningLotto 관련 테스트 끝 --------------------
    // ------------------ generateBonusLottoNumber 관련 테스트 시작 --------------------
    @Test
    @DisplayName("보너스 번호의 입력된 값이 빈값일 경우 에러가 발생한다.")
    void validateBonusNumberWhenEmpty() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "\n");
            assertThat(output()).contains(ERROR_MESSAGE, "보너스 번호가 비어있습니다.");
        });
    }

    @Test
    @DisplayName("보너스 번호의 입력된 값이 숫자가 아닌 경우 에러가 발생한다.")
    void validateBonusNumberWhenNotANumber() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "일");
            assertThat(output()).contains(ERROR_MESSAGE, "입력받은 문자를 숫자로 변환할 수 없습니다.");
        });
    }

    @ParameterizedTest
    @DisplayName("보너스 번호의 입력된 값이 1미만 45초과의 숫자이면 에러가 발생한다.")
    @ValueSource(strings = {"0", "46"})
    void validateBonusNumberWhenNumberLessThan1OrGreaterThan45(String input) {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", input);
            assertThat(output()).contains(ERROR_MESSAGE, "보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }

    @Test
    @DisplayName("보너스 번호의 입력된 값이 당첨 로또 번호와 중복되면 에러가 발생한다.")
    void validateBonusNumberWhenDuplicated() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE, "당첨 번호와 보너스 번호에는 중복된 번호가 없어야 합니다.");
        });
    }

    @Test
    @DisplayName("보너스 번호를 정상적으로 입력했을 경우 정상 작동 한다.")
    void generateBonusLottoNumberWhenValid() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "7");
            assertThat(output())
                    .doesNotContain(ERROR_MESSAGE);
        });
    }
    
    // ------------------ generateBonusLottoNumber 관련 테스트 끝 --------------------
    
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
  
    
}