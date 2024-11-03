package architecture.analyzer.test.rules;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import architecture.analyzer.main.CodeViolation;
import architecture.analyzer.main.rules.NewLineAtEndOfFileRule;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("파일 끝 빈 줄 검사 규칙")
class NewLineAtEndOfFileRuleTest {

    @Test
    void 파일_끝에_빈_줄이_있으면_위반을_감지하지_않는다() {
        // given
        String code = """
                public class Test {
                }
                
                """;
        var rule = new NewLineAtEndOfFileRule();

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations).isEmpty();
    }

    @Test
    void 파일_끝에_빈_줄이_없으면_위반을_감지한다() {
        // given
        String code = """
                public class Test {
                }""";
        var rule = new NewLineAtEndOfFileRule();

        // when
        List<CodeViolation> violations = rule.analyze("Test.java", code.lines().toList());

        // then
        assertThat(violations)
                .hasSize(1)
                .extracting("message")
                .contains("파일의 마지막에 빈 줄이 없습니다.");
    }
}
