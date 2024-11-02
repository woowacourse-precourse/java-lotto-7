package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameTest {
    
    private LottoGame lottoGame;
    
    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
    }
    
    // ------------------ inputMoney 관련 테스트 시작 --------------------
    @Test
    @DisplayName("입력한 금액이 1000원 단위가 아니면 예외가 발생한다")
    void 입력한_금액이_1000원_단위가_아니면_예외가_발생한다() {
        // given
        // 표준 출력 스트림을 캡처하기 위한 준비
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Console.close(); // 기존 Scanner 초기화
        // 처음은 설정한 에러가 나게하고 마지막은 정상 처리를 위해 아래와 같은 코드
        System.setIn(new ByteArrayInputStream("100001\n10000\n".getBytes()));
        
        // when
        lottoGame.inputMoney();
        
        // then
        // 에러 메시지 출력 확인
        String output = outContent.toString();
        assertThat(output)
                .contains("[ERROR] 1000원 단위로 입력하세요.")
                .contains("다시 입력해 주세요.");
    }
    
    @Test
    @DisplayName("입력값이 숫자가 아닌 경우 예외가 발생한다")
    void 입력값이_숫자가_아닌_경우_예외가_발생한다() {
        // given
        // 표준 출력 스트림을 캡처하기 위한 준비
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Console.close(); // 기존 Scanner 초기화
        // 처음은 설정한 에러가 나게하고 마지막은 정상 처리를 위해 아래와 같은 코드
        System.setIn(new ByteArrayInputStream("abc\n1,000\n1000원\n1000".getBytes()));
        
        // when
        lottoGame.inputMoney();
        
        // then
        // 에러 메시지 출력 확인
        String output = outContent.toString();
        assertThat(output)
                .contains("[ERROR] 입력한 값은 숫자로 변환할 수 없습니다.")
                .contains("다시 입력해 주세요.");
    }
    
    // Scanner를 해야하는데 null 값이 안들어가서 어떻게 해야 할지 모르겠음
    // 실제 실행 했을 때는 아무것도 안치고 엔터 누를시 원하는 상태 확인
    // TODO: 나중에 추가 수정하기
    @ParameterizedTest
    @DisplayName("입력값이 비어있는 경우 예외가 발생한다")
    @EmptySource
    void 입력값이_비어있는_경우_예외가_발생한다(String input) {
        // given
        // 표준 출력 스트림을 캡처하기 위한 준비
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Console.close(); // 기존 Scanner 초기화
        // 처음은 설정한 에러가 나게하고 마지막은 정상 처리를 위해 아래와 같은 코드
        System.setIn(new ByteArrayInputStream((input + "\n" + "1000").getBytes()));
        
        lottoGame.inputMoney();
        
        // then
        // 예외 메시지 검증 (선택 사항)
        String output = outContent.toString();
         assertThat(output)
                 .contains("[ERROR] 입력한 값이 없습니다.");
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
        // given
        int money = 10000;
        
        Console.close(); // 기존 Scanner 초기화
        System.setIn(new ByteArrayInputStream("10000\n".getBytes()));
        
        // when & then
        assertDoesNotThrow(() -> lottoGame.generateLottos(money));
    }
    // ------------------ generateLottos 관련 테스트 끝 --------------------
    // ------------------ generateWinningLotto 관련 테스트 끝 --------------------
    @Test
    @DisplayName("올바른 로또 번호 입력시 정상적으로 처리된다")
    void validateValidLottoNumbers() {
        // given
        Console.close(); // 기존 Scanner 초기화
        String input = "1,2,3,4,5,6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        // when
        Lotto lotto = lottoGame.generateWinningLotto();
        
        List<Integer> numbers = lotto.getNumbers();
        
        // then
        assertThat(numbers).hasSize(6)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }
    
    @Test
    @DisplayName("로또 번호가 6개가 아닌 경우 예외가 발생한다")
    void validateWrongSizeLottoNumbers() {
        // given
        // 표준 출력 스트림을 캡처하기 위한 준비
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // when
        Console.close(); // 기존 Scanner 초기화
        String input = "1,2,3,4,5\n1,2,3,4,5,6"; // 실패한 코드, 성공한 코드(반복을 끝내기 위해)
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        lottoGame.generateWinningLotto();
        
        // then
        String output = outContent.toString();
        assertThat(output)
                .contains("[ERROR] 로또 번호는 6개여야 합니다.");
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    @DisplayName("로또 번호가 1~45 범위를 벗어나는 경우 예외가 발생한다")
    void validateOutOfRangeLottoNumbers(String input) {
        // given
        // 표준 출력 스트림을 캡처하기 위한 준비
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // when
        Console.close(); // 기존 Scanner 초기화
        System.setIn(new ByteArrayInputStream((input + "\n" + "1,2,3,4,5,6").getBytes()));
        
        lottoGame.generateWinningLotto();
        
        // then
        String output = outContent.toString();
        assertThat(output)
                .contains("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    
    // 이것 또한 null을 어떻게 테스트해야 할지 모르겠음
    @Test
    @DisplayName("로또 번호가 비어있는 경우 예외가 발생한다")
    void validateEmptyLottoNumbers() {
        // given
        // 표준 출력 스트림을 캡처하기 위한 준비
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "";
        
        // when
        Console.close(); // 기존 Scanner 초기화
        System.setIn(new ByteArrayInputStream((input + "\n" + "1,2,3,4,5,6").getBytes()));
        
        lottoGame.generateWinningLotto();
        
        // then
        String output = outContent.toString();
        assertThat(output)
                .contains("[ERROR] 로또 번호가 비어있습니다.");
    }
    
    @Test
    @DisplayName("쉼표 형식이 잘못된 경우 예외가 발생한다")
    void validateInvalidCommaFormat() {
        // given
        // 표준 출력 스트림을 캡처하기 위한 준비
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "1,2,3,4,5,,6";
        
        // when
        Console.close(); // 기존 Scanner 초기화
        System.setIn(new ByteArrayInputStream((input + "\n" + "1,2,3,4,5,6").getBytes()));
        
        lottoGame.generateWinningLotto();
        
        // then
        String output = outContent.toString();
        assertThat(output)
                .contains("[ERROR] 입력한 값은 Integer 배열로 변환할 수 없습니다.");
    }
    
    @Test
    @DisplayName("공백이 포함된 입력도 정상적으로 처리된다")
    void validateLottoNumbersWithSpaces() {
        // given
        // 표준 출력 스트림을 캡처하기 위한 준비
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String input = "1, 2, 3, 4, 5, 6";
        
        // when
        Console.close(); // 기존 Scanner 초기화
        System.setIn(new ByteArrayInputStream((input + "\n" + "1,2,3,4,5,6").getBytes()));
        
        // then
        assertDoesNotThrow(() -> lottoGame.generateWinningLotto());
    }
    // ------------------ generateWinningLotto 관련 테스트 끝 --------------------
    // ------------------ generateBonusLottoNumber 관련 테스트 시작 --------------------
    @Test
    @DisplayName("보너스 번호의 입력된 값이 빈값일 경우 에러가 발생한다.")
    void validateBonusNumberWhenEmpty() {
        // given
        // 표준 출력 스트림을 캡처하기 위한 준비
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        
        String input = "";
        
        // when
        Console.close(); // 기존 Scanner 초기화
        System.setIn(new ByteArrayInputStream((input + "\n" + "7").getBytes()));
        
        lottoGame.generateBonusLottoNumber(winningLotto);
        
        // then
        String output = outContent.toString();
        assertThat(output)
                .contains("[ERROR] 보너스 번호가 비어있습니다.");
    }
    
    @Test
    @DisplayName("보너스 번호의 입력된 값이 숫자가 아닌 경우 에러가 발생한다.")
    void validateBonusNumberWhenNotANumber() {
        // given
        // 표준 출력 스트림을 캡처하기 위한 준비
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        
        String input = "일";
        
        // when
        Console.close(); // 기존 Scanner 초기화
        System.setIn(new ByteArrayInputStream((input + "\n" + "7").getBytes()));
        
        lottoGame.generateBonusLottoNumber(winningLotto);
        
        // then
        String output = outContent.toString();
        assertThat(output)
                .contains("[ERROR] 입력받은 문자를 숫자로 변환할 수 없습니다.");
    }
    
    @ParameterizedTest
    @DisplayName("보너스 번호의 입력된 값이 1미만 45초과의 숫자이면 에러가 발생한다.")
    @ValueSource(strings = {"0", "46"})
    void validateBonusNumberWhenNumberLessThan1OrGreaterThan45(String input) {
        // given
        // 표준 출력 스트림을 캡처하기 위한 준비
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        
        // when
        Console.close(); // 기존 Scanner 초기화
        System.setIn(new ByteArrayInputStream((input + "\n" + "7").getBytes()));
        
        lottoGame.generateBonusLottoNumber(winningLotto);
        
        // then
        String output = outContent.toString();
        assertThat(output)
                .contains("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    
    @Test
    @DisplayName("보너스 번호의 입력된 값이 당첨 로또 번호와 중복되면 에러가 발생한다.")
    void validateBonusNumberWhenDuplicated() {
        // given
        // 표준 출력 스트림을 캡처하기 위한 준비
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        
        String input = "6";
        
        // when
        Console.close(); // 기존 Scanner 초기화
        System.setIn(new ByteArrayInputStream((input + "\n" + "7").getBytes()));
        
        lottoGame.generateBonusLottoNumber(winningLotto);
        
        // then
        String output = outContent.toString();
        assertThat(output)
                .contains("[ERROR] 당첨 번호와 보너스 번호에는 중복된 번호가 없어야 합니다.");
    }
    
    @Test
    @DisplayName("보너스 번호를 정상적으로 입력했을 경우 정상 작동 한다.")
    void generateBonusLottoNumberWhenValid() {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        
        String input = "7";
        
        // when
        Console.close(); // 기존 Scanner 초기화
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        // then
        assertDoesNotThrow(() -> lottoGame.generateBonusLottoNumber(winningLotto));
    }
    // ------------------ generateBonusLottoNumber 관련 테스트 끝 --------------------
    
}