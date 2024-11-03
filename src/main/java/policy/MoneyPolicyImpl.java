package policy;

public class MoneyPolicyImpl implements MoneyPolicy {

    @Override
    public void checkMoneyPolicy(String money) {
        // 돈은 숫자 외 다른게 입력되면 안된다.
        shouldBeOnlyNumber(money);

        // 돈에 Empty 입력되면 안된다.
        shouldNotBeEmpty(money);

        // 돈은 1000으로 나누어 떨어져야한다.
        shouldNotBeDividedBy1000(money);

        // 돈의 값이 너무 크면 안된다.(예외에서 최댓값 말해주기)
        moneyShouldNotBeTooBig(money);
    }

    private void shouldBeOnlyNumber(String money) {
        for (int i = 0; i < money.length(); i++) {
            char number = money.charAt(i);
            if (!isNumber(number)) {
                throw new IllegalArgumentException(); // TODO: 에러 메세지 추가
            }
        }
    }

    private boolean isNumber(char number) {
        if ('0' <= number && number <= '9') {
            return true;
        }
        return false;
    }

    private void shouldNotBeEmpty(String money) {
        if (money.isEmpty()) {
            throw new IllegalArgumentException(); // TODO: 에러 메세지 추가
        }
    }

    private void shouldNotBeDividedBy1000(String money) {
        String checkPoint = money.substring(money.length() - 3);
        System.out.println("money.substring(money.length()-3) = " + money.substring(money.length() - 3));

        if (!checkPoint.equals("000")) {
            throw new IllegalArgumentException(); // TODO: 에러 메세지 추가
        }
    }

    private void moneyShouldNotBeTooBig(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(); // TODO: 에러 메세지 추가
        }
    }

}
