package factory;

/**
 * A class that implements the details of a log cabin house plan.
 * @author Ana Boccanfuso
 */
public class LogCabinPlan extends HousePlan {
    
    /**
     * A method that calls the super with 2 rooms, 10 windows, and 1800 square feet.
     */
    public LogCabinPlan() {
        super(2, 10, 1800);
    }

    /**
     * A method that adds the materials of the log cabin to the materials 
     * array list.
     */
    protected void setMaterials() {  
        this.materials.add("Log Siding");
        this.materials.add("Board and Batten Siding");
        this.materials.add("White Pine");
    }

    /**
     * A method that adds the features of the log cabin to the materials
     * array list.
     */
    protected void setFeatures() {
        this.features.add("Timbered Roof");
        this.features.add("High Insulation");
        this.features.add("Rustic Effect");
    }

    /**
     * A method that prints the log cabin information to the user.
     * @return The string representation of the log cabin information.
     */
    public String toString() {
        return "Log Cabin\n" + super.toString();
    }
}
