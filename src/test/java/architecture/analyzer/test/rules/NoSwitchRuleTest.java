package architecture.analyzer.test.rules;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import architecture.analyzer.main.CodeViolation;
import architecture.analyzer.main.rules.NoSwitchRule;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("switch 구문 사용 금지 규칙")
class NoSwitchRuleTest {

    @Test
    void switch_구문이_없으면_위반을_감지하지_않는다() {
        // given
        String code = """
                public class Test {
                    public String method(int value) {
                        if (value == 1) return "one";
                        if (value == 2) return "two";
                        return "other";
                    }
                }
                """;
        var rule = new NoSwitchRule();

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations).isEmpty();
    }

    @Test
    void switch_구문_사용시_위반을_감지한다() {
        // given
        String code = """
                public class Test {
                    public String method(int value) {
                        switch (value) {
                            case 1: return "one";
                            case 2: return "two";
                            default: return "other";
                        }
                    }
                }
                """;
        var rule = new NoSwitchRule();

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations)
                .hasSize(1)
                .extracting("message")
                .contains("switch 구문은 사용할 수 없습니다. if 또는 Map을 사용하세요.");
    }

    @Test
    void switch_expression_사용시_위반을_감지한다() {
        // given
        String code = """
                public class Test {
                    public String method(int value) {
                        String result = switch (value) {
                            case 1 -> "one";
                            case 2 -> "two";
                            default -> "other";
                        };
                        return result;
                    }
                }
                """;
        var rule = new NoSwitchRule();

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations)
                .hasSize(1)
                .extracting("message")
                .contains("switch 구문은 사용할 수 없습니다. if 또는 Map을 사용하세요.");
    }
}
