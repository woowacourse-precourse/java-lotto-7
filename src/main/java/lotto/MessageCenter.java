package lotto;

import lotto.committee.PrizeMoney;

public enum MessageCenter {
    START("구입금액을 입력해 주세요."),
    COUNT("개를 구매했습니다."),
    PICK_MAIN("당첨 번호를 입력해 주세요."),
    PICK_BONUS("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계\n---"),
    RESULT_FIFTH("3개 일치 (5,000원) - "),
    RESULT_FOURTH("4개 일치 (50,000원) - "),
    RESULT_THIRD("5개 일치 (1,500,000원) - "),
    RESULT_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RESULT_FIRST("6개 일치 (2,000,000,000원) - "),
    RESULT_END("개"),
    RESULT_RATE_START("총 수익률은 "),
    RESULT_RATE_FINISH("%입니다."),
    NEW_LINE(""),
    ERROR("[ERROR] "),
    ERROR_PICK("[ERROR] 당첨번호를 잘못 입력했습니다. 다시 입력해 주세요."),
    ERROR_NOTNULL("[ERROR] 기추첨결과가 존재합니다."),
    ERROR_NULL("[ERROR] 추첨결과 저장 과정에서 에러가 발생하였습니다."),
    ERROR_MONEY("[ERROR] 금액을 잘못 입력했습니다. 다시 입력해 주세요."),
    ERROR_USERSTORAGE("[ERROR] 구매기록이 없습니다."),
    ERROR_COUNT("[ERROR] 구매장수를 인식할 수 없습니다."),
    ERROR_PAYMENT("[ERROR] 결제 내역을 찾을 수 없습니다."),
    ERROR_SAVE("[ERROR] 저장된 내역이 없습니다."),
    ERROR_PAID("[ERROR] 내역을 저장할 수 없습니다."),
    ERROR_DRAWN("[ERROR] 이미 자동번호 선택이 완료되었습니다.");


    private final String msg;

    private MessageCenter(String msg) {
        this.msg = msg;
    }

    public String get() {
        return this.msg;
    }

    public void print() {
        System.out.println(this.msg);
    }

    public void printRate(Double rate) {
        String rateResult = "";
        rateResult += RESULT_RATE_START;
        rateResult += rate;
        rateResult += RESULT_RATE_FINISH;
        System.out.println(rateResult);
    }
}
