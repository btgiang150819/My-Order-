package com.example.myorder;

public class Food {
    private int avt;
    private String name;
    private int quantum;
    private float amount;

    public Food(int avt, String name, int quantum, float amount) {
        this.avt = avt;
        this.name = name;
        this.quantum = quantum;
        this.amount = amount;
    }

    public int getAvt() {
        return avt;
    }

    public void setAvt(int avt) {
        this.avt = avt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
