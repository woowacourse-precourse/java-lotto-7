package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    private static int money;
    private static List<Lotto> lottos;
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        while(true){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                money = getMoneyInput();
                break;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static int getMoneyInput() throws Exception{
        String input = Console.readLine();
        validateMoney(input);
        return Integer.parseInt(input);
    }

    public static void validateMoney(String input) throws Exception{
        isInteger(input);
        isMultipleOf1000(Integer.parseInt(input));
    }

    public static void isMultipleOf1000(int inputInt) throws Exception{
        if(inputInt%1000 != 0){
            throw new IllegalArgumentException("1000으로 나누어 떨어져야 합니다.");
        }
    }

    public static void isInteger(String input) throws Exception{
        try{
            Integer.parseInt(input);
        }catch(Exception e){
            throw new NumberFormatException("정수여야 합니다.");
        }
    }
}
