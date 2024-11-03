package lotto;
import lotto.Lotto;

public class Application {
    public static void main(String[] args) {
        try{
            Lotto.run();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
