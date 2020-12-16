public class Apple extends Food
{
     String size="some size";

    public Apple(String size) {
        super("Apple");
        this.size = size;
    }
    public Apple(){
        super("Apple");
    }
    @Override
    public void consume() {
        System.out.println(size + " " + super.getName());
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    @Override
    public boolean equals(Object apple) {
        if (super.getName().equals(((String[])apple)[0])){
            if(((String[])apple).length == 2)
            {
                return this.size.equals(((String[])apple)[1]);
            }
            return true;
        }
        return  false;

    }
    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
    public int CalculateCalories()
    {
       switch (size)
       {
           case"big":
               calories=18;
               break;
           case "small":
               calories=10;
               break;
           case "middle":
               calories=15;
               break;
           default:
               size="some size";
               calories=9;
       }
       return calories;
    }
}
