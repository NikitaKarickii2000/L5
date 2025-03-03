package org.example;

public class Miska {
    private int foodCounter;
    public Miska(int kolFood) {
        if (kolFood < 0) {
            this.foodCounter = 0;
        } else {
            this.foodCounter = kolFood;
        }
    }
        public void addFood(int kol){
            if (kol > 0) {
                foodCounter += kol;
                System.out.println("В миску насыпал " + kol + " еды. Теперь в миске " + foodCounter + " еды.");
            } else {
                System.out.println("Зачем забираешь еду");
            }
        }
        public boolean eatFood(int kol){
            if (kol <= foodCounter) {
                foodCounter -= kol;
                System.out.println("Из миски съел " + kol + " еды. Осталось " + foodCounter + " еды.");
                return true;
            } else {
                System.out.println("Недостаточно еды в миске. В миске " + foodCounter + " еды.");
                return false;
            }
        }
        public int getFoodCounter(){
            return foodCounter;
        }

    }

