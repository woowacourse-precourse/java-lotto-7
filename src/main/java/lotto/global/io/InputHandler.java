package lotto.global.io;

public class InputHandler {

    public <T> T execute(InputCallback<T> callback) {
        while(true){
            try {
                return callback.call();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
