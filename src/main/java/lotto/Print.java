package lotto;

public class Print {

    public static void pricePrint() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void purchasePrint(int num) {
        System.out.println(num+"개를 구매했습니다.");
    }

    public static void numberPrint() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusPrint() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void lottoPrint(Lotto lotto) {
        System.out.print("[");
        for (int j=0;j<5;j++) {
            System.out.print(lotto.getNumbers().get(j)+", ");
        }
        System.out.println(lotto.getNumbers().get(5)+"]");
    }

}
