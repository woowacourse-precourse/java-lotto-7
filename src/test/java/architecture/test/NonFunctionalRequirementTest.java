package architecture.test;

import architecture.analyzer.main.CodeStyle;
import architecture.analyzer.main.StyleRules;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class NonFunctionalRequirementTest {
    private static final String BASE_PATH = "./src/main/java/lotto";

    @Test
    void 들여쓰기_깊이는_2를_초과하면_안_된다() throws IOException {
        CodeStyle.analyze()
                .checkRule(StyleRules.indentDepth(2))
                .check(BASE_PATH)
                .assertNoViolations();
    }

    @Test
    void 삼항_연산자를_사용하지_않아야_한다() throws IOException {
        CodeStyle.analyze()
                .checkRule(StyleRules.noTernaryOperator())
                .check(BASE_PATH)
                .assertNoViolations();
    }

    @Test
    void 메서드는_15_줄을_초과하지_않아야_한다() throws IOException {
        CodeStyle.analyze()
                .checkRule(StyleRules.methodSize(15))
                .check(BASE_PATH)
                .assertNoViolations();
    }

    @Test
    void else_구문을_사용하지_않아야_하며_switch_case_역시_허용하지_않는다() throws IOException {
        CodeStyle.analyze()
                .checkRule(StyleRules.noElse())
                .checkRule(StyleRules.noSwitch())
                .check(BASE_PATH)
                .assertNoViolations();
    }
}
