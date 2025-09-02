package cp213;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utilities for working with Food objects.
 *
 * @author Afolabi Awogbemi, 200615200, Awog5200@mylaurier.ca
 * @version 2022-10-04
 */
public class FoodUtilities {

    /**
     * Determines the average calories in a list of foods. No rounding necessary.
     * Foods list parameter may be empty.
     *
     * @param foods a list of Food
     * @return average calories in all Food objects
     */
    public static int averageCalories(final ArrayList<Food> foods) {

	int listLen = foods.size();//gets the size of the list
	int total = 0;//total calories
	int average = 0;//average of calories

	//goes through the foods list
	for(int i = 0; i < listLen; i++) {
	total += foods.get(i).getCalories();//adds up all calories
	}

	average = total/listLen;//calculates average

	return average;//returns average

	}

    /**
     * Determines the average calories in a list of foods for a particular origin.
     * No rounding necessary. Foods list parameter may be empty.
     *
     * @param foods  a list of Food
     * @param origin the origin of the Food
     * @return average calories for all Foods of the specified origin
     */
    public static int averageCaloriesByOrigin(final ArrayList<Food> foods, final int origin) {

	int listLen = foods.size();
	int average = 0;
	int counter = 0;
	int total = 0;
	for(int i = 0; i < listLen; i++) {
		 
		 if(foods.get(i).getOrigin() == origin) {
		 counter += 1;
		 total += foods.get(i).getCalories();
		 }
	 }
	 average = total/counter;//calculates average

	 return average;//returns average
	 }

    /**
     * Creates a list of foods by origin.
     *
     * @param foods  a list of Food
     * @param origin a food origin
     * @return a list of Food from origin
     */
    public static ArrayList<Food> getByOrigin(final ArrayList<Food> foods, final int origin) {

    ArrayList<Food> listByOrigin = new ArrayList<Food>();
    int listLen = foods.size();
    for(int i = 0; i < listLen; i++) {
    	if(foods.get(i).getOrigin() == origin) {

    		 listByOrigin.add(foods.get(i));
    	}
    }

    return listByOrigin;
    }
    

    /**
     * Creates a Food object by requesting data from a user. Uses the format:
     *
     * <pre>
    Name: name
    Origins
     0 Canadian
     1 Chinese
    ...
    11 English
    Origin: origin number
    Vegetarian (Y/N): Y/N
    Calories: calories
     * </pre>
     *
     * @param keyboard a keyboard Scanner
     * @return a Food object
     */
    public static Food getFood(final Scanner keyboard) {

	System.out.print("Name: ");
	 String foodName = keyboard.nextLine();
	
	 System.out.println("\n"+Food.originsMenu());
	 int originNum = 0;
	 while(true) {
		 System.out.print("\nOrigin: ");
		 originNum = keyboard.nextInt();
	
		 if(originNum <= 11 && originNum >= 0) {
		 break;
		 }
		 else {
		 System.out.println("Invalid Origin");
		 }
	 }
		 boolean vegBool = false;
		 while(true) {
			 System.out.print("\nVegetarian (Y/N): ");
			 char isVeg = keyboard.next().charAt(0);
			 if(isVeg == 'Y') {
			 vegBool = true;
			 break;
			 }
			 else if(isVeg == 'N') {
			 vegBool = false;
			 break;
			 }
			 System.out.println("Invalid Input");
			 }
		 System.out.print("\nCalories: ");
		 int cal = keyboard.nextInt();
		 Food foodItem = new Food(foodName, originNum, vegBool, cal);
		 return foodItem;
	 }
	 

    /**
     * Creates a list of vegetarian foods.
     *
     * @param foods a list of Food
     * @return a list of vegetarian Food
     */
    public static ArrayList<Food> getVegetarian(final ArrayList<Food> foods) {

    	ArrayList<Food> vegFoods = new ArrayList<Food>();
    	for(int i = 0; i < foods.size(); i++) {
    		 //checks if food is vegetarian
    		 if(foods.get(i).isVegetarian() == true) {
    		 vegFoods.add(foods.get(i));
    		 }
    	 }

    	 return vegFoods;//returns list
    	 }

    /**
     * Creates and returns a Food object from a line of string data.
     *
     * @param line a vertical bar-delimited line of food data in the format
     *             name|origin|isVegetarian|calories
     * @return the data from line as a Food object
     */
    public static Food readFood(final String line) {

    	String foodItem[] = line.split("\\|");
    	String name = foodItem[0];
    	int cal = Integer.parseInt(foodItem[3]);
    	int origin = Integer.parseInt(foodItem[1]);
    	boolean isVeg = Boolean.parseBoolean(foodItem[2]);
    	Food food = new Food(name, origin, isVeg, cal);
    	return food;
    	 }

    /**
     * Reads a file of food strings into a list of Food objects.
     *
     * @param fileIn a Scanner of a Food data file in the format
     *               name|origin|isVegetarian|calories
     * @return a list of Food
     */
    public static ArrayList<Food> readFoods(final Scanner fileIn) {

    	ArrayList<Food> foods = new ArrayList<Food>();
    	while(fileIn.hasNextLine()) {
    		String foodItem = fileIn.nextLine();
    		 String itemList[] = foodItem.split("\\|");
    		 String name = itemList[0];
    		 int cal = Integer.parseInt(itemList[3]);
    		 int origin = Integer.parseInt(itemList[1]);
    		 boolean isVeg = Boolean.parseBoolean(itemList[2]);
    		 Food item = new Food(name, origin, isVeg, cal);

    		 

    		 foods.add(item);


    		 }

    		 return foods;
    		 }
    	

    /**
     * Searches for foods that fit certain conditions.
     *
     * @param foods        a list of Food
     * @param origin       the origin of the food; if -1, accept any origin
     * @param maxCalories  the maximum calories for the food; if 0, accept any
     * @param isVegetarian whether the food is vegetarian or not; if false accept
     *                     any
     * @return a list of foods that fit the conditions specified
     */
    public static ArrayList<Food> foodSearch(final ArrayList<Food> foods, final int origin, final int maxCalories,
	    final boolean isVegetarian) {

    	ArrayList<Food> foodSrch = new ArrayList<Food>();
    	for(int i = 0; i < foods.size(); i++) {
    		if(origin == foods.get(i).getOrigin() || origin == -1) {
    			if(maxCalories >= foods.get(i).getCalories() || maxCalories == 0) {
    				if(isVegetarian == foods.get(i).isVegetarian() ||
    						isVegetarian == false) {
							 foodSrch.add(foods.get(i));
							 }
							 }
							 }
							 }
					
							 return foodSrch;
							 }
					    			
    		
    	

    /**
     * Writes the contents of a list of Food to a PrintStream.
     *
     * @param foods a list of Food
     * @param ps    the PrintStream to write to
     */
    public static void writeFoods(final ArrayList<Food> foods, PrintStream ps) {

    	for(int i = 0; i < foods.size(); i++) {
    		 ps.println(foods.get(i));
    		 }
    		 }
    		}