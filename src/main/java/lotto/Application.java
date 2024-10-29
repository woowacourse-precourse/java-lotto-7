package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public int divideByThousand(String input) {
        return Integer.parseInt(input) / 1000; // 유효한 입력일 경우
    }

    public void isNumeric(String input){
        if(!input.matches("[0-9]+$")){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }
    public void checkAmountWithinRange(String input){

    }


    public static void main(String[] args) {
        Application application = new Application();
        application.divideByThousand(Console.readLine());
    }
}
