package architecture.analyzer.main.rules;

import architecture.analyzer.main.CodeViolation;
import java.util.List;

public class NewLineAtEndOfFileRule implements CodeStyleRule {
    @Override
    public List<CodeViolation> analyze(String fileName, List<String> lines) {
        if (lines.isEmpty()) {
            return List.of();
        }

        if (!lines.getLast().isEmpty()) {
            return List.of(new CodeViolation(fileName, lines.size(),
                    "파일의 마지막에 빈 줄이 없습니다."));
        }

        return List.of();
    }
}
