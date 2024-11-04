package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;

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
	            Set<Integer> winningNumbers = getWinningNumbers();
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
	
	public static Set<Integer> getWinningNumbers() {
		while (true) {
            System.out.println("당첨 번호를 입력해 주세요");
            String input = Console.readLine();
            try {
                return readLottoNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
	}
	
	public static Set<Integer> readLottoNumbers(String input) {
		String[] numberStrings = input.split(",");
		Set<Integer> numbers = new HashSet<>();
		for(String numStr : numberStrings) {
			validateLottoNumber(numbers, numStr);
			numbers.add(Integer.parseInt(numStr.trim()));
		}
		return numbers;
	}
	
	public static void validateLottoNumber(Set<Integer> numbers, String numStr) {
		int number = Integer.parseInt(numStr.trim());
		if(number > MAX_NUMBER || number < 1 || numbers.contains(number))
			throw new IllegalArgumentException("[ERROR] 로또 번호의 범위 1~45 사이 입니다.");
	}
    
	public static int getBonusNumber(Set<Integer> winningNumbers) {
		while (true) {
            System.out.println("보너스 번호를 입력해 주세요");
            String input = Console.readLine();
            try {
                int bonusNumber = Integer.parseInt(input);
                validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력하세요.");
            }
        }
	}
	
	public static void validateBonusNumber (int bonusNumber, Set<Integer> winningNumbers) {
		if(bonusNumber <1 || bonusNumber > MAX_NUMBER)
			throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1~45 사이 입니다.");
		if(winningNumbers.contains(bonusNumber)) 
			throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1~45 사이 입니다.");
	}
    
    
    
    
    
}