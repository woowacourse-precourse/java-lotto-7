package architecture.analyzer.main.rules;

import architecture.analyzer.main.CodeViolation;
import architecture.analyzer.main.utils.LineUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TernaryOperatorRule implements CodeStyleRule {
    private static final Pattern GENERIC_WILDCARD_PATTERN =
            Pattern.compile(".*<\\s*\\?\\s*(extends|super)\\s+[^>]+>.*");

    private static final Pattern TERNARY_PATTERN =
            Pattern.compile(".*[^<]\\s*\\?\\s*[^>\\s][^:]*:\\s*[^>\\s].*");

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
        line = line.trim();
        // 제네릭 와일드카드인 경우 false 반환
        if (GENERIC_WILDCARD_PATTERN.matcher(line).matches()) {
            return false;
        }
        // 삼항 연산자 패턴 확인
        return TERNARY_PATTERN.matcher(line).matches();
    }
}
