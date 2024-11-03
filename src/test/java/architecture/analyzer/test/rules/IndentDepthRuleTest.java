package architecture.analyzer.test.rules;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import architecture.analyzer.main.CodeViolation;
import architecture.analyzer.main.rules.IndentDepthRule;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("들여쓰기 깊이 검사 규칙")
class IndentDepthRuleTest {

    @Test
    void 들여쓰기_깊이가_제한을_초과하지_않으면_위반을_감지하지_않는다() {
        // given
        String code = """
                public class Test {
                    public void method() {
                        if (true) {
                            System.out.println("Depth 2");
                        }
                    }
                }
                """;
        var rule = new IndentDepthRule(2);

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations).isEmpty();
    }

    @Test
    void 들여쓰기_깊이가_제한을_초과하면_위반을_감지한다() {
        // given
        String code = """
                public class Test {
                    public void method() {
                        if (true) {
                            for (int i = 0; i < 10; i++) {
                                while (true) {
                                    System.out.println("Too deep!");
                                }
                            }
                        }
                    }
                }
                """;
        var rule = new IndentDepthRule(2);

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations)
                .hasSize(2)
                .extracting("message")
                .contains("제어문의 깊이가 허용된 최대 깊이(2)를 초과했습니다: 현재 깊이 3");
    }
}
