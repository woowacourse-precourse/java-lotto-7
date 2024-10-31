package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Lotto {
    
    private final List<Integer> numbers;
    
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    
    // TODO: 추가 기능 구현
    
    public void playLotto() {
        
        // 구매 금액 입력 받기
        Integer money = inputMoney();
        
    }
    
    public Integer inputMoney() {
        
        while (true) {
            try {
                String inputMoney = inputStringmoney();
                
                return validateInputMoney(inputMoney);
                
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요.");
                throw e;
            }
        }
        
    }
    
    private String inputStringmoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        
        if (inputMoney == null || inputMoney.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 없습니다.");
        }
        
        return inputMoney;
    }
    
    private Integer validateInputMoney(String inputMoney) {
        Integer money = null;
        
        try {
            money = Integer.parseInt(inputMoney);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 값은 숫자로 변환할 수 없습니다.");
        }
        
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
        }
        
        return money;
    }
}
