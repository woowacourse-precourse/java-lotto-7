package lotto.view;

import java.util.Optional;
import lotto.config.ErrorMessage;

public abstract class View {

    public static void of(Object object, boolean newLine) {
        if (newLine) {
            System.out.println();
        }
        System.out.println(object);
    }

    protected abstract void printMessage();

    protected abstract String doRendering();

    public Optional<String> render() {
        try {
            printMessage();
            return Optional.of(doRendering());
        } catch (Exception e) {
            System.out.println("\n" + ErrorMessage.NOT_VALID_INPUT);
        }

        return Optional.empty();
    }

}
