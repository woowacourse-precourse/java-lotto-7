package lotto.view;

public interface ViewManager {

    default void lineBreak() {
        System.out.println();
    }

    default void printMessage(final String message) {
        System.out.println(message);
    }
}
