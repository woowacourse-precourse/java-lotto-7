package architecture.analyzer.test.rules;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import architecture.analyzer.main.CodeViolation;
import architecture.analyzer.main.rules.NoElseRule;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("else 구문 사용 금지 규칙")
class NoElseRuleTest {

    @Test
    void else_구문이_없으면_위반을_감지하지_않는다() {
        // given
        String code = """
                public class Test {
                    public String method(boolean condition) {
                        if (condition) {
                            return "yes";
                        }
                        return "no";
                    }
                }
                """;
        var rule = new NoElseRule();

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations).isEmpty();
    }

    @Test
    void else_구문_사용시_위반을_감지한다() {
        // given
        String code = """
                public class Test {
                    public String method(boolean condition) {
                        if (condition) {
                            return "yes";
                        } else {
                            return "no";
                        }
                    }
                }
                """;
        var rule = new NoElseRule();

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations)
                .hasSize(1)
                .extracting("message")
                .contains("else 구문은 사용할 수 없습니다. early return 을 고려하세요.");
    }

    @Test
    void else_if_구문_사용시_위반을_감지한다() {
        // given
        String code = """
                public class Test {
                    public String method(int value) {
                        if (value > 0) {
                            return "positive";
                        } else if (value < 0) {
                            return "negative";
                        }
                        return "zero";
                    }
                }
                """;
        var rule = new NoElseRule();

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations)
                .hasSize(1)
                .extracting("message")
                .contains("else 구문은 사용할 수 없습니다. early return 을 고려하세요.");
    }
}
