package lotto.exception;

public class GameException extends IllegalArgumentException{

    public GameException(ErrorMessage message) {
        super(String.format("[ERROR] %s",message.getText()));
    }

}
