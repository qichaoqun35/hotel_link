package com.example.qichaoqun.amerilink.bean;

/**
 * @author qichaoqun
 * @date 2018/9/10
 */
public class MoneyEvent {
    public MoneyEvent(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;

    }

    public void setMoney(String money) {
        this.money = money;
    }

    private String money;

}
