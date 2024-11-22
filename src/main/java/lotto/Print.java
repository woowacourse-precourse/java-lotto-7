package lotto;

import static lotto.Application.correctDetail;

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

    public static void winPrint() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void correct3() {
        System.out.print("3개 일치 (5,000원) - ");
        System.out.println(correctDetail[0]+"개");
    }
    public static void correct4() {
        System.out.print("4개 일치 (50,000원) - ");
        System.out.println(correctDetail[1]+"개");
    }
    public static void correct5() {
        System.out.print("5개 일치 (1,500,000원) - ");
        System.out.println(correctDetail[2]+"개");
    }
    public static void correctBonus() {
        System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        System.out.println(correctDetail[3]+"개");
    }
    public static void correct6() {
        System.out.print("6개 일치 (2,000,000,000원) - ");
        System.out.println(correctDetail[4]+"개");
    }

    public static void totalReward(double num) {
        double result = roundUp(num);
        System.out.println("총 수익률은 " + result + "%입니다.");
    }

    public static double roundUp(double number) {
        return Math.round(number * 100) / 100.0;
    }

}
