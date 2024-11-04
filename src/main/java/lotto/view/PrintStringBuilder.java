package lotto.view;

import java.util.Arrays;

public class PrintStringBuilder {
    private final StringBuilder stringBuilder = new StringBuilder();

    public void appendLine(String line) {
        stringBuilder.append(line).append('\n');
    }

    public void appendLines(String... lines) {
        Arrays.stream(lines).forEach(this::appendLine);
    }

    public void print() {
        System.out.println(stringBuilder);
    }
}
