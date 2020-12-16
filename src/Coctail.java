public class Coctail extends Food {
    String drink = "Some drink";
    String type = "Some taste";
    public Coctail(String drink) {
        super("Cocktail");
        this.drink = drink;
    }
    public Coctail(String drink, String type) {
        super("Cocktail");
        this.type = type;
        this.drink = drink;
    }
    public Coctail() {
        super("Cocktail");
    }
    @Override
    public void consume() {
        System.out.println(drink + " with " + type + " " + super.getName());
    }
    @Override
    public boolean equals(Object cocktail) {

        if (super.getName().equals(((String[])cocktail)[0])){
            if(((String[])cocktail).length == 2) {
                return this.drink.equals(((String[])cocktail)[1]);
            }
            if(((String[])cocktail).length == 3)
            {
                return this.drink.equals(((String[])cocktail)[1]) && this.type.equals(((String[])cocktail)[2]);
            }
            return true;
        }
        return  false;

    }
    @Override
    public int CalculateCalories() {//Калькулятор калорий
        switch (type){
            case "lemon": calories = 13;break;
            case "orange": calories = 10; break;
            case "mango": calories = 15;break;
            case "chocolate": calories = 20;break;

            default:
                type = "some taste";
                calories = 5;break;
        }

        switch (drink){
            case "water": calories += 4;break;
            case "sprite": calories += 70;break;
            case "juice": calories += 15;break;
            case "whiskey": calories += 23; break;

            default:
                drink = "some drink";
                calories = +5;break;
        }
        return calories;
    }

}
