package InputOutput;

import java.util.List;

public class OutputView {
    public static void firstMessage(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static int calculateNumberOfSheetsFromAmount(int price){
        if (price < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 금액은 1,000원 이상이어야 합니다.");
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원의 배수여야 합니다.");
        }
        int numberOfTickets = price / 1000;
        return numberOfTickets;
    }
    public static void printLottoTickets(List<List<Integer>> lottoTickets) {
        System.out.println("");
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (List<Integer> ticket : lottoTickets) {
            System.out.println(ticket); // 각 로또 티켓의 번호 출력
        }
    }
}
