package architecture.analyzer.test.rules;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import architecture.analyzer.main.CodeViolation;
import architecture.analyzer.main.rules.MethodSizeRule;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("메서드 길이 검사 규칙")
class MethodSizeRuleTest {

    @Test
    void 메서드_길이가_제한을_초과하지_않으면_위반을_감지하지_않는다() {
        // given
        StringBuilder code = new StringBuilder("public class Test {\n");
        code.append("    public void shortMethod() {\n");
        // 15줄의 코드 생성
        for (int i = 0; i < 15; i++) {
            code.append("        System.out.println(\"line ").append(i).append("\");\n");
        }
        code.append("    }\n");
        code.append("}\n");

        var rule = new MethodSizeRule(15);

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.toString().lines().toList());

        // then
        assertThat(violations).isEmpty();
    }

    @Test
    void 메서드_길이가_제한을_초과하면_위반을_감지한다() {
        // given
        StringBuilder code = new StringBuilder("public class Test {\n");
        code.append("    public void longMethod() {\n");
        // 16줄의 코드 생성
        for (int i = 0; i < 16; i++) {
            code.append("        System.out.println(\"line ").append(i).append("\");\n");
        }
        code.append("    }\n");
        code.append("}\n");

        var rule = new MethodSizeRule(15);

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.toString().lines().toList());

        // then
        assertThat(violations)
                .hasSize(1)
                .extracting("message")
                .contains("메서드가 너무 깁니다 (16줄). 최대 허용 길이: 15줄");
    }

    @Test
    void 주석과_빈_줄은_메서드_길이_계산에서_제외한다() {
        // given
        String code = """
                public class Test {
                    public void methodWithComments() {
                        // 주석1
                        System.out.println("line 1");
                
                        /* 주석2 */
                        System.out.println("line 2");
                
                        /**
                         * 문서화 주석
                         */
                        System.out.println("line 3");
                    }
                }
                """;
        var rule = new MethodSizeRule(3);

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations).isEmpty();
    }
}
