package lotto;

import java.util.List;

public class Output {

    private List<Lotto> purchasedLottos;
    private int purchasedAmount;

    public Output() {

    }

    public void setPurchasedLottos(List<Lotto> inputData) {
        this.purchasedLottos=inputData;
    }

    public void setPurchasedAmount(int purchasedAmount) {
        this.purchasedAmount=purchasedAmount;
    }

    public void printPurchasedLottos(){

        int totalLotto=purchasedAmount/1000;
        System.out.println(totalLotto +"개를 구매했습니다");
        for( Lotto lotto : purchasedLottos) {
            System.out.print("[");
            List<Integer> lottoNumbers=lotto.getNumbers();
            printLottoNum(lottoNumbers);
            System.out.print("]\n");
        }

    }

    public  void printLottoNum(List<Integer> lottoNumbers) {

        for(int i=0;i<lottoNumbers.size();i++) {

            if(i==lottoNumbers.size()-1) {
                System.out.print(lottoNumbers.get(i));
                break;
            }

            System.out.print(lottoNumbers.get(i) + ", ");
        }
    }




}
