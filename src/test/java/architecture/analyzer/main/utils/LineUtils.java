package architecture.analyzer.main.utils;

public class LineUtils {
    public static boolean shouldSkipLine(String line) {
        String trimmedLine = line.trim();
        return trimmedLine.isEmpty() || isComment(trimmedLine);
    }

    public static boolean isComment(String line) {
        return line.startsWith("//") ||
                line.startsWith("/*") ||
                line.startsWith("*");
    }

    public static boolean isMethodStart(String line) {
        return (containsAccessModifier(line) && line.contains("(") && line.endsWith("{"));
    }

    public static boolean containsAccessModifier(String line) {
        return line.contains("public") ||
                line.contains("private") ||
                line.contains("protected");
    }
}
