package lotto;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Lotto> lottos;
    private int jackpot;
    private Lotto correctNumbers;

    Customer(){
        lottos = new ArrayList<>();
        jackpot = 0;
    }

    public void addLotto(Lotto lotto){
        this.lottos.add(lotto);
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
