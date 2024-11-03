package architecture.analyzer.main.rules;

import architecture.analyzer.main.CodeViolation;
import java.util.List;

public interface CodeStyleRule {
    List<CodeViolation> analyze(String fileName, List<String> lines);
}
