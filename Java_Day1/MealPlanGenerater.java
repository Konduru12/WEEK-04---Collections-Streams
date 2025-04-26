import java.util.ArrayList;
import java.util.List;
interface MealPlan {
    String getMealType();
    List<String> getMeals();
}
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Non-Vegetarian";
    }
    @Override
    public List<String> getMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Chicken Tikka");
        meals.add("Mutton Biryani");
        return meals;
    }
}
class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Non Vegan";
    }
    @Override
    public List<String> getMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Fish Fry");
        meals.add("Prawn Salad");
        return meals;
    }
}
class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Low Calorie";
    }
    @Override
    public List<String> getMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Grilled Chicken");
        meals.add("Leafy Avocado Salad");
        return meals;
    }
}
class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein";
    }
    @Override
    public List<String> getMeals() {
        List<String> meals = new ArrayList<>();
        meals.add("Eggs");
        meals.add("Protein Smoothie");
        return meals;
    }
}
class Meal<T extends MealPlan> {
    final private T plan;

    public Meal(T plan) {
        this.plan = plan;
    }
    public T getPlan() {
        return plan;
    }
    public static <T extends MealPlan> void generatePlan(Meal<T> meal) {
        System.out.println("Meal Type: " + meal.getPlan().getMealType());
        System.out.println("Meals Included:");
        for (String dish : meal.getPlan().getMeals()) {
            System.out.println(" - " + dish);
        }
        System.out.println("Meal plan generated successfully!\n");
    }
}
public class MealPlanGenerater{
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> hpMeal = new Meal<>(new HighProteinMeal());
        Meal.generatePlan(vegMeal);
        Meal.generatePlan(veganMeal);
        Meal.generatePlan(ketoMeal);
        Meal.generatePlan(hpMeal);
    }
}
