package factory;

/**
 * A class to create specific house plans based on the user's input. 
 * @author Ana Boccanfuso
 */
public class HousePlanFactory {
    /**
     * Creates a house plan based on the string the user enters.
     * @param type The string the user enters representing the type of house plan they want.
     * @return Returns the house plan that is created based on the user input.
     */
    public static HousePlan createHousePlan(String type) {
        HousePlan housePlan = null;

        if(type.equalsIgnoreCase("log cabin")) {
            housePlan = new LogCabinPlan();
        }
        else if(type.equalsIgnoreCase("tiny home")){
            housePlan = new TinyHomePlan();
        }
        else {
            housePlan = new ContemporaryPlan();
        }
        return housePlan;
    }
}