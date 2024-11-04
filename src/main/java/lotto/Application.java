package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	private static final int LOTTO_PRICE = 1000;
	
    public static void main(String[] args) {
    	while(true)
	    	try {
		    	int amount = getPurchaseAmount();
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
    
    
    
    
    
    
}