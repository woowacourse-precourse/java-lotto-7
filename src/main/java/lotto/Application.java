package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price=0;
        while(price<=0) {
            System.out.println("구입 금액을 입력해 주세요.");
            String priceInput = Console.readLine();

            try {
                price=getPrice(priceInput);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }
        System.out.println();

        //가격 정상 입력 테스트용
       // System.out.println("price: "+price);

        int amount=price/1000;
        ArrayList<Lotto> lottos=new ArrayList<>();
        for(int i=0;i<amount;i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            try {
                Collections.sort(numbers);
            }catch (UnsupportedOperationException e){

            }
            lottos.add(new Lotto(numbers));
        }

        System.out.println(amount+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();

        Lotto goldenNumbers=null;
        while (goldenNumbers==null) {

            System.out.println("당첨 번호를 입력해 주세요.");
            String numbersInput = Console.readLine();

            List<Integer> numbers = null;
            try {
                numbers = getNumbers(numbersInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            try {
                goldenNumbers = new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();

        //당첨번호 테스트용 코드
        //System.out.println("golden Numbers: "+goldenNumbers.getNumbers());

        int bonus=0;
        while (bonus<1 || bonus>46) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusInput = Console.readLine();
            try {
                bonus = getBonus(bonusInput);
                checkBonus(bonus, goldenNumbers);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        //보너스 테스트용 코드
        //System.out.println("bonus: "+bonus);

        Level[] levels=Level.values();
        for (Lotto lotto:lottos) {
            checkWinning(lotto,goldenNumbers,bonus,levels);
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.format("3개 일치 (5,000원) - %d개\n",levels[4].getCount());
        System.out.format("4개 일치 (50,000원) - %d개\n",levels[3].getCount());
        System.out.format("5개 일치 (1,500,000원) - %d개\n",levels[2].getCount());
        System.out.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",levels[1].getCount());
        System.out.format("6개 일치 (2,000,000,000원) - %d개\n",levels[0].getCount());

        int total=0;
        for (Level level : levels) {
            total+=level.apply();
        }

        double winRate=(total/(double)price)*100;

        System.out.format("총 수익률은 %.1f%%입니다.",winRate);


    }

    public static void checkWinning(Lotto lotto, Lotto golden, int bonus,Level[] level){
        int count=0;
        boolean hasBonus=false;
        for (int num : golden.getNumbers()) {
            if(lotto.getNumbers().contains(num)){
                count++;
            }

            if(num==bonus){
                hasBonus=true;
            }
        }

        updateLevel(count, hasBonus, level);

    }

    public static void updateLevel(int count, boolean hasBonus,Level[] level){
        if(count==6){
            level[0].check();
            return;
        }

        if(count==5 && hasBonus){
            level[1].check();
            return;
        }

        if(count<=5 && count>=3){
            level[7-count].check();
        }
    }

    public static int getBonus(String bonusInput) throws IllegalArgumentException{
        int bonus=0;

        try{
            bonus=Integer.parseInt(bonusInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이 정수여야 합니다.");
        }

        if(bonus<1 || bonus>45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이 정수여야 합니다.");
        }
        return bonus;

    }

    public static void checkBonus(int bonus, Lotto golden) throws IllegalArgumentException{
        for (Integer i : golden.getNumbers()) {
            if(bonus==i){
              throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호는 중복될 수 없습니다.");
            }
        }
    }

    public static int getPrice(String priceInput) throws IllegalArgumentException{
        int price=0;
        String ERRORMESSAGE="[ERROR] 가격은 양의 정수이고 1000으로 나눠떨어져야 합니다.";

        try{
            price=Integer.parseInt(priceInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        if(price<=0 || price%1000!=0) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }


        return price;
    }

    public static List<Integer> getNumbers(String numbersInput) throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();
        for (String s : numbersInput.split(",")) {
            int number = 0;

            try {
                number = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이 정수만 써주십시오.");
            }

            if (number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 1~45 사이 정수만 써주십시오.");

            numbers.add(number);
        }
        Collections.sort(numbers);
        return numbers;
    }
}
