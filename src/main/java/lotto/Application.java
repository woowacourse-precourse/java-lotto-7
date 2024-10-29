package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public int divideByThousand(String input) {
        return Integer.parseInt(input) / 1000; // 유효한 입력일 경우
    }

    public void isNumeric(String input){

    }
    public void checkAmountWithinRange(String input){

    }


    public static void main(String[] args) {
        Application application = new Application();
        application.divideByThousand(Console.readLine());
    }
}
