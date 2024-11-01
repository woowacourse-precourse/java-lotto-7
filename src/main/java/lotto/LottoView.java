package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {

        public int getLottoPurchaseCost (){
            System.out.println("구입금액을 입력해 주세요.");
            int reuslt =Integer.parseInt(readLine());
            return  reuslt;
        }


        public void printLotto(LottoDAO lottoDAO){
            System.out.println("");
            System.out.println(lottoDAO.getPurchaseRound()+"개를 구매했습니다.");
            for(Lotto lotto : lottoDAO.getLottoDatabase()){
                System.out.println(lotto.getNumbers());
            }
        }


        public String getLottoSelected(){
            System.out.println("");
            System.out.println("당첨 번호를 입력해 주세요.");
            String value = readLine();
            return value;
        }

        public int getLottoBonus(){
            System.out.println("");
            System.out.println("보너스 번호를 입력해 주세요.");
            int value = Integer.parseInt(readLine());
            return value;
        }

}
