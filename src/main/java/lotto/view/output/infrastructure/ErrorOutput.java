package lotto.view.output.infra;

public class ErrorOutput {
    public static void view(IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }
}
