package org.stepik.mytest;

public class test3{
    public static void main(String[] args) {
        Box[] boxes = new Box[]{
                new Box("Подарок", 100),
                new Box("Ожерелье",10000),
                new Box("Шлак", 10)};
    
        System.out.println("Содержание всех коробок до вора: ");
        printBoxesContent(boxes);
        Thief thief = new Thief(500);
        int sum = thief.stealFrom(boxes);
        System.out.println("Содержание всех коробок после вора: ");
        printBoxesContent(boxes);
        System.out.println("Вор украл вещей на сумму = " + sum);
    }
    
    public static void printBoxesContent(Box[] boxes) {
        
        for (int i=0; i<boxes.length; i++) {
            System.out.println("" + i + "-ая коробка сожержит: \"" +
                    boxes[i].getContent() + "\" ценой " + boxes[i].getPrice());
        }
    }
    
    public static class Thief {
        private int minSum;
        
        public Thief(int minSum){
            this.minSum = minSum;
        }
        
        public int stealFrom(Stealable[] boxes)
        {
            int totalSumStolen = 0;
            for (int i=0; i<boxes.length; i++) {
                if (boxes[i].getPrice() >= minSum) {
                    Box currBox = (Box)boxes[i];
                    totalSumStolen += currBox.getPrice();
                    boxes[i] = new Box("Пустота", 0);
                    // currBox = new Box("Пустота", 0);  // НЕ РАБОТАЕТ
                }
            }
            return totalSumStolen;
        }
    }
    
    public static interface Stealable {
        int getPrice();
    }
    
    public static class Box implements Stealable{
        
        public String getContent() {
            return content;
        }
        
        @Override
        public int getPrice() {
            return price;
        }
    
        private String content;
        private int price;
        
        public Box(String content, int price) {
           this.content = content;
           this.price = price;
        }
        
        
    }
}
