package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        int tickets = PurchaseTickets();
    }
    //로또 구매
    private static int PurchaseTickets(){
        System.out.println("구입 금액을 입력해 주세요.");
        int tickets = Integer.parseInt(Console.readLine());
        if(tickets % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구매해야 합니다.");
        }
        return tickets/1000;
    }
}
