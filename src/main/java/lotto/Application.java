package lotto;

import java.util.List;

public class Application {
    private static int money;
    private static List<Lotto> lottos;
    public static void main(String[] args) {

    }

    public static void isInteger(String input) throws Exception{
        try{
            Integer.parseInt(input);
        }catch(Exception e){
            throw new NumberFormatException("정수여야 합니다.");
        }
    }
}
