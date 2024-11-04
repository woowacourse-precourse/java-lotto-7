package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.service.lotto.constant.LottoConstant.MATCH_SIX_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.common.exception.ExceptionEnum;
import lotto.model.lotto.Lotto;
import lotto.service.lotto.constant.LottoConstant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 3.
 */
class SeparateApplicationTest extends NsTest {
  private List<Integer> lottoNumbers;
  private Lotto lotto;

  @BeforeEach
  void setUp (){
    lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    lotto = Lotto.from(lottoNumbers);
  }



  /**
   * 당첨 번호와 보너스 번호 입력에 대한 유효성을 검증하는 테스트.
   * 요구사항에 로또 번호와 보너스 번호 사이의 중복을 금지하는 내용이 없으므로
   * 당첨 번호와 보너스 번호 간의 중복이 허용됩니다.
   *
   * 2024.11.03 중복 허용 하지 않도록 수정합니다.
   */
  @ParameterizedTest
  @CsvSource(delimiter = '|', value = {
      "8000| 1,2,3,4,5,6| 3| 당첨 통계",
      "8000| 1,2,3,4,5,6| 1| 당첨 통계",
  })
  @DisplayName("[fail]main : 당첨 번호와 보너스 번호 중복 입력 검증")
  void main_verify_winningNumbersAndBonusNumber_duplicateAllowed(
      String validAmount,
      String validWinningNumbers,
      String invalidBonusNumber,
      String expectedOutput
  ) {
    String validBonusNumber = "30";
    assertSimpleTest(() -> {
      run(validAmount, validWinningNumbers, invalidBonusNumber, validBonusNumber);
      assertThat(output()).satisfies(
          text -> assertThat(text).containsOnlyOnce("구입금액을 입력해 주세요."),
          text -> assertThat(text).containsOnlyOnce("당첨 번호를 입력해 주세요."),
          text -> assertThat(text).containsSubsequence(
              "보너스 번호를 입력해 주세요.",
              "보너스 번호를 입력해 주세요."
          ),
          text -> assertThat(text).contains(expectedOutput)
      );
    });
  }

  @Test
  @DisplayName("[success]main : 사용자 입력 처리")
  void main_verify_userInput() {
    long repeatCount = 5000;
    assertRandomUniqueNumbersInRangeTest(
        () -> {
          run(String.valueOf(repeatCount * LottoConstant.AMOUNT_UNIT), "1,2,3,4,5,6", "7");
          assertThat(output()).contains(
              String.format("%,d", repeatCount) + "개를 구매했습니다.",
              "3개 일치 (5,000원) - 0개",
              "4개 일치 (50,000원) - 0개",
              "5개 일치 (1,500,000원) - 0개",
              "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
              "6개 일치 (2,000,000,000원) - " + String.format("%,d", repeatCount) + "개"
          );
        },
        lottoNumbers
    );
  }

  @Test
  @DisplayName("[success]main : 최소 구매 금액 입력 처리")
  void main_verify_minimumPurchaseAmount() {
    assertRandomUniqueNumbersInRangeTest(
        () -> {
          run("1000", "1,2,3,4,5,6", "7");
          assertThat(output()).contains(
              "1개를 구매했습니다."
          );
        },
        List.of(8, 21, 23, 41, 42, 43)
    );
  }

  @Test
  @Disabled("메모리 이슈로 인한 비활성화")
  @DisplayName("[memory-issue]main : 사용자 입력 처리 - 최대 당첨 시나리오")
  void main_verify_maximumWinning() {
    long repeatCount = Long.MAX_VALUE / MATCH_SIX_PRIZE;
    List<Integer> lotteryNumbers = List.of(1, 2, 3, 4, 5, 6);
    assertRandomUniqueNumbersInRangeTest(
        () -> {
          run(String.valueOf(repeatCount * LottoConstant.AMOUNT_UNIT), "1,2,3,4,5,6", "7");
          assertThat(output()).contains(
              String.format("%,d", repeatCount) + "개를 구매했습니다.",
              "3개 일치 (5,000원) - 0개",
              "4개 일치 (50,000원) - 0개",
              "5개 일치 (1,500,000원) - 0개",
              "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
              "6개 일치 (2,000,000,000원) - " + String.format("%,d", repeatCount) + "개"
          );
        },
        lotteryNumbers
    );
  }

  @Test
  @DisplayName("[success]main : 사용자 입력 처리 - 유효한 최대 당첨 시나리오")
  void main_verify_validMaximumWinning() {
    long repeatCount = 50000;
    List<Integer> lotteryNumbers = List.of(1, 2, 3, 4, 5, 6);
    assertRandomUniqueNumbersInRangeTest(
        () -> {
          run(String.valueOf(repeatCount * LottoConstant.AMOUNT_UNIT), "1,2,3,4,5,6", "7");
          assertThat(output()).contains(
              String.format("%,d", repeatCount) + "개를 구매했습니다.",
              "3개 일치 (5,000원) - 0개",
              "4개 일치 (50,000원) - 0개",
              "5개 일치 (1,500,000원) - 0개",
              "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
              "6개 일치 (2,000,000,000원) - " + String.format("%,d", repeatCount) + "개"
          );
        },
        lotteryNumbers
    );
  }

  @ParameterizedTest
  @ValueSource(ints = {4,5,6,7})
  @DisplayName("[fail]main : 구매 금액이 구매 단위가 아닌 경우")
  void main_verify_purchaseAmountUnit(int extraAmount) {
    assertSimpleTest(() -> {
      runException(String.valueOf(LottoConstant.AMOUNT_UNIT + extraAmount));
      assertThat(output()).contains(ExceptionEnum
          .PURCHASE_AMOUNT_NOT_IN_UNIT.getMessage());
    });
  }

  @Test
  @DisplayName("[fail]main : 당첨 번호가 중복인 경우")
  void main_verify_distinct() {
    assertSimpleTest(() -> {
      runException("8000", "1,2,3,4,5,5", "7");
      assertThat(output()).contains(ExceptionEnum
          .LOTTO_NUMBER_NOT_DISTINCT.getMessage());
    });
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "1,2,3,4,5,46",
      "1,992,3,4,5,6",
      "1,2,3,4,5,100",
      "1,2,3,46,5,70",
      "1,2,3,4,5,76"})
  @DisplayName("[fail]main : 당첨 번호 범위가 초과인 경우")
  void main_verify_lottoNumberMaximum(String greaterNumber) {
    assertSimpleTest(() -> {
      runException("8000", greaterNumber, "7");
      assertThat(output()).contains(ExceptionEnum
          .INPUT_GREATER_THAN_MAXIMUM.getMessage());
    });
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "0,2,3,4,5,45",
      "-1,2,3,4,5,6",
      "1,-5,3,4,5,45",
      "1,2,0,4,5,45",
      "1,2,3,4,-10,45"
  })
  @DisplayName("[fail]main : 당첨 번호 범위가 미만인 경우")
  void main_verify_lottoNumberMinimum(String fewerNumbwer) {
    assertSimpleTest(() -> {
      runException("8000", fewerNumbwer, "7");
      assertThat(output()).contains(ExceptionEnum
          .INPUT_LESS_THAN_MINIMUM.getMessage());
    });
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "1,2,3,4,5",
      "1,2,3,4",
      "1,2,3",
      "1,2",
      "1"
  })
  @DisplayName("[fail]main : 당첨 번호 개수가 부족한 경우")
  void main_verify_lottoNumber_lessThanCount(String fewerNumbers) {
    assertSimpleTest(() -> {
      runException("8000", fewerNumbers, "7");
      assertThat(output()).contains(ExceptionEnum.LOTTO_NUMBER_COUNT_NOT_AVAILABLE.getMessage());
    });
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "1,2,3,4,5,6,7",
      "1,2,3,4,5,6,7,8",
      "1,2,3,4,5,6,7,8,9",
      "1,2,3,4,5,6,7,8,9,10",
      "1,2,3,4,5,6,7,8,9,10,11,12"
  })
  @DisplayName("[fail]main : 당첨 번호 개수가 초과한 경우")
  void main_verify_lottoNumber_greaterThanCount(String moreNumbers) {
    assertSimpleTest(() -> {
      runException("8000", moreNumbers, "20");
      assertThat(output()).contains(ExceptionEnum
          .LOTTO_NUMBER_COUNT_NOT_AVAILABLE.getMessage());
    });
  }

  @ParameterizedTest
  @CsvSource({
      "abc, [ERROR]",
      "-1000, [ERROR]",
      "1500, [ERROR]",
      "0, [ERROR]"
  })
  @DisplayName("[fail]main : 유효하지 않은 구매 금액 입력 시 재입력 요청")
  void main_verify_invalidPurchaseAmount_askForReentry(String invalidInput, String expectedMessage) {
    assertSimpleTest(() -> {
      runException(invalidInput);
      assertThat(output()).contains(expectedMessage);
    });
  }

  @ParameterizedTest
  @CsvSource(delimiter = '|', value = {
      "8000| 1,2,3,4,5| [ERROR]",
      "8000| 1,2,3,4,5,6,7| [ERROR]",
      "8000| 1,2,3,4,5,46| [ERROR]",
      "8000| 0,1,2,3,4,5| [ERROR]",
      "8000| 1,2,3,3,4,5| [ERROR]",
      "8000| a,b,c,d,e,f| [ERROR]"
  })
  @DisplayName("[success] main : 유효한 구매 금액 입력 후 유효하지 않은 로또 번호 입력 시 재입력 요청")
  void main_verify_validPurchaseAmount_invalidLottoNumbers_askForReentry(String validAmount,
      String invalidNumbers,
      String expectedMessage) {
    assertSimpleTest(() -> {
      run(validAmount, invalidNumbers, "1,2,3,4,5,6", "7");
      assertThat(output()).contains(expectedMessage);
      assertThat(output()).satisfies(
          text -> assertThat(text).containsOnlyOnce("구입금액을 입력해 주세요."),
          text -> assertThat(text).containsSubsequence( // 재입력 요청 하는지 확인
              "당첨 번호를 입력해 주세요.",
              "당첨 번호를 입력해 주세요."
          ),
          text -> assertThat(text).containsOnlyOnce("보너스 번호를 입력해 주세요.")
      );
    });
  }

  @ParameterizedTest
  @CsvSource(delimiter = '|', value = {
      "8000| 1,2,3,4,5,6| 0| [ERROR]",
      "8000| 1,2,3,4,5,6| 46| [ERROR]",
      "8000| 1,2,3,4,5,6| -1| [ERROR]",
      "8000| 1,2,3,4,5,6| a| [ERROR]"
  })
  @DisplayName("[success] main : 유효한 구매 금액과 당첨 번호 입력 후 유효하지 않은 보너스 번호 입력 시 재입력 요청")
  void main_verify_validPurchaseAmountAndWinningNumbers_invalidBonusNumber_askForReentry(
      String validAmount,
      String validWinningNumbers,
      String invalidBonusNumber,
      String expectedErrorMessage
  ) {
    assertSimpleTest(() -> {
      run(validAmount, validWinningNumbers, invalidBonusNumber, "7");
      assertThat(output()).satisfies(
          text -> assertThat(text).containsOnlyOnce("구입금액을 입력해 주세요."),
          text -> assertThat(text).containsOnlyOnce("당첨 번호를 입력해 주세요."),
          text -> assertThat(text).containsSubsequence(
              "보너스 번호를 입력해 주세요.",
              "보너스 번호를 입력해 주세요."
          ),
          text -> assertThat(text).contains(expectedErrorMessage)
      );
    });
  }

  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}