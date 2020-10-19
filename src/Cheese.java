 public class Cheese extends Food {
    public Cheese() {
            super("Cheese");
        }
        public int CalculateCalories()
        {
            calories = 50;
            return  calories;
        }

        public void consume(){System.out.println("Cheese");
        }

}

