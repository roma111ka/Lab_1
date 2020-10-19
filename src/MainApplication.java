
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args)throws Exception{    // исключения

        Food[] breakfast = new Food[20];
        boolean logicSort = false;
        boolean logicCalories = false;
        int iter = 0;
        for (String arg: args) {
            String[] partsOfArguments = arg.split("/");     // разбить  его  на компоненты
            if(partsOfArguments[0].equals("-sort"))
            {
                logicSort = true;
                continue;
            }
            if(partsOfArguments[0].equals("-calories"))
            {
                logicCalories = true;
                continue;
            }
            try {
                Class myClass = Class.forName("" + partsOfArguments[0]);

                if (partsOfArguments.length==1) {

                    Constructor constructor = myClass.getConstructor();
                    breakfast[iter] = (Food)constructor.newInstance();
                } else
                if (partsOfArguments.length==2) {

                    Constructor constructor = myClass.getConstructor(String.class);
                    breakfast[iter] = (Food)constructor.newInstance(partsOfArguments[1]);
                }
                if (partsOfArguments.length==3) {

                    Constructor constructor = myClass.getConstructor(String.class, String.class);
                    breakfast[iter] = (Food)constructor.newInstance(partsOfArguments[1],partsOfArguments[2] );
                }
            }catch (ClassNotFoundException e)
            {
                System.out.println("("+iter+")This product cant't be eaten");
                continue;
            }
            catch (NoSuchMethodException e)
            {
                System.out.println("There are no some method");
                continue;
            }


            breakfast[iter].consume();
            ++iter;
        }
        System.out.println("---------------------------------");
        if(logicCalories)
        {
            System.out.println("NUMBER OF CALORIES: " + calculateCaloriesOfBreakfast(breakfast));
        }
        if(logicSort)
        {
            System.out.println("SORT BREAKFAST:");
            Arrays.sort(breakfast, new Comparator() {                      // использование  анонимного  класса
                public int compare(Object f1, Object f2) {
                    if (f1==null) return 1;
                    if (f2==null) return -1;
                    return ((Food)f2).CalculateCalories() > (((Food)f1).CalculateCalories()) ? 1: -1;
                }
            });
            printMyBreakfast(breakfast);
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the type of product(name/type/type, name/type, name): ");
        String searchProduct = input.nextLine();
        int count = 0;
        String[] partsOfProduct = searchProduct.split("/");
        for(Food obj: breakfast)
        {
            if(obj == null){break;}
            if(obj.equals(partsOfProduct)) {
                ++count;
            }
        }
        System.out.println(count + " products");


    }

    public static void printMyBreakfast(Food[] breakfast)
    {
        for (Food obj: breakfast)
        {
            if(obj == null)
            {
                break;
            }
            obj.consume();

        }
    }

    public static int calculateCaloriesOfBreakfast(Food[] breakfast)
    {
        int totalCalories = 0;
        for(Food obj: breakfast)
        {
            if(obj == null)
            {
                break;
            }
            totalCalories+= obj.CalculateCalories();
        }
        return totalCalories;
    }
}