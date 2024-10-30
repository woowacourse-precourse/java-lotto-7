package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchasePrice;
        String inputPurchasePrice;
        while(true){
            System.out.println("구입금액을 입력해 주세요.");
            try{
                inputPurchasePrice = Console.readLine();
                if (inputPurchasePrice.isBlank()){
                    throw new IllegalArgumentException("[ERROR] 구매금액은 공백일 수 없습니다.");
                }
                try {
                    purchasePrice = Integer.parseInt(inputPurchasePrice);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("[ERROR] 구매금액은 정수여야합니다.");
                }
                if (purchasePrice % 1000 != 0)
                    throw new IllegalArgumentException("[ERROR] 구매금액은 1000원단위여야합니다.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        int lottoCount = purchasePrice / 1000;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(lottoNums));
        }
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            System.out.println(lottoList.get(i));
        }

        List<Integer> winningNumbers = new ArrayList<>();
        while(true){
            System.out.println();
            System.out.println("당첨 번호를 입력해 주세요.");
            try{
                winningNumbers.clear();
                String inputWinningNumbers = Console.readLine();
                if (inputWinningNumbers.isBlank())
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 공백일 수 없습니다.");
                try {
                    String[] splitNumbers = inputWinningNumbers.split(",");
                    for (int i = 0; i < splitNumbers.length; i++) {
                        if (splitNumbers[i].isBlank()) throw new IllegalArgumentException("[ERROR] 당첨 번호는 공백일 수 없습니다.");
                        int winningNumber = Integer.parseInt(splitNumbers[i]);
                        if (winningNumber < 1 || winningNumber > 45)
                            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이 숫자여야합니다.");
                        winningNumbers.add(winningNumber);
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("[ERROR] 구매금액은 정수여야합니다.");
                }
                if (winningNumbers.size() != 6) throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 입력해야합니다.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        int bonusNumber;
        while(true){
            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            try{
                String inputBonusNumber = Console.readLine();
                if (inputBonusNumber.isBlank())
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 공백일 수 없습니다.");
                try {
                    bonusNumber = Integer.parseInt(inputBonusNumber);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야합니다.");
                }
                if (bonusNumber < 1 || bonusNumber > 45)
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이 숫자여야합니다.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        int threeMatchCount = 0;
        int fourMatchCount = 0;
        int fiveMatchCount = 0;
        int fiveAndBonusMatchCount = 0;
        int sixMatchCount = 0;
        for(int i=0;i<lottoCount;i++){
            Lotto lotto = lottoList.get(i);
            List<Integer> lottoNumbers = lotto.getNumbers();
            int winningNumberMatchCount = 0;
            int bonusNumberMatchCount = 0;
            for(int j=0;j<6;j++){
                if(winningNumbers.contains(lottoNumbers.get(j))) winningNumberMatchCount++;
                if(bonusNumber==lottoNumbers.get(j)) bonusNumberMatchCount++;
            }
            if(winningNumberMatchCount==3) threeMatchCount++;
            if(winningNumberMatchCount==4) threeMatchCount++;
            if(winningNumberMatchCount==5 && bonusNumberMatchCount==1) fiveAndBonusMatchCount++;
            if(winningNumberMatchCount==5 && bonusNumberMatchCount==0) fiveMatchCount++;
            if(winningNumberMatchCount==6) sixMatchCount++;
        }
        int rewordAmount = threeMatchCount * 5000 + fourMatchCount * 50000 + fiveMatchCount * 1500000 + fiveAndBonusMatchCount * 30000000 + sixMatchCount * 2000000000;
        double profitRate = Math.round((rewordAmount / purchasePrice) * 100) / 100.0;
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+threeMatchCount+"개");
        System.out.println("4개 일치 (50,000원) - "+fourMatchCount+"개");
        System.out.println("5개 일치 (1,500,000원) - "+fiveMatchCount+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+fiveAndBonusMatchCount+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+sixMatchCount+"개");
        System.out.println("총 수익률은 "+profitRate+"%입니다.");
    }
}
