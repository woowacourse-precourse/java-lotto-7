package lotto;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        int attempts= validateBetAmount()/1000;

    }

    private static int validateBetAmount(){
        String input = Console.readLine();
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        int betAmount = Integer.parseInt(input);
        if(betAmount<1000){
            throw new IllegalArgumentException("베팅 금액이 1000원 미만입니다");
        }
        if(betAmount%1000!=0) {
            throw new IllegalArgumentException("베팅 금액이 1000원 단위가 아닙니다");
        }
        return betAmount;
    }
}
