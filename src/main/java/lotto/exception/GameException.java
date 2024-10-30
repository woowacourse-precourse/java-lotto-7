package lotto.exception;

public class GameException extends IllegalArgumentException{

    public GameException(String message) {
        super(String.format("[ERROR] %s",message));
    }

}
