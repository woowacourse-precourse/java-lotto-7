package architecture.analyzer.main;

import architecture.analyzer.main.rules.IndentDepthRule;
import architecture.analyzer.main.rules.MethodSizeRule;
import architecture.analyzer.main.rules.NewLineAtEndOfFileRule;
import architecture.analyzer.main.rules.NoElseRule;
import architecture.analyzer.main.rules.NoSwitchRule;
import architecture.analyzer.main.rules.TernaryOperatorRule;

public class StyleRules {
    public static IndentDepthRule indentDepth(int maxDepth) {
        return new IndentDepthRule(maxDepth);
    }

    public static TernaryOperatorRule noTernaryOperator() {
        return new TernaryOperatorRule();
    }

    public static MethodSizeRule methodSize(int maxLines) {
        return new MethodSizeRule(maxLines);
    }

    public static NewLineAtEndOfFileRule requireEmptyLineAtEnd() {
        return new NewLineAtEndOfFileRule();
    }

    public static NoElseRule noElse() {
        return new NoElseRule();
    }

    public static NoSwitchRule noSwitch() {
        return new NoSwitchRule();
    }
}
