package lotto;
import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

public class Application {
    public static void main(String[] args) {
        try{
            Lotto.run();
        } catch(IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
