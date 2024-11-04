package lotto.view;

import lotto.model.WinLotto;

public class UserResponseView {

    public static void startMessage(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void countLottoMessage(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void winLottoMessage(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusLottoMessage(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void lottoMessage(WinLotto[] winLotto){
        System.out.println("당첨 통계");
        System.out.println("---");
        for(WinLotto win : winLotto){
            System.out.print(win.getCnt()+"개 일치 ");
            if(win.name().equals("WIN_FIVE_AND_BONUS")){
                System.out.print(", 보너스 볼 일치 ");
            }
            System.out.println("("+win.getPrizeMoney()+")"+" - "+win.getWin()+"개");
        }
    }

    public static void revenueMessage(double revenue){
        System.out.println("총 수익률은 "+revenue+"%입니다.");
    }

    public static void errorMessage(String detailErrorMessage){
        throw new IllegalArgumentException("[ERROR] "+ detailErrorMessage);
    }

}
