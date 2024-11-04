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
	
	public enum Prize {
		FIRST(200000000, "6개 일치"),
		SECOND(3000000, "5개 일치 + 보너스 번호 일치"),
		THIRD(1500000, "5개 일치"),
		FOURTH(50000, "4개 일치"),
		FIFTH(5000, "3개 일치");
	
		private final int amount;
		private final String description;
	
		Prize(int amount, String description) {
			this.amount = amount;
			this.description = description;
		}
	
		public int getAmount() {
			return amount;
		}
	
		public String getDescription() {
			return description;
		}
	}
	
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
    
	public static void analyzeResults(Lotto[] purchasedLottos, Set<Integer> winningNumbers, int bonusNumber) {
		int[] prizeCounts = new int[5];
		for (Lotto lotto : purchasedLottos) {
			int matchCount = getMatchCount(lotto, winningNumbers);
			boolean bonusMatched = lotto.getNumbers().contains(bonusNumber);
			updatePrizeCounts(prizeCounts, matchCount, bonusMatched);
		}
		printPrizeResults(prizeCounts);
		printProfitRate(purchasedLottos, prizeCounts);
	}
	
	public static int getMatchCount(Lotto lotto, Set<Integer> winningNumbers) {
		int count = 0;
		for(Integer number : lotto.getNumbers()) {
			if(winningNumbers.contains(number)) 
				count++;
		}
		return count;
	}
	
	public static void updatePrizeCounts(int[] prizeCounts, int matchCount, boolean bonusMatched) {
		if(matchCount == 6) {
			incrementPrizeCount(prizeCounts, 0);
			return ;
		}
		 if (matchCount == 5) {
	        if (bonusMatched) {
	        	incrementPrizeCount(prizeCounts, 1);
	            return;
	        }
	        incrementPrizeCount(prizeCounts, 2);
	     	return;
		 }
		 if (matchCount == 4) {
			 incrementPrizeCount(prizeCounts, 3);
	         return;
	     }
	     if (matchCount == 3) {
	         incrementPrizeCount(prizeCounts, 4);
	     }
	}
	
	public static void incrementPrizeCount(int[] prizeCounts, int index) {
		prizeCounts[index]++;
	}
    
	public static void printPrizeResults(int[] prizeCounts) {
		System.out.println("당첨 통계");
		System.out.println("---");
		printPrizeCount(Prize.FIFTH, prizeCounts[4]);
        printPrizeCount(Prize.FOURTH, prizeCounts[3]);
        printPrizeCount(Prize.THIRD, prizeCounts[2]);
        printPrizeCount(Prize.SECOND, prizeCounts[1]);
        printPrizeCount(Prize.FIRST, prizeCounts[0]);
	}
	
	public static void printPrizeCount(Prize prize, int count) {
		System.out.printf("%s (%d원) - %d개%n", prize.getDescription(), prize.getAmount(),count);
	}
	
	public static void printProfitRate(Lotto[] purchasedLottos, int[] prizeCounts) {
		int totalEarnings = calculateTotalEarnings(prizeCounts);
		int totalSpent = purchasedLottos.length * LOTTO_PRICE;
	    double profitRate = (double) totalEarnings / totalSpent * 100;

	    System.out.printf("총 수익률: %.1f%%입니다.%n", profitRate);
	}
	
	private static int calculateTotalEarnings(int[] prizeCounts) {
		return 	prizeCounts[0] * Prize.FIRST.getAmount() +
				prizeCounts[1] * Prize.SECOND.getAmount() +
	            prizeCounts[2] * Prize.THIRD.getAmount() +
	            prizeCounts[3] * Prize.FOURTH.getAmount() +
	            prizeCounts[4] * Prize.FIFTH.getAmount();
	}
 
}
    