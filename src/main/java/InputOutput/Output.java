package InputOutput;

public class Output {
    public static void firstMessage(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void calculateNumberOfSheetsFromAmount(int price){
        if (price < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 금액은 1,000원 이상이어야 합니다.");
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원의 배수여야 합니다.");
        }
        int numberOfTickets = price / 1000;
        System.out.println(numberOfTickets + "개를 구매했습니다.");
    }
}
