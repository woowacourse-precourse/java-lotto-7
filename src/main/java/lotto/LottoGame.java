package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    
    public void playLotto() {
        
        // 구매 금액 입력 받기
        Integer money = inputMoney();
        
        // 구매 금액에 맞는 수량의 로또 발행
        List<Lotto> generatedLottos = generateLottos(money);
        
        // 당첨 로또 번호 입력 받고 생성하기
        Lotto winningLotto = generateWinningLotto();
        
        // 보너스 번호 입력 받기
        Integer bonusLottoNumber = generateBonusLottoNumber(winningLotto);
    }
    
    public Integer generateBonusLottoNumber(Lotto winningLotto) {
        
        System.out.println();
        
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputBonusNumber = Console.readLine();
                return validateBonusLottoNumber(inputBonusNumber, winningLotto.getNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요.");
            }
        }
    }
    
    private Integer validateBonusLottoNumber(String inputBonusNumber, List<Integer> numbers) {
        Integer bonusNumber;
        
        if (inputBonusNumber == null || inputBonusNumber.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 비어있습니다.");
        }
        try {
            bonusNumber  = Integer.parseInt(inputBonusNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 입력받은 문자를 숫자로 변환할 수 없습니다.");
        }
        
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        
        for (Integer number : numbers) {
            if (number.equals(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호에는 중복된 번호가 없어야 합니다.");
            }
        }
        
        return bonusNumber;
    }
    
    public Lotto generateWinningLotto() {
        List<Integer> winningLottoNumbers = new ArrayList<>();
        
        System.out.println();
        
        while (winningLottoNumbers.size() != 6) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputLottoNumbers = Console.readLine();
                winningLottoNumbers = validateInputLottoNumbers(inputLottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요.");
            }
        }
        
        return new Lotto(winningLottoNumbers);
    }
    
    private List<Integer> validateInputLottoNumbers(String inputLottoNumbers) {
        if (inputLottoNumbers == null || inputLottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 비어있습니다.");
        }
        
        List<Integer> splits = null;
        try {
            splits = Arrays.stream(inputLottoNumbers.split(","))
                    .mapToInt(value -> Integer.parseInt(value.trim()))
                    .boxed()
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 값은 Integer 배열로 변환할 수 없습니다.");
        }
        
        // 로또의 validate를 통해 검증, 여기서 에러가 안나면 통과 한다는 뜻
        Lotto validateCheckLotto = new Lotto(splits);
        
        return validateCheckLotto.getNumbers();
    }
    
    public List<Lotto> generateLottos(Integer money) {
        
        List<Lotto> generatedLottos = new ArrayList<>();
        
        System.out.println();
        System.out.println((money / 1000) + "개를 구매했습니다.");
        
        for (int i = money; i > 0; i = i - 1000) {
            
            Lotto lotto = generateOneLotto();
            
            generatedLottos.add(lotto);
        }
        
        printGeneratedLottos(generatedLottos);
        
        return generatedLottos;
    }
    
    
    private void printGeneratedLottos(List<Lotto> generatedLottos) {
        for (Lotto generatedLotto : generatedLottos) {
            generatedLotto.printLottoNumbers();
        }
    }
    
    private Lotto generateOneLotto() {
        
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        
        lottoNumbers.sort(Integer::compareTo); // sort() 메서드로 정렬
        
        return new Lotto(lottoNumbers);
    }
    
    public Integer inputMoney() {
        // 무한 루프로 올바른 입력을 받을 때까지 반복
        while (true) {
            try {
                String inputMoney = inputStringMoney();
                
                return validateInputMoney(inputMoney);
                
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해 주세요.");
                System.out.println();
            }
        }
        
    }
    
    private String inputStringMoney() {
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
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 값은 숫자로 변환할 수 없습니다.");
        }
        
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
        }
        
        return money;
    }
    
    
}
