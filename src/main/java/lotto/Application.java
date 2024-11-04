package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseMoney;
        while(true){
            System.out.println("구입 금액을 입력해 주세요.");
            try{
                purchaseMoney = strToInt(Console.readLine());
                validateMoney(purchaseMoney);
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        List<Lotto> lottoList = buyLotto(purchaseMoney);
        List<Integer> bonusNumbers = new ArrayList<Integer>();
        for(Lotto lotto : lottoList){
            int bonusNumber = createBonusNumber(lotto);
            bonusNumbers.add(bonusNumber);
        }

        Lotto winningNumber;
        while(true){
            System.out.println("당첨 번호를 입력해 주세요.");
            try{
                winningNumber = inputWinningNumber(Console.readLine().split(",",-1));
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        int bonusNumber;
        while (true){
            System.out.println("보너스 번호를 입력해 주세요.");
            try{
                bonusNumber = strToInt(Console.readLine());
                validateNumber(bonusNumber);
                duplicateBonusNumberCheck(winningNumber,bonusNumber);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        matchLotto(lottoList,bonusNumbers,winningNumber,bonusNumber);

        System.out.println("당첨 통계\n---");
        for(LottoResult result : LottoResult.values()){
            System.out.print(result.getMatchCount() + "개 일치");
            if(result.getMatchBonusNumber()){ System.out.print(", 보너스 볼 일치"); }
            System.out.print(" (" + String.format("%,d",result.getPrizeMoney()) + "원) - ");
            System.out.println(result.getPrizeCount() + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.2f",LottoResult.returnRate(purchaseMoney)) + "%입니다.");
    }

    public static int strToInt(String str){
        try{
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 숫자를 입력해주세요.");
        }
    }
    public static void validateMoney(int money){
        if(money < 0 || money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 입력 가능합니다.");
        }
    }
    public static void validateNumber(int num){
        if(num < 1 || num > 45){
            throw new IllegalArgumentException("[ERROR] 1부터45까지의 숫자만 입력 가능합니다.");
        }
    }
    public static List<Lotto> buyLotto(int money){
        int lottoCount = money/1000;
        List<Lotto> lottoList = new ArrayList<Lotto>();

        System.out.println(lottoCount + "개를 구매했습니다.");
        for(int i=0;i<lottoCount;i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto.getNumbers());
            lottoList.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        return lottoList;
    }
    public static int createBonusNumber(Lotto lotto){
        int bonusNum;
        Set<Integer> duplicateCheck = new HashSet<Integer>(lotto.getNumbers());
        do{
            List<Integer> bonus = Randoms.pickUniqueNumbersInRange(1, 45, 1);
            bonusNum = bonus.get(0);
        }while(duplicateCheck.contains(bonusNum));
        return bonusNum;
    }
    public static Lotto inputWinningNumber(String[] numbers){
        List<Integer> winningNumbers = new ArrayList<Integer>();
        for(String number : numbers){
            int num = strToInt(number);
            validateNumber(num);
            winningNumbers.add(num);
        }
        return new Lotto(winningNumbers);
    }
    public static void duplicateBonusNumberCheck(Lotto winningNumber, int bonusNumber){
        for(int number : winningNumber.getNumbers()){
            if(number == bonusNumber){
                throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨번호와 중복됩니다.");
            }
        }
    }
    public static void matchLotto(List<Lotto> lottoList,List<Integer> bonusNumbers,Lotto winningNumber,int bonusNumber){
        for(int i=0;i<lottoList.size();i++){
            lottoList.get(i).getNumbers().retainAll(winningNumber.getNumbers());
            List<Integer> matchNumber = lottoList.get(i).getNumbers();
            if(matchNumber.size() == 3) LottoResult.FIFTH_PRIZE.increaseCount();
            if(matchNumber.size() == 4) LottoResult.FOURTH_PRIZE.increaseCount();
            if(matchNumber.size() == 5 && bonusNumbers.get(i) != bonusNumber) LottoResult.THIRD_PRIZE.increaseCount();
            if(matchNumber.size() == 5 && bonusNumbers.get(i) == bonusNumber) LottoResult.SECOND_PRIZE.increaseCount();
            if(matchNumber.size() == 6) LottoResult.FIRST_PRIZE.increaseCount();
        }
    }
}