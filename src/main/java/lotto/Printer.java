package lotto;

public class Printer {
    public Printer() {
    }

    public void printBudgetNotice(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoNumbers(int num){
        System.out.println(num+"개를 구매했습니다.");
    }

    public void printWinNumbersNotice() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public void printBonusNumberNotice() {
        System.out.println("보너스 번호를 입력해주세요.");
    }
}
