package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.*;

public class Application {
    public static void main(String[] args) {
        int lottoTickets = inputPayment();
    }

    public static int inputPayment(){
        System.out.println(PAYMENT_MASSAGE);
        int payment = Integer.parseInt(Console.readLine());
        validatePayment(payment);
        return payment/LOTTOPRICE;
    }

    public static void validatePayment(int payment){
        if(payment % LOTTOPRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
    }
}
