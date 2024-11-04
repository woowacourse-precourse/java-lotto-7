package architecture.analyzer.test.rules;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import architecture.analyzer.main.CodeViolation;
import architecture.analyzer.main.rules.TernaryOperatorRule;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("삼항 연산자 검사 규칙")
class TernaryOperatorRuleTest {

    @Test
    void 삼항_연산자가_없으면_위반을_감지하지_않는다() {
        // given
        String code = """
                public class Test {
                    public String method() {
                        if (true) {
                            return "yes";
                        }
                        return "no";
                    }
                }
                """;
        var rule = new TernaryOperatorRule();

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations).isEmpty();
    }

    @Test
    void 삼항_연산자_사용시_위반을_감지한다() {
        // given
        String code = """
                public class Test {
                    public String method() {
                        return true ? "yes" : "no";
                    }
                }
                """;
        var rule = new TernaryOperatorRule();

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations)
                .hasSize(1)
                .extracting("message")
                .contains("삼항 연산자 사용이 감지되었습니다");
    }

    @Test
    void 제네릭_타입_선언시_물음표는_삼항_연산자로_감지하지_않는다() {
        // given
        String code = """
                public class Test {
                    public void method() {
                        List<Class<? extends Exception>> retryableErrors = List.of(
                            IllegalArgumentException.class,
                            RuntimeException.class
                        );
                
                        for (Class<? extends Exception> retryableError : retryableErrors) {
                            System.out.println(retryableError.getName());
                        }
                    }
                }
                """;
        var rule = new TernaryOperatorRule();

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations).isEmpty();
    }
}
