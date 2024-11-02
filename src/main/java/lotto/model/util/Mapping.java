package lotto.model.util;

import lotto.common.WinMoney;
import lotto.common.WinMoneyMessage;

public class Mapping {

    public static String mappingKeyToMoneyString(String key) {
        if (key.equals(WinMoneyMessage.THREECOUNTKEY.getWinMoneyStr())) {
            return WinMoneyMessage.THREERIGHT.getWinMoneyStr();
        } else if (key.equals(WinMoneyMessage.FOURCOUNTKEY.getWinMoneyStr())) {
            return WinMoneyMessage.FOURGRIGHT.getWinMoneyStr();
        } else if (key.equals(WinMoneyMessage.FIVECOUNTKEY.getWinMoneyStr())) {
            return WinMoneyMessage.FIVERIGHT.getWinMoneyStr();
        } else if (key.equals(WinMoneyMessage.FIVEANDBONUSKEY.getWinMoneyStr())) {
            return WinMoneyMessage.FIVEWRIGHTANDBONUS.getWinMoneyStr();
        } else if (key.equals(WinMoneyMessage.SIXCOUNTKEY.getWinMoneyStr())) {
            return WinMoneyMessage.SIXRIGHT.getWinMoneyStr();
        }

        return "";
    }

    public static int mappingMoneyStringToMoneyInt(String key) {
        if (key.equals(WinMoneyMessage.THREECOUNTKEY.getWinMoneyStr())) {
            return WinMoney.THREEMONEY.getWinMoney();
        } else if (key.equals(WinMoneyMessage.FOURCOUNTKEY.getWinMoneyStr())) {
            return WinMoney.FOURMONEY.getWinMoney();
        } else if (key.equals(WinMoneyMessage.FIVECOUNTKEY.getWinMoneyStr())) {
            return WinMoney.FIVEMONEY.getWinMoney();
        } else if (key.equals(WinMoneyMessage.FIVEANDBONUSKEY.getWinMoneyStr())) {
            return WinMoney.FIVEANDBONUSMONEY.getWinMoney();
        } else if (key.equals(WinMoneyMessage.SIXCOUNTKEY.getWinMoneyStr())) {
            return WinMoney.SIXMONEY.getWinMoney();
        }

        return 0;
    }

    public static String mappingCountToKey(int count, int bonusCount) {
        if (count == 3) {
            return WinMoneyMessage.THREECOUNTKEY.getWinMoneyStr();
        } else if (count == 4) {
            return WinMoneyMessage.FOURCOUNTKEY.getWinMoneyStr();
        } else if (count == 5) {
            return WinMoneyMessage.FIVECOUNTKEY.getWinMoneyStr();
        } else if (count == 5 && bonusCount == 1) {
            return WinMoneyMessage.FIVEANDBONUSKEY.getWinMoneyStr();
        } else if (count == 6) {
            return WinMoneyMessage.SIXCOUNTKEY.getWinMoneyStr();
        }

        return "";

    }
}
