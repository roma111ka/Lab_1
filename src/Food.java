
public abstract class Food implements Consumable,Nutritous{
    int calories=0;
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


}


