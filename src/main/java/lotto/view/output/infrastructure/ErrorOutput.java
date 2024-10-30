package lotto.view.output.infrastructure;

public class ErrorOutput {
    public static void view(IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }
}
