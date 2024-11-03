package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	List<Lotto> lottos = purchaseLottos();
        WinningNumber winningNumber = inputWinningNumber();
        
    	
    	
    }
    private static List<Lotto> purchaseLottos() {
    	 while (true) {
    		 try {
    	    		System.out.println("구입금액을 입력해 주세요.");
    	            String input = Console.readLine();
    	            validatePurchaseAmount(Integer.parseInt(input));
    	            
    	            int amount = Integer.parseInt(input);
    	            List<Lotto> lottos = LottoMachine.issue(amount);
    	            
    	            System.out.printf("%d개를 구매했습니다.\n", lottos.size());
    	            lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    	            return lottos;
    	    	}catch (IllegalArgumentException e) {
    	            System.out.println(e.getMessage());
    	        }
    	 }
    	
    }
    private static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    
    }
    private static WinningNumber inputWinningNumber() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                return new WinningNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
