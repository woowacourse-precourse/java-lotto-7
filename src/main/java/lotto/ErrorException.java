package lotto;

public class ErrorException {
    public static void runError(String errorMessage){
        System.out.println("[ERROR] "+errorMessage);
        throw new IllegalArgumentException("errorMessage");
    }
}
