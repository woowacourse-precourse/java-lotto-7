package lotto;

import static lotto.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.ErrorMessage.INVALID_PRICE;
import static lotto.ErrorMessage.NON_NUMERIC_INPUT;
import static lotto.ErrorMessage.NUMBER_OUT_OF_RANGE;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private String input;
    public int divideByThousand(String input) {
        try{
            isNumeric(input);
            checkAmountWithinRange(input);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("다시 입력해 주세요.");
            return divideByThousand(Console.readLine());
        }
        this.input = input;
        return Integer.parseInt(input) / 1000;
    }

    public void isNumeric(String input){
        if(!input.matches("[0-9]+$")){
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.format());
        }
    }

    public void checkAmountWithinRange(String input){
        if (Integer.parseInt(input) % 1000 != 0){
            throw new IllegalArgumentException(INVALID_PRICE.format());
        }
    }

    public String requestPurchaseAmountInput(){
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    public ArrayList<List<Integer>> generateLottoNumbers(int times){
        System.out.println(times + "개를 구매했습니다.");
        ArrayList<List<Integer>> purchasedLottoNumbers = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            List<Integer> purchasedLottoNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
            Collections.sort(purchasedLottoNumber);
            purchasedLottoNumbers.add(purchasedLottoNumber);
        }
        printLottoNumbers(purchasedLottoNumbers);
        return purchasedLottoNumbers;
    }
    public void printLottoNumbers(ArrayList<List<Integer>> purchasedLottoNumbers){
        for (List<Integer> purchasedLottoNumber : purchasedLottoNumbers) {
            System.out.println(purchasedLottoNumber);
        }
    }
    public String requestLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String [] splitNumbers(String input){
        return input.split(",");
    }

    public Lotto generateLotto(String input){
        Lotto lotto;
        List<Integer> numbers = new ArrayList<>();
        try{
            for(String i : splitNumbers(input)){
                isNumeric(i);
                isNumberBetween1And45(Integer.parseInt(i));
                numbers.add(Integer.parseInt(i));
            }
            lotto = new Lotto(numbers);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("다시 입력해 주세요.");
            return generateLotto(Console.readLine());
        }
        return lotto;
    }

    public String requestBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void isNumberBetween1And45(int bonusNumber){
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.format());
        }
    }
    public void checkForDuplicates(List<Integer> numbers, int bonusNumber){
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.format());
        }
    }

    public int generateBonusNumber(Lotto lotto, String bonusNumber){
        try {
            isNumeric(bonusNumber);
            isNumberBetween1And45(Integer.parseInt(bonusNumber));
            checkForDuplicates(lotto.getNumbers(), Integer.parseInt(bonusNumber));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("다시 입력해 주세요.");
            return generateBonusNumber(lotto, Console.readLine());
        }
        return Integer.parseInt(bonusNumber);
    }

    public int[] calculateLottoRank(ArrayList<List<Integer>> purchasedLottoNumbers){
        Lotto lotto = generateLotto(requestLotto());
        int bounsNumber = generateBonusNumber(lotto, requestBonusNumber());
        int [] rank = {0,0,0,0,0};
        for (int i = 0; i < purchasedLottoNumbers.size(); i++) {
            int count = 0;
            for (int j = 0; j < 6; j++) {
                if(lotto.getNumbers().contains(purchasedLottoNumbers.get(i).get(j))){
                    count++;
                }
            }
            if(count == 3){
                rank[0] += 1;
            }
            if (count == 4){
                rank[1] += 1;
            }
            if (count == 5){
                if(purchasedLottoNumbers.get(i).contains(bounsNumber)){
                    rank[3] += 1;
                }
                else{
                    rank[2] += 1;
                }
            }
            if (count ==6){
                rank[4] += 1;
            }
        }return rank;

    }

    public void printResult(int [] rank){
        System.out.println("3개 일치 (5,000원) - " + rank[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + rank[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rank[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rank[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rank[4] + "개");

        int total = rank[0] * 5000 + rank[1] * 50000 + rank[2] * 1500000 + rank[3] * 30000000 + rank[4] * 2000000000;
        double totalRate = (double) total / Integer.parseInt(input) * 100;
        totalRate = Math.round(totalRate * 10) / 10.0;

        System.out.printf("총 수익률은 %.1f%%입니다.%n", totalRate);
    }


    public static void main(String[] args) {
        Application application = new Application();
        application.printResult(application.calculateLottoRank(application.generateLottoNumbers(application.divideByThousand(application.requestPurchaseAmountInput()))));
    }
}
