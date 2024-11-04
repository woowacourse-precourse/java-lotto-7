package lotto.Service;

public class ValidService {

    public void checkBig(String money) {
        if (money.length() >= 9) {
            throw new IllegalArgumentException("[ERROR] 9글자 이상 입력하실 수 없습니다");
        }
    }


    public void checkNull(String money) {
        if (money == null || money.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력에 빈 값이 들어갈 수는 없습니다.");
        }
    }

    public void checkNum(String money) {
        boolean notNumber = !money.matches("\\d+");
        if (notNumber) {
            throw new IllegalArgumentException("[ERROR] 입력에는 숫자만 들어가야 합니다");
        }
    }

    public void check1000s(String money) {
        boolean not1000s = (Integer.parseInt(money) % 1000 != 0 && Integer.parseInt(money) != 0);
        if (not1000s) {
            throw new IllegalArgumentException("[ERROR] 입력에는 1000원 단위에 금액만 들어가야합니다.");
        }
    }
    public void checkLottoNumbers(String stringNumbers){
        String[] parts = stringNumbers.split(",");
        for (String part : parts) {
            tryValid(part);
        }
    }

    private void tryValid(String part){
        try{
            int num=Integer.parseInt(part);
            if (num>45 || num<1){
                throw new IllegalArgumentException("1부터45까지의 숫자만 입력해주세요");
            }

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
    }


}