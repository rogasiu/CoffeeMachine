package machine;
import java.util.Scanner;

public class CoffeeMachine {
    enum TypesCoffee {
        ESPRESSO(250, 0, 16, 1, 4),
        LATTE(350, 75, 20, 1, 7),
        CAPPUCCINO(200, 100, 12, 1, 6),
        BACK(0, 0, 0, 0, 0),
        ERROR(0, 0, 0, 0, 0);
        
        private final int water;
        private final int milk;
        private final int coffeeBeans;
        private final int disposableCups;
        private final int money;
        
        TypesCoffee(int water, int milk, int coffeeBeans, int disposableCups, int money) {
            this.water = water;
            this.milk = milk;
            this.coffeeBeans = coffeeBeans;
            this.disposableCups = disposableCups;
            this.money = money;
        }
        int getWater() {
            return this.water;
        }
        int getMilk() {
            return this.milk;
        }
        int getCoffeeBeans() {
            return this.coffeeBeans;
        }
        int getDisposableCups() {
            return this.disposableCups;
        }
        int getMoney() {
            return this.money;
        }
    }
    enum Action {
        BUY, FILL, TAKE, REMAINING, EXIT, ERROR;
    }
    
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;
    Scanner sc = new Scanner(System.in);

    
    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
          

    }
    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disposableCups = 9;
        this.money = 550;
        

    }
    
    public static void main(String[] args) {
        CoffeeMachine machines = new CoffeeMachine();
        machines.start();
    }
    public void start() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            
            switch (actionChoice()) {
                case BUY:
                    buy();
                    break;
                case FILL:
                    makeFill();
                    break;
                case TAKE:
                    take();
                    break;
                case REMAINING:
                    currentState();
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unkown action");
                    break;
            }
        }
    }
    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        
        switch (coffeeChoice()) {
            case BACK:
                start();
                break;
            case ESPRESSO:
                if (this.water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    
                    this.water -= TypesCoffee.ESPRESSO.getWater();
                    this.coffeeBeans -= TypesCoffee.ESPRESSO.getCoffeeBeans();
                    this.disposableCups -= TypesCoffee.ESPRESSO.getDisposableCups();
                    this.money += TypesCoffee.ESPRESSO.getMoney();
                }
                start();
                break;
            case LATTE:
                if (this.water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.coffeeBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    
                    this.water -= TypesCoffee.LATTE.getWater();
                    this.milk -= TypesCoffee.LATTE.getMilk();
                    this.coffeeBeans -= TypesCoffee.LATTE.getCoffeeBeans();
                    this.disposableCups -= TypesCoffee.LATTE.getDisposableCups();
                    this.money += TypesCoffee.LATTE.getMoney();
                }
                start();
                break;
            case CAPPUCCINO:
                if (this.water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.coffeeBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    
                    this.water -= TypesCoffee.CAPPUCCINO.getWater();
                    this.milk -= TypesCoffee.CAPPUCCINO.getMilk();
                    this.coffeeBeans -= TypesCoffee.CAPPUCCINO.getCoffeeBeans();
                    this.disposableCups -= TypesCoffee.CAPPUCCINO.getDisposableCups();
                    this.money += TypesCoffee.CAPPUCCINO.getMoney();
                }
                
                start();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
    public TypesCoffee coffeeChoice() {
        switch (sc.nextLine()) {
            case "1":
                return TypesCoffee.ESPRESSO;
                
            case "2":
                return TypesCoffee.LATTE;
                
            case "3":
                return TypesCoffee.CAPPUCCINO;
                
            case "back":
                return TypesCoffee.BACK;
                
            default: 
                return TypesCoffee.ERROR;
                
        }
    }
    public Action actionChoice() {
        switch(sc.nextLine()) {
            case "buy":
                return Action.BUY;
            case "fill":
                return Action.FILL;
            case "take":
                return Action.TAKE;
            case "remaining":
                return Action.REMAINING;
            case "exit":
                return Action.EXIT;
            default:
                return Action.ERROR;
            
        }
    }
    public void makeFill() {
        System.out.println("Write how many ml of water do you want to add: ");
        int water = sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        int milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int beans = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups = sc.nextInt();
        fill(water, milk, beans, cups);
        
    }
    public void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.coffeeBeans += beans;
        this.disposableCups += cups;
    }
    
    public void currentState() {
            System.out.println("The coffee machine has:");
            System.out.println(this.water + " of water");
            System.out.println(this.milk + " of milk");
            System.out.println(this.coffeeBeans + " of coffee beans");
            System.out.println(this.disposableCups + " of disposable cups");
            System.out.println(this.money + " of money");
        }
        
        public void take() {
            System.out.println("I gave you " + this.money);
            this.money = 0;
        }
    
}
