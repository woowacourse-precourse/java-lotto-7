package architecture.analyzer.test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import architecture.analyzer.main.CodeStyle;
import architecture.analyzer.main.StyleRules;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

@DisplayName("코드 스타일 분석기 통합 테스트")
class CodeStyleIntegrationTest {
    @Test
    void 여러_규칙을_동시에_검사할_수_있다(@TempDir Path tempDir) throws IOException {
        // given
        String code = """
                public class Test {
                    public void complexMethod() {
                        if (true) {
                            for (int i = 0; i < 10; i++) {
                                String result = i > 5 ? "High" : "Low";  // 삼항 연산자 사용
                                while (true) {  // depth: 3
                                    System.out.println(result);
                                }
                            }
                        }
                    }
                }
                """;
        createJavaFile(tempDir, code);

        // when
        var result = CodeStyle.analyze()
                .checkRule(StyleRules.indentDepth(2))
                .checkRule(StyleRules.noTernaryOperator())
                .check(tempDir.toString());

        // then
        String violations = result.toString();
        assertThat(violations)
                .contains("제어문의 깊이가 허용된 최대 깊이(2)를 초과했습니다: 현재 깊이 3")
                .contains("삼항 연산자 사용이 감지되었습니다");
    }

    @Test
    void 위반_사항이_없는_코드를_검사할_수_있다(@TempDir Path tempDir) throws IOException {
        // given
        String code = """
                public class Test {
                    public void cleanMethod() {
                        if (true) {
                            System.out.println("Depth 1");
                        }
                    }
                
                    public String getResult(boolean condition) {
                        if (condition) {
                            return "yes";
                        }
                        return "no";
                    }
                }
                """;
        createJavaFile(tempDir, code);

        // when & then
        CodeStyle.analyze()
                .checkRule(StyleRules.indentDepth(2))
                .checkRule(StyleRules.noTernaryOperator())
                .checkRule(StyleRules.methodSize(15))
                .check(tempDir.toString())
                .assertNoViolations();
    }

    private void createJavaFile(Path directory, String code) throws IOException {
        Path file = directory.resolve("Test.java");
        Files.writeString(file, code);
    }
}
