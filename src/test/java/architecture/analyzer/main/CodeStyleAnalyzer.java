package architecture.analyzer.main;

import architecture.analyzer.main.rules.CodeStyleRule;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CodeStyleAnalyzer {
    private final List<CodeStyleRule> rules = new ArrayList<>();

    public CodeStyleAnalyzer checkRule(CodeStyleRule rule) {
        rules.add(rule);
        return this;
    }

    public StyleValidationResult check(String directoryPath) throws IOException {
        return new StyleValidationResult(analyzeDirectory(directoryPath));
    }

    public List<CodeViolation> analyzeDirectory(String directoryPath) throws IOException {
        List<CodeViolation> violations = new ArrayList<>();
        List<Path> javaFiles = findJavaFiles(directoryPath);

        for (Path file : javaFiles) {
            violations.addAll(analyzeFile(file));
        }
        return violations;
    }

    private List<Path> findJavaFiles(String directoryPath) throws IOException {
        return Files.walk(Paths.get(directoryPath))
                .filter(path -> path.toString().endsWith(".java"))
                .toList();
    }

    private List<CodeViolation> analyzeFile(Path filePath) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            String fileName = filePath.getFileName().toString();
            return runAllRules(fileName, lines);
        } catch (IOException e) {
            return List.of(new CodeViolation(filePath.toString(), 0,
                    "파일 분석 중 오류 발생: " + e.getMessage()));
        }
    }

    private List<CodeViolation> runAllRules(String fileName, List<String> lines) {
        return rules.stream()
                .flatMap(rule -> rule.analyze(fileName, lines).stream())
                .toList();
    }
}
