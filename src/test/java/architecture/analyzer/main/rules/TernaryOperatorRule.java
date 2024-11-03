package architecture.analyzer.main.rules;

import architecture.analyzer.main.CodeViolation;
import architecture.analyzer.main.utils.LineUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TernaryOperatorRule implements CodeStyleRule {
    private static final Pattern TERNARY_PATTERN = Pattern.compile(".*\\?.*:.*");

    @Override
    public List<CodeViolation> analyze(String fileName, List<String> lines) {
        List<CodeViolation> violations = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (!LineUtils.shouldSkipLine(line) && containsTernaryOperator(line)) {
                violations.add(new CodeViolation(fileName, i + 1, "삼항 연산자 사용이 감지되었습니다"));
            }
        }
        return violations;
    }

    private boolean containsTernaryOperator(String line) {
        return TERNARY_PATTERN.matcher(line.trim()).matches();
    }
}
