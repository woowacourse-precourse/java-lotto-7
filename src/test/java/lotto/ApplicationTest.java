package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @DisplayName("로또 구입 금액은 1,000 단위로 입력받는다.")
    @Test
    void 로또_구입_금액을_천_단위로_입력받는다() {
        assertSimpleTest(() -> {
            run("5000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains("총 수익률은");
        });
    }

    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_천원으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("1500", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액이 null일 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_null일_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException(null, "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액에 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액에_문자가_입력될_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("500o", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액에 공백 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액에_공백_문자가_입력될_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException(" ", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액에 아무것도 입력되지 않을 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액에_아무것도_입력되지_않을_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("", "1,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액이 100,000원을 초과할 경우 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_십만원을_초과할_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("101000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 1장의 가격은 1,000원이다.")
    @Test
    void 로또_한장의_가격은_천원이다() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains("1개를 구매했습니다.");
        });
    }

    @DisplayName("1장의 로또는 6개의 번호를 가진다.")
    @Test
    void 한장의_로또는_여섯개의_번호를_가진다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]");
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("당첨_번호는_6개의_숫자이다")
    @Test
    void 당첨_번호는_여섯개의_숫자이다() {
        assertSimpleTest(() -> {
            run("8000", "1,2,3,4,5,6", "7");
            assertThat(output()).contains("총 수익률은");
        });
    }

    @DisplayName("당첨 번호가 6개 미만의 개수일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_여섯개_미만의_개수일_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 6개 초과의 개수일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_여섯개_초과의_개수일_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6,7", "8");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있을_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,3,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호의 숫자 범위는 1~45이다.")
    @Test
    void 당첨_번호의_숫자_범위는_일에서_사십온_사이이다() {
        assertSimpleTest(() -> {
            run("8000", "1,5,18,29,36,45", "7");
            assertThat(output()).contains("총 수익률은");
        });
    }

    @DisplayName("당첨 번호가 1 미만일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_일_미만일_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "0,2,3,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 45를 초과할 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_사십오를_초과할_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,46", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호는 쉼표(,)를 기준으로 구분한다.")
    @Test
    void 당첨_번호는_쉼표로_구분한다() {
        assertSimpleTest(() -> {
            runException("8000", "1 2 3 4 5 6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호의 쉼표(,) 사이에 아무 숫자가 없을 경우 예외가 발생한다.")
    @Test
    void 당첨_번호의_쉼표_사이에_아무_숫자가_없을_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,,4,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호에 숫자와 쉼표를 제외한 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_숫자와_쉼표를_제외한_문자가_입력될_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,a,5,6", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호에 공백 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_공백_문자가_입력될_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", " ", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호에 아무것도 입력되지 않을 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_아무것도_입력되지_않을_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "", "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호가 null일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_null일_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", null, "7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호의 숫자 범위는 1~45이다.")
    @Test
    void 보너스_번호의_숫자_범위는_일에서_사십오_사이이다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "45");
            assertThat(output()).contains("총 수익률은");
        });
    }

    @DisplayName("보너스 번호가 1 미만일 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_일_미만일_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 45를 초과할 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_사십오를_초과할_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호에 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호에_문자가_입력될_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호에 공백 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호에_공백_문자가_입력될_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호에 아무것도 입력되지 않을 경우 예외가 발생한다.")
    @Test
    void 보너스_번호에_아무것도_입력되지_않을_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 null일 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_null일_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", null);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복될_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호와 로또 번호가 6개 일치할 경우 1등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_6개_일치할_경우_1등에_당첨된다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 200,000,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @DisplayName("당첨 번호와 로또 번호가 5개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 2등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_5개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_2등에_당첨된다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 7]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 3,000,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    @DisplayName("당첨 번호와 로또 번호가 5개 일치할 경우 3등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_5개_일치할_경우_3등에_당첨된다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 8]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 150,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 8)
        );
    }

    @DisplayName("당첨 번호와 로또 번호가 4개 일치할 경우 4등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_4개_일치할_경우_4등에_당첨된다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 8, 9]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 5,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 8, 9)
        );
    }

    @DisplayName("당첨 번호와 로또 번호가 4개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 4등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_4개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_4등에_당첨된다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 4, 7, 8]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 5,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 7, 8)
        );
    }

    @DisplayName("당첨 번호와 로또 번호가 3개 일치할 경우 5등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_3개_일치할_경우_5등에_당첨된다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 8, 9, 10]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(1, 2, 3, 8, 9, 10)
        );
    }

    @DisplayName("당첨 번호와 로또 번호가 3개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 5등에 당첨된다.")
    @Test
    void 당첨_번호와_로또_번호가_3개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_5등에_당첨된다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 3, 7, 8, 9]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(1, 2, 3, 7, 8, 9)
        );
    }

    @DisplayName("당첨 번호와 로또 번호가 2개 일치할 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_2개_일치할_경우_당첨되지_않는다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 8, 9, 10, 11]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(1, 2, 8, 9, 10, 11)
        );
    }

    @DisplayName("당첨 번호와 로또 번호가 2개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_2개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_당첨되지_않는다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 2, 7, 8, 9, 10]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(1, 2, 7, 8, 9, 10)
        );
    }

    @DisplayName("당첨 번호와 로또 번호가 1개 일치할 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_1개_일치할_경우_당첨되지_않는다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 8, 9, 10, 11, 12]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(1, 8, 9, 10, 11, 12)
        );
    }

    @DisplayName("당첨 번호와 로또 번호가 1개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_1개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_당첨되지_않는다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[1, 7, 8, 9, 10, 11]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(1, 7, 8, 9, 10, 11)
        );
    }

    @DisplayName("당첨 번호와 로또 번호가 0개 일치할 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_0개_일치할_경우_당첨되지_않는다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[8, 9, 10, 11, 12, 13]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(8, 9, 10, 11, 12, 13)
        );
    }

    @DisplayName("당첨 번호와 로또 번호가 0개 일치하고 보너스 번호가 로또 번호에 포함되어 있을 경우 당첨되지 않는다.")
    @Test
    void 당첨_번호와_로또_번호가_0개_일치하고_보너스_번호가_로또_번호에_포함되어_있을_경우_당첨되지_않는다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[7, 8, 9, 10, 11, 12]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(7, 8, 9, 10, 11, 12)
        );
    }

    @DisplayName("여러 등수에 동시에 당첨될 수 있다.")
    @Test
    void 여러_등수에_동시에_당첨될_수_있다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("10000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 2개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 2개",
                            "총 수익률은 40,316,100.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 7, 8),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 7, 8, 9),
                List.of(1, 2, 3, 8, 9, 10),
                List.of(1, 2, 7, 8, 9, 10),
                List.of(1, 2, 8, 9, 10, 11),
                List.of(1, 7, 8, 9, 10, 11),
                List.of(1, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(8, 9, 10, 11, 12, 13)
        );
    }

    @DisplayName("당첨 내역은 낮은 등수부터 차례로 보여준다")
    @Test
    void 당첨_내역은_낮은_등수부터_차례로_보여준다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("10000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 2개\n"
                                    + "4개 일치 (50,000원) - 2개\n"
                                    + "5개 일치 (1,500,000원) - 1개\n"
                                    + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                                    + "6개 일치 (2,000,000,000원) - 2개"
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 7, 8),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 7, 8, 9),
                List.of(1, 2, 3, 8, 9, 10),
                List.of(1, 2, 7, 8, 9, 10),
                List.of(1, 2, 8, 9, 10, 11),
                List.of(1, 7, 8, 9, 10, 11),
                List.of(1, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(8, 9, 10, 11, 12, 13)
        );
    }

    @DisplayName("수익률은 소수점 둘째 자리가 5 미만인 경우 버림한다.")
    @Test
    void 수익률은_소수점_둘째_자리가_5_미만인_경우_버림한다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("6000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 83.3%입니다."
                    );
                },
                List.of(1, 2, 3, 8, 9, 10),
                List.of(8, 9, 10, 11, 12, 13),
                List.of(8, 9, 10, 11, 12, 13),
                List.of(8, 9, 10, 11, 12, 13),
                List.of(8, 9, 10, 11, 12, 13),
                List.of(8, 9, 10, 11, 12, 13)
        );
    }

    @DisplayName("수익률은 소수점 둘째 자리가 5 이상인 경우 올림한다.")
    @Test
    void 수익률은_소수점_둘째_자리가_5_이상인_경우_올림한다() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 166.7%입니다."
                    );
                },
                List.of(1, 2, 3, 8, 9, 10),
                List.of(8, 9, 10, 11, 12, 13),
                List.of(8, 9, 10, 11, 12, 13)
        );
    }
}
