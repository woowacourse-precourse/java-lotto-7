package architecture.analyzer.main.rules;

import architecture.analyzer.main.CodeViolation;
import java.util.ArrayList;
import java.util.List;

public class NoSwitchRule implements CodeStyleRule {
    @Override
    public List<CodeViolation> analyze(String fileName, List<String> lines) {
        List<CodeViolation> violations = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.startsWith("switch ") || line.contains(" switch ")) {
                violations.add(new CodeViolation(fileName, i + 1,
                        "switch 구문은 사용할 수 없습니다. if 또는 Map을 사용하세요."));
            }
        }

        return violations;
    }
}
