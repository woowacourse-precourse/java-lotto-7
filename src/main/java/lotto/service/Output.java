package lotto.service;

public class Output {
    public static void buyMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void buyLotto(int n){
        System.out.println(n+"개를 구매했습니다.");
    }

    public static void getWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void getBounsNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void showRanks(String message, int num){
        System.out.println(message+num+"개");
    }

    public static void line(){
        System.out.println("당첨 통계\n" + "---");
    }

    public static void printMoney(double percent){
        String result = "총 수익률은 ";
        result += String.format("%.1f",percent);
        result += "%입니다.";
        System.out.println(result);
    }


}
