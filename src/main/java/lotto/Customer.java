package lotto;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Lotto> lottos;
    private int jackpot;
    private Lotto correctNumbers;
    private int bonusNumber;
    private ArrayList<Integer> jackpotArray;

    Customer(){
        lottos = new ArrayList<>();
        jackpot = 0;
        jackpotArray = new ArrayList<>(8);
    }

    public void addLotto(Lotto lotto){
        this.lottos.add(lotto);
    }
    public void setCorrectNumbers(Lotto correctNumbers, int bonusNumber){
        this.correctNumbers = correctNumbers;
        this.bonusNumber = bonusNumber;
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
        // 여기에 총상금 계산및 출력하기
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
}
