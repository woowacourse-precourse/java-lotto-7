package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BonusNumberValidator;
import lotto.model.Lotto;
import lotto.model.LottoValidator;
import lotto.model.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class InputView { //숫자 형식, 로또 구입 금액, 당첨 번호, 보너스 번호 유효성 검사

    /*// 로또 구입 금액을 입력받는 메서드
    public int readPurchaseAmount() {
        System.out.println("로또 구입 금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                int amount = Integer.parseInt(input);
                validatePurchaseAmount(amount);
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }*/

    // 로또 구입 금액을 입력받는 메서드
    public int readPurchaseAmount() {
        System.out.println("로또 구입 금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                int amount = Integer.parseInt(input);

                // LottoValidator를 사용하여 구입 금액 검증
                LottoValidator.validatePurchaseAmount(amount);

                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /*// 당첨 번호와 보너스 번호를 입력받는 메서드
    public WinningNumbers readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.(예: 1, 2, 3, 4, 5, 6) : ");
        while (true) {
            try {
                String input = Console.readLine();
                String[] numberStrings = input.split(",");
                List<Integer> winningNumbers = new ArrayList<>();

                for (String numberString : numberStrings) {
                    winningNumbers.add(Integer.parseInt(numberString.trim()));
                }

                // 보너스 번호 입력
                int bonusNumber = readBonusNumber(); // 보너스 번호 입력

                // WinningNumbers 객체 반환
                return new WinningNumbers(winningNumbers, bonusNumber);

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            } catch (Exception e) { // 추가된 부분
                System.out.println("[ERROR] 입력된 번호가 유효하지 않습니다."); // 추가된 부분
            }
        }
    }

    // 보너스 번호를 입력받는 메서드
    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요. : ");
        while (true) {
            try {
                String input = Console.readLine();
                int bonusNumber = Integer.parseInt(input);
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }*/

    /*// 당첨 번호를 입력받는 메서드
    public List<Integer> readWinningNumbersFromInput() { // 추가된 부분
        System.out.println("당첨 번호를 입력해 주세요.(예: 1, 2, 3, 4, 5, 6) : ");
        while (true) {
            try {
                String input = Console.readLine();
                String[] numberStrings = input.split(",");
                List<Integer> winningNumbers = new ArrayList<>();

                for (String numberString : numberStrings) {
                    winningNumbers.add(Integer.parseInt(numberString.trim()));
                }

                return winningNumbers; // 당첨 번호 리스트 반환

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 입력된 번호가 유효하지 않습니다. 숫자를 입력하세요.");
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }*/

    public List<Integer> readWinningNumbersFromInput() {
        System.out.println("당첨 번호를 입력해 주세요.(예: 1, 2, 3, 4, 5, 6) : ");
        while (true) {
            try {
                String input = Console.readLine();
                String[] numberStrings = input.split(",");

                List<Integer> winningNumbers = new ArrayList<>();
                for (String numberString : numberStrings) {
                    winningNumbers.add(Integer.parseInt(numberString.trim()));
                }

                // Lotto 객체를 생성하여 입력된 번호 유효성 검증
                Lotto lotto = new Lotto(winningNumbers); // 여기에 validate 메서드가 호출됨

                return lotto.getNumbers(); // 유효성 검증된 로또 번호 리스트 반환

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /*// 보너스 번호를 입력받는 메서드
    public int readBonusNumberFromInput() { // 추가된 부분
        System.out.println("보너스 번호를 입력해 주세요. : ");
        while (true) {
            try {
                String input = Console.readLine();
                int bonusNumber = Integer.parseInt(input);
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            }catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }*/

    /*public int readBonusNumberFromInput() {
        System.out.println("보너스 번호를 입력해 주세요. : ");
        while (true) {
            try {
                String input = Console.readLine();
                int bonusNumber = Integer.parseInt(input);

                // 보너스 번호 유효성 검증 메서드 호출
                validateBonusNumber(bonusNumber);

                return bonusNumber; // 검증된 보너스 번호 반환
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 범위 검증 에러 메시지 출력
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }*/

    public static int readBonusNumberFromInput() {
        System.out.println("보너스 번호를 입력해 주세요. : ");
        while (true) {
            try {
                String input = Console.readLine();

                // 숫자 형식인지 먼저 검증
                BonusNumberValidator.validateBonusNumberIsNumeric(input);

                int bonusNumber = Integer.parseInt(input);

                // 범위와 중복 여부 검증
                BonusNumberValidator.validateBonusNumberRange(bonusNumber);

                return bonusNumber; // 검증된 보너스 번호 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumbers readWinningNumbers() {
        List<Integer> winningNumbers = readWinningNumbersFromInput();
        int bonusNumber = readBonusNumberFromInput();

        // 중복 검증
        BonusNumberValidator.validateBonusNumberNotDuplicate(bonusNumber, winningNumbers);

        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    // 당첨 번호와 보너스 번호를 입력받는 메서드
    /*public WinningNumbers readWinningNumbers() {
        List<Integer> winningNumbers = readWinningNumbersFromInput(); // 수정된 부분
        int bonusNumber = readBonusNumberFromInput(); // 수정된 부분

        // WinningNumbers 객체 반환
        return new WinningNumbers(winningNumbers, bonusNumber);
    }*/

    /*// 로또 구입 금액 유효성 검증
    private void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 보너스 번호 유효성 검증
    public static void validateBonusNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }*/
}
