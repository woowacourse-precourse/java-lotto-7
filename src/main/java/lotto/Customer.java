package lotto;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Lotto> lottos;
    private long jackpot;
    private Lotto correctNumbers;
    private int bonusNumber;
    private ArrayList<Integer> jackpotArray;

    Customer(){
        lottos = new ArrayList<>();
        jackpot = 0;
        jackpotArray = new ArrayList<>(8);
        for(int i=0; i<8; i++)
            jackpotArray.add(0);
    }

    public void addLotto(Lotto lotto){
        this.lottos.add(lotto);
    }
    public void setCorrectNumbers(Lotto correctNumbers, int bonusNumber){
        this.correctNumbers = correctNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void checkJackpot(){
        for(Lotto tmp : lottos){
            calculate(tmp);
        }
        // 여기에 총상금 계산및 출력하기
        calculateJackpot();
    }

    public void calculate(Lotto lotto){
        int count = 0;
        boolean bonus = false;
        for(int i: lotto.getNumbers()){
            if(numberInCorrect(i))
                count += 1;
            if(i == bonusNumber)
                bonus = true;
        }
        addJackpotArray(count, bonus);
    }

    private boolean numberInCorrect(int num){
        for(int i : correctNumbers.getNumbers())
        {
            if (num == i)
                return true;
        }
        return false;
    }

    private void addJackpotArray(int count, boolean bonus){
        if(count == 5 && bonus==true){
            jackpotArray.set(7, jackpotArray.get(7)+1);
        }
        if(count < 3)
            return;
        jackpotArray.set(count, jackpotArray.get(count)+1);
    }

    private void calculateJackpot(){
        this.jackpot = jackpotArray.get(3)*5000
                +jackpotArray.get(4)*50000
                +jackpotArray.get(5)*1500000
                +jackpotArray.get(6)*2000000000
                +jackpotArray.get(7)*30000000;
    }
    public void printCustomerLotto(){
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for(int i=0; i<lottos.size(); i++){
            for(int t=0; t<6; t++){
                System.out.print(lottos.get(i).getNumbers().get(t) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printJackpotList(){
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + jackpotArray.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + jackpotArray.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + jackpotArray.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + jackpotArray.get(7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + jackpotArray.get(6) + "개");
        System.out.println("총 수익률은 " + this.jackpot/(lottos.size()*10) + "%입니다");
    }
}
