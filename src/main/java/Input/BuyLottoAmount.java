package Input;

import camp.nextstep.edu.missionutils.Console;

public class BuyLottoAmount {
    InputLottoNumber inputLottoNumber = new InputLottoNumber();

    public int LottoAmount() {
        int LottoPrice = 1000;
        int InsertAmount = 0;

        //예외 처리
        while (true) {
            try {
                String input = Console.readLine();
                InsertAmount = Integer.parseInt(input);
                if (InsertAmount < 0) {  // 음수 체크
                    throw new IllegalArgumentException("[ERROR] Amount must be a non-negative integer.");
                }
                break; // 유효한 입력일 경우 루프 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Invalid input: must be an integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // 구매할 로또 갯수
        int BuyLottoCount = InsertAmount / LottoPrice;
        System.out.println(BuyLottoCount + "개를 구매했습니다.");
        // BuyLottoCount를 InputLottoNumber의 LottoNumber 메서드에 전달
        inputLottoNumber.LottoNumber(BuyLottoCount);
        return BuyLottoCount;  // BuyLottoCount를 반환
    }
}
