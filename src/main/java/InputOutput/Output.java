package InputOutput;

public class Output {
    public static void 첫_번째_출력메세지(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void 계산된_금액을_통해_몇_장이_나오는_계산(int price){
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
