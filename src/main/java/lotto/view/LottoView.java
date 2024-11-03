package lotto.view;

import lotto.properties.LottoMatch;
import lotto.vo.Lotto;
import lotto.dao.LottoDAO;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {

        public int getLottoPurchaseCost (){
            System.out.println("구입금액을 입력해 주세요.");
            int reuslt = 0;
            try{
                reuslt =Integer.parseInt(readLine().trim());
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException("[ERROR] 구입금액을 잘못입력하셨습니다.확인 후 다시 입력해주세요.");
            }
            return  reuslt;
        }


        public void printLotto(LottoDAO lottoDAO){
            System.out.println("");
            System.out.println(lottoDAO.getPurchaseRound()+"개를 구매했습니다.");
            System.out.println("");
            for(Lotto lotto : lottoDAO.getLottoDatabase()){
                System.out.println(lotto.getNumbers());
            }
        }


        public String getLottoSelected(){
            System.out.println("");
            System.out.println("당첨 번호를 입력해 주세요.");
            String value = readLine().trim();
            return value;
        }

        public int getLottoBonus(){
            System.out.println("");
            System.out.println("보너스 번호를 입력해 주세요.");
            int value = Integer.parseInt(readLine().trim());
            return value;
        }


        public void printLottoResult(HashMap<LottoMatch,Integer> match,double rateReturn){
            System.out.println("");
            System.out.println("당첨 통계");
            System.out.println("---");
            List<LottoMatch> LottoResultlist = Arrays.asList(LottoMatch.values());
            Collections.reverse(LottoResultlist);
            for (LottoMatch lottoMatch : LottoResultlist) {
                int count = match.getOrDefault(lottoMatch, 0);
                if(lottoMatch.getMatchCount() == 5 && lottoMatch.getPrize()==30000000){
                    System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", lottoMatch.getMatchCount(), lottoMatch.getPrize(), count);
                    continue;
                }
                System.out.printf("%d개 일치 (%,d원) - %d개\n", lottoMatch.getMatchCount(), lottoMatch.getPrize(), count);
            }
            System.out.printf("총 수익률은 %.1f%%입니다.\n", rateReturn);
        }

}
