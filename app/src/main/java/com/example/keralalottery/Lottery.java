package com.example.keralalottery;

public class Lottery {
    private String lotteryPrize;
    private int lotteryImage;

    //Constructor
    public Lottery(String lotteryPrize, int lotteryImage){
        this.lotteryPrize=lotteryPrize;
        this.lotteryImage = lotteryImage;
    }

    //Getters ans Setters

    public String getLotteryPrize() {
        return lotteryPrize;
    }

    public void setLotteryPrize(String lotteryPrize) {
        this.lotteryPrize = lotteryPrize;
    }

    public int getLotteryImage() {
        return lotteryImage;
    }

    public void setLotteryImage(int lotteryImage) {
        this.lotteryImage = lotteryImage;
    }
}
