package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {

  private static final String ERROR_MESSAGE = "[ERROR]";

  @Test
  void 기능_테스트() {
    assertRandomUniqueNumbersInRangeTest(() -> {
          run("8000", "1,2,3,4,5,6", "7");
          assertThat(output()).contains("8개를 구매했습니다.", "[8, 21, 23, 41, 42, 43]",
              "[3, 5, 11, 16, 32, 38]", "[7, 11, 16, 35, 36, 44]", "[1, 8, 11, 31, 41, 42]",
              "[13, 14, 16, 38, 42, 45]", "[7, 11, 30, 40, 42, 43]", "[2, 13, 22, 32, 38, 45]",
              "[1, 3, 5, 14, 22, 45]", "3개 일치 (5,000원) - 1개", "4개 일치 (50,000원) - 0개",
              "5개 일치 (1,500,000원) - 0개", "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
              "6개 일치 (2,000,000,000원) - 0개", "총 수익률은 62.5%입니다.");
        }, List.of(8, 21, 23, 41, 42, 43), List.of(3, 5, 11, 16, 32, 38),
        List.of(7, 11, 16, 35, 36, 44), List.of(1, 8, 11, 31, 41, 42),
        List.of(13, 14, 16, 38, 42, 45), List.of(7, 11, 30, 40, 42, 43),
        List.of(2, 13, 22, 32, 38, 45), List.of(1, 3, 5, 14, 22, 45));
  }

  @Test
  void 예외_테스트() {
    assertSimpleTest(() -> {
      runException("1000j");
      assertThat(output()).contains(ERROR_MESSAGE);
    });
  }

  @Test
  void 구입_금액_정상_입력_테스트() {
    assertSimpleTest(() -> {
      run("8000", "1,2,3,4,5,6", "7");
      assertThat(output()).doesNotContain(ERROR_MESSAGE);
    });
  }

  @Test
  void 구입_금액_최소_미만_입력_테스트() {
    assertSimpleTest(() -> {
      runException("500", "1,2,3,4,5,6", "7");
      assertThat(output()).contains("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
    });
  }

  @Test
  void 구입_금액_천원_단위_아님_입력_테스트() {
    assertSimpleTest(() -> {
      runException("7500", "1,2,3,4,5,6", "7");
      assertThat(output()).contains("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    });
  }

  @Test
  void 구입_금액_제로_입력_테스트() {
    assertSimpleTest(() -> {
      runException("0", "1,2,3,4,5,6", "7");
      assertThat(output()).contains("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
    });
  }

  @Test
  void 구입_금액_음수_입력_테스트() {
    assertSimpleTest(() -> {
      runException("-5000", "1,2,3,4,5,6", "7");
      assertThat(output()).contains("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
    });
  }

  @Test
  void 구입_금액_숫자_아님_입력_테스트() {
    assertSimpleTest(() -> {
      runException("만원", "1,2,3,4,5,6", "7");
      assertThat(output()).contains("[ERROR] 구입 금액은(는) 숫자여야 합니다.");
    });
  }


  @Test
  void 구입_금액_공백_포함_입력_테스트() {
    assertSimpleTest(() -> {
      run(" 8000 ", "1,2,3,4,5,6", "7");
      assertThat(output()).doesNotContain(ERROR_MESSAGE);
    });
  }

  @Test
  void 구입_금액_빈값_입력_테스트() {
    assertSimpleTest(() -> {
      runException("", "1,2,3,4,5,6", "7");
      assertThat(output()).contains("[ERROR] 입력이 필요합니다.");
    });
  }

  @Test
  void 구입_금액_소수_입력_테스트() {
    assertSimpleTest(() -> {
      runException("8000.5", "1,2,3,4,5,6", "7");
      assertThat(output()).contains("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    });
  }

  @Test
  void 당첨번호_정상_입력_테스트() {
    assertSimpleTest(() -> {
      run("8000", "1,2,3,4,5,6", "7");
      assertThat(output()).doesNotContain(ERROR_MESSAGE);
    });
  }

  @Test
  void 당첨번호_중복_숫자_입력_테스트() {
    assertSimpleTest(() -> {
      runException("8000", "1,2,3,3,5,6", "7");
      assertThat(output()).contains("[ERROR] 로또 번호는 중복될 수 없습니다.");
    });
  }

  @Test
  void 당첨번호_범위_벗어난_숫자_입력_테스트() {
    assertSimpleTest(() -> {
      runException("8000", "0,2,3,4,5,46", "7");
      assertThat(output()).contains("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    });
  }

  @Test
  void 당첨번호_숫자_아닌_입력_테스트() {
    assertSimpleTest(() -> {
      runException("8000", "1,2,삼,4,5,6", "7");
      assertThat(output()).contains("[ERROR] 당첨 번호은(는) 숫자여야 합니다.");
    });
  }

  @Test
  void 당첨번호_숫자_부족_입력_테스트() {
    assertSimpleTest(() -> {
      runException("8000", "1,2,3,4,5", "7");
      assertThat(output()).contains("[ERROR] 로또 번호는 6개여야 합니다.");
    });
  }

  @Test
  void 당첨번호_숫자_초과_입력_테스트() {
    assertSimpleTest(() -> {
      runException("8000", "1,2,3,4,5,6,7", "8");
      assertThat(output()).contains("[ERROR] 로또 번호는 6개여야 합니다.");
    });
  }

  @Test
  void 당첨번호_공백_포함_입력_테스트() {
    assertSimpleTest(() -> {
      run("8000", "1, 2, 3 , 4 ,5 ,6", "7");
      assertThat(output()).doesNotContain(ERROR_MESSAGE);
    });
  }

  @Test
  void 당첨번호_빈값_입력_테스트() {
    assertSimpleTest(() -> {
      runException("8000", "", "7");
      assertThat(output()).contains("[ERROR] 입력이 필요합니다.");
    });
  }

  @Test
  void 당첨번호_특수문자_포함_입력_테스트() {
    assertSimpleTest(() -> {
      runException("8000", "1,2,3,4,5,@", "7");
      assertThat(output()).contains("[ERROR] 당첨 번호은(는) 숫자여야 합니다.");
    });
  }

  @Test
  void 당첨번호_소수_입력_테스트() {
    assertSimpleTest(() -> {
      runException("8000", "1.5,2,3,4,5,6", "7");
      assertThat(output()).contains("[ERROR] 당첨 번호은(는) 숫자여야 합니다.");
    });
  }

  @Test
  void 보너스번호_정상_입력_테스트() {
    assertSimpleTest(() -> {
      run("8000", "1,2,3,4,5,6", "7");
      assertThat(output()).doesNotContain(ERROR_MESSAGE);
    });
  }

  @Test
  void 보너스번호_당첨번호_중복_입력_테스트() {
    assertSimpleTest(() -> {
      runException("8000", "1,2,3,4,5,6", "6");
      assertThat(output()).contains("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    });
  }

  @Test
  void 보너스번호_범위_벗어난_숫자_입력_테스트() {
    assertSimpleTest(() -> {
      runException("8000", "1,2,3,4,5,6", "0");
      assertThat(output()).contains("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    });
  }

  @Test
  void 보너스번호_숫자_아닌_입력_테스트() {
    assertSimpleTest(() -> {
      runException("8000", "1,2,3,4,5,6", "보너스");
      assertThat(output()).contains("[ERROR] 보너스 번호은(는) 숫자여야 합니다.");
    });
  }

  @Test
  void 보너스번호_빈값_입력_테스트() {
    assertSimpleTest(() -> {
      runException("8000", "1,2,3,4,5,6", "", "");
      assertThat(output()).contains("[ERROR] 입력이 필요합니다.");
    });
  }

  @Test
  void 로또_당첨_결과_수익률_0퍼센트_테스트() {
    assertRandomUniqueNumbersInRangeTest(() -> {
          run("8000", "3,6,9,15,18,21", "7");
          assertThat(output()).contains("8개를 구매했습니다.", "총 수익률은 0.0%입니다.");
        }, List.of(8, 9, 10, 11, 12, 13), List.of(14, 15, 16, 17, 18, 19),
        List.of(20, 21, 22, 23, 24, 25), List.of(26, 27, 28, 29, 30, 31),
        List.of(32, 33, 34, 35, 36, 37), List.of(38, 39, 40, 41, 42, 43),
        List.of(44, 45, 1, 2, 3, 4), List.of(5, 6, 7, 8, 9, 10));
  }

  @Test
  void 로또_당첨_결과_수익률_정확한_소수점_계산_테스트() {
    assertRandomUniqueNumbersInRangeTest(() -> {
          run("9000", "1,2,3,4,5,6", "7");
          assertThat(output()).contains("9개를 구매했습니다.", "3개 일치 (5,000원) - 2개", "총 수익률은 111.1%입니다.");
        }, List.of(1, 2, 3, 10, 11, 12), List.of(1, 2, 3, 13, 14, 15), List.of(16, 17, 18, 19, 20, 21),
        List.of(22, 23, 24, 25, 26, 27), List.of(28, 29, 30, 31, 32, 33),
        List.of(34, 35, 36, 37, 38, 39), List.of(40, 41, 42, 43, 44, 45),
        List.of(7, 8, 9, 10, 11, 12), List.of(13, 14, 15, 16, 17, 18));
  }

  @Test
  void 로또_당첨_결과_수익률_소수점_이하_처리_테스트() {
    assertRandomUniqueNumbersInRangeTest(() -> {
          run("12000", "1,2,3,4,5,6", "7");
          assertThat(output()).contains("12개를 구매했습니다.", "3개 일치 (5,000원) - 1개", "총 수익률은 41.7%입니다.");
        }, List.of(1, 2, 3, 10, 11, 12), List.of(13, 14, 15, 16, 17, 18),
        List.of(22, 23, 24, 25, 26, 27), List.of(22, 23, 24, 25, 26, 27),
        List.of(22, 23, 24, 25, 26, 27), List.of(22, 23, 24, 25, 26, 27),
        List.of(22, 23, 24, 25, 26, 27), List.of(22, 23, 24, 25, 26, 27),
        List.of(22, 23, 24, 25, 26, 27), List.of(22, 23, 24, 25, 26, 27),
        List.of(22, 23, 24, 25, 26, 27), List.of(22, 23, 24, 25, 26, 27));
  }

  @Test
  void 로또_당첨_결과_수익률_50퍼센트_테스트() {
    assertRandomUniqueNumbersInRangeTest(() -> {
          run("10000", "1,2,3,4,5,6", "7");
          assertThat(output()).contains("10개를 구매했습니다.", "3개 일치 (5,000원) - 1개", "총 수익률은 50.0%입니다.");
        }, List.of(1, 2, 3, 10, 11, 12), List.of(13, 14, 15, 16, 17, 18),
        List.of(19, 20, 21, 22, 23, 24), List.of(25, 26, 27, 28, 29, 30),
        List.of(31, 32, 33, 34, 35, 36), List.of(37, 38, 39, 40, 41, 42),
        List.of(43, 44, 45, 8, 9, 10), List.of(11, 12, 13, 14, 15, 16),
        List.of(17, 18, 19, 20, 21, 22), List.of(23, 24, 25, 26, 27, 28));
  }

  @Test
  void 로또_당첨_결과_수익률_62_5퍼센트_테스트() {
    assertRandomUniqueNumbersInRangeTest(() -> {
          run("8000", "1,2,3,4,5,6", "7");
          assertThat(output()).contains("8개를 구매했습니다.", "3개 일치 (5,000원) - 1개", "총 수익률은 62.5%입니다.");
        }, List.of(1, 2, 3, 10, 11, 12), List.of(13, 14, 15, 16, 17, 18),
        List.of(19, 20, 21, 22, 23, 24), List.of(25, 26, 27, 28, 29, 30),
        List.of(31, 32, 33, 34, 35, 36), List.of(37, 38, 39, 40, 41, 42),
        List.of(43, 44, 45, 8, 9, 10), List.of(11, 12, 13, 14, 15, 16));
  }

  @Test
  void 로또_당첨_결과_수익률_100퍼센트_테스트() {
    assertRandomUniqueNumbersInRangeTest(() -> {
          run("10000", "1,2,3,4,5,6", "7");
          assertThat(output()).contains("10개를 구매했습니다.", "3개 일치 (5,000원) - 2개", "총 수익률은 100.0%입니다.");
        }, List.of(1, 2, 3, 10, 11, 12), List.of(4, 5, 6, 13, 14, 15), List.of(16, 17, 18, 19, 20, 21),
        List.of(22, 23, 24, 25, 26, 27), List.of(28, 29, 30, 31, 32, 33),
        List.of(34, 35, 36, 37, 38, 39), List.of(40, 41, 42, 43, 44, 45),
        List.of(7, 8, 9, 10, 11, 12), List.of(13, 14, 15, 16, 17, 18),
        List.of(19, 20, 21, 22, 23, 24));
  }

  @Test
  void 로또_당첨_결과_1등_수익률_테스트() {
    assertRandomUniqueNumbersInRangeTest(() -> {
          run("8000", "1,2,3,4,5,6", "7");
          assertThat(output()).contains("8개를 구매했습니다.", "6개 일치 (2,000,000,000원) - 1개",
              "총 수익률은 25000000.0%입니다.");
        }, List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12), List.of(13, 14, 15, 16, 17, 18),
        List.of(19, 20, 21, 22, 23, 24), List.of(25, 26, 27, 28, 29, 30),
        List.of(31, 32, 33, 34, 35, 36), List.of(37, 38, 39, 40, 41, 42),
        List.of(43, 44, 45, 8, 9, 10));
  }

  @Test
  void 로또_당첨_결과_2등_수익률_테스트() {
    assertRandomUniqueNumbersInRangeTest(() -> {
          run("8000", "1,2,3,4,5,7", "6");
          assertThat(output()).contains("8개를 구매했습니다.", "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
              "총 수익률은 375000.0%입니다.");
        }, List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12), List.of(13, 14, 15, 16, 17, 18),
        List.of(19, 20, 21, 22, 23, 24), List.of(25, 26, 27, 28, 29, 30),
        List.of(31, 32, 33, 34, 35, 36), List.of(37, 38, 39, 40, 41, 42),
        List.of(43, 44, 45, 8, 9, 10));
  }

  @Test
  void 로또_당첨_결과_3등_수익률_테스트() {
    assertRandomUniqueNumbersInRangeTest(() -> {
          run("8000", "1,2,3,4,5,7", "6");
          assertThat(output()).contains("8개를 구매했습니다.", "5개 일치 (1,500,000원) - 1개",
              "총 수익률은 18750.0%입니다.");
        }, List.of(1, 2, 3, 4, 5, 8), List.of(6, 7, 9, 10, 11, 12), List.of(13, 14, 15, 16, 17, 18),
        List.of(19, 20, 21, 22, 23, 24), List.of(25, 26, 27, 28, 29, 30),
        List.of(31, 32, 33, 34, 35, 36), List.of(37, 38, 39, 40, 41, 42),
        List.of(43, 44, 45, 8, 9, 10));
  }

  @Test
  void 로또_당첨_결과_4등_수익률_테스트() {
    assertRandomUniqueNumbersInRangeTest(() -> {
          run("8000", "1,2,3,4,7,8", "6");
          assertThat(output()).contains("8개를 구매했습니다.", "4개 일치 (50,000원) - 1개", "총 수익률은 625.0%입니다.");
        }, List.of(1, 2, 3, 4, 9, 10), List.of(5, 6, 7, 8, 11, 12), List.of(13, 14, 15, 16, 17, 18),
        List.of(19, 20, 21, 22, 23, 24), List.of(25, 26, 27, 28, 29, 30),
        List.of(31, 32, 33, 34, 35, 36), List.of(37, 38, 39, 40, 41, 42),
        List.of(43, 44, 45, 8, 9, 10));
  }

  @Test
  void 로또_당첨_결과_여러_등수_당첨_수익률_테스트() {
    assertRandomUniqueNumbersInRangeTest(() -> {
          run("10000", "1,2,3,4,5,6", "7");
          assertThat(output()).contains("10개를 구매했습니다.", "3개 일치 (5,000원) - 2개", "4개 일치 (50,000원) - 1개",
              "5개 일치 (1,500,000원) - 0개", "총 수익률은 600.0%입니다.");
        }, List.of(1, 2, 3, 10, 11, 12), List.of(1, 2, 3, 4, 11, 12), List.of(1, 2, 3, 13, 14, 15),
        List.of(16, 17, 18, 19, 20, 21), List.of(22, 23, 24, 25, 26, 27),
        List.of(28, 29, 30, 31, 32, 33), List.of(34, 35, 36, 37, 38, 39),
        List.of(40, 41, 42, 43, 44, 45), List.of(7, 8, 9, 10, 11, 12),
        List.of(13, 14, 15, 16, 17, 18));
  }

  @Test
  void 로또_당첨_결과_전부_1등_수익률_테스트() {
    assertRandomUniqueNumbersInRangeTest(() -> {
          run("8000", "1,2,3,4,5,6", "7");
          assertThat(output()).contains("8개를 구매했습니다.", "6개 일치 (2,000,000,000원) - 8개",
              "총 수익률은 200000000.0%입니다.");
        }, List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6),
        List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6),
        List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6));
  }

  @Override
  public void runMain() {
    Application.main(new String[]{});
  }
}
