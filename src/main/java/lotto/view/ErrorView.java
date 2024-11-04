package lotto.view;
import lotto.exceptions.LottoException;

public class ErrorView {
    public static <T extends LottoException> void displayError(T exception) {
        System.out.println(exception.getErrorMessage());
    }
}
