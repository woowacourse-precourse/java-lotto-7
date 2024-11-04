package architecture.analyzer.main.rules;

import architecture.analyzer.main.CodeViolation;
import architecture.analyzer.main.utils.LineUtils;
import java.util.ArrayList;
import java.util.List;

public class IndentDepthRule implements CodeStyleRule {
    private final int maxDepth;

    public IndentDepthRule(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    @Override
    public List<CodeViolation> analyze(String fileName, List<String> lines) {
        List<CodeViolation> violations = new ArrayList<>();
        int currentDepth = 0;

        for (int i = 0; i < lines.size(); i++) {
            if (LineUtils.shouldSkipLine(lines.get(i))) {
                continue;
            }

            currentDepth = calculateCurrentDepth(lines.get(i), currentDepth);

            if (currentDepth > maxDepth) {
                violations.add(new CodeViolation(fileName, i + 1,
                        String.format("제어문의 깊이가 허용된 최대 깊이(%d)를 초과했습니다: 현재 깊이 %d",
                                maxDepth, currentDepth)));
            }
        }
        return violations;
    }

    private int calculateCurrentDepth(String line, int currentDepth) {
        String trimmedLine = line.trim();
        if (isBlockEnd(trimmedLine)) {
            return Math.max(0, currentDepth - 1);
        }
        if (isControlStructure(trimmedLine)) {
            return currentDepth + 1;
        }
        return currentDepth;
    }

    private boolean isBlockEnd(String line) {
        return line.startsWith("}");
    }

    private boolean isControlStructure(String line) {
        return line.contains("if ") ||
                line.contains("for ") ||
                line.contains("while ") ||
                line.contains("switch ") ||
                line.contains("try ") ||
                line.startsWith("} else ") ||
                line.startsWith("} catch ");
    }
}
