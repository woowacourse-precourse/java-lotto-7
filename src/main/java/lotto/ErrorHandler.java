package lotto;

public class ErrorHandler {
    public static void continueNotToCatchError(Runnable method){
        try{
            method.run();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            continueNotToCatchError(method);
        }
    }
}
