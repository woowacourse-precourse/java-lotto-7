package lotto;

public class Application {
    public static void main(String[] args) {
        Validation validation = new Validation();
        InputManager inputManager = new InputManager();
        LottoService service = new LottoService(validation, inputManager);
        service.run();
    }
}
