package lotto.view;
import lotto.exceptions.LottoException;

public class ErrorView {
    private static final String ERROR_FLAG = "[ERROR]";

    public static <T extends LottoException> void displayError(T exception) {
        System.out.println(ERROR_FLAG + " " + exception.getErrorMessage());
    }
}
