package architecture.analyzer.main.rules;

import architecture.analyzer.main.CodeViolation;
import architecture.analyzer.main.utils.LineUtils;
import java.util.ArrayList;
import java.util.List;

public class MethodSizeRule implements CodeStyleRule {
    private final int maxLines;

    public MethodSizeRule(int maxLines) {
        this.maxLines = maxLines;
    }

    @Override
    public List<CodeViolation> analyze(String fileName, List<String> lines) {
        List<CodeViolation> violations = new ArrayList<>();
        MethodAnalyzer analyzer = new MethodAnalyzer(maxLines);

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            analyzer.analyzeLine(line, i);

            if (analyzer.isMethodTooLong()) {
                violations.add(new CodeViolation(fileName, analyzer.getMethodStartLine(),
                        String.format("메서드가 너무 깁니다 (%d줄). 최대 허용 길이: %d줄",
                                analyzer.getMethodLineCount(), maxLines)));
                analyzer.reset();
            }
        }
        return violations;
    }

    public static class MethodAnalyzer {
        private boolean inMethod = false;
        private int methodStartLine = 0;
        private int methodLineCount = 0;
        private final int maxLines;

        public MethodAnalyzer(int maxLines) {
            this.maxLines = maxLines;
        }

        public void analyzeLine(String line, int lineNumber) {
            if (LineUtils.isMethodStart(line)) {
                startNewMethod(lineNumber);
            } else if (inMethod) {
                processMethodLine(line);
            }
        }

        private void startNewMethod(int lineNumber) {
            inMethod = true;
            methodStartLine = lineNumber + 1;
            methodLineCount = 0;
        }

        private void processMethodLine(String line) {
            if (line.startsWith("}")) {
                inMethod = false;
            } else if (!LineUtils.shouldSkipLine(line)) {
                methodLineCount++;
            }
        }

        public boolean isMethodTooLong() {
            return !inMethod && methodLineCount > maxLines;
        }

        public void reset() {
            inMethod = false;
            methodLineCount = 0;
        }

        public int getMethodStartLine() {
            return methodStartLine;
        }

        public int getMethodLineCount() {
            return methodLineCount;
        }
    }
}
