package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Collections;

public class Application {
	private static final int LOTTO_PRICE = 1000;
	private static final int MAX_NUMBER = 45;
	
    public static void main(String[] args) {
    	while(true)
	    	try {
		    	int amount = getPurchaseAmount();
		    	int lottoCount = amount / LOTTO_PRICE;
	            Lotto[] purchasedLottos = generateLottos(lottoCount);
	            printLottoNumbers(purchasedLottos);
		        break;
	    	} catch (IllegalArgumentException e) {
	    		System.out.println("[ERROR] " + e.getMessage());
	    	}
    }
    
    public static int getPurchaseAmount() {
		while (true) {
            System.out.println("로또 구입 금액을 입력하세요");
            String input = Console.readLine();
            try {
                int amount = Integer.parseInt(input);
                validateAmount(amount);
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력하세요.");
            }
        }
	}
	
	public static void validateAmount(int amount) {
		if (amount <= 0 || amount % LOTTO_PRICE != 0) 
			throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위 입니다.");
	}
	
	public static Lotto[] generateLottos (int count) {
		Lotto[] lottos = new Lotto[count];
		for(int i=0; i<count; i++) {
			lottos[i] = generateLotto();
		}
		return lottos;
	}
	
	public static Lotto generateLotto() {
		List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, MAX_NUMBER, 6);
		return new Lotto(lottoNumbers);
	}
	
	public static void printLottoNumbers(Lotto[] purchasedLottos) {
		System.out.println(purchasedLottos.length + "개를 구매했습니다.");
		for(Lotto lotto : purchasedLottos) 
			printSortedLotto(lotto);  
	}
	
	public static void printSortedLotto(Lotto lotto) {
		List<Integer> sortedLotto = lotto.getNumbers();
		Collections.sort(sortedLotto);
		System.out.println(sortedLotto);
	}
    
    
    
    
    
    
}