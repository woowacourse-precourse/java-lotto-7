package lotto.ui;

public class UiInitializer {
    public static InputController initInputController() {
        return new InputController(new ConsoleInputUi());
    }

    public static OutputController initOutputController() {
        return new OutputController(new ConsoleOutputUi());
    }
}
