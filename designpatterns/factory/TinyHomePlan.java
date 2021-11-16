package factory;

/**
 * A class that implements the details of a tiny house plan.
 * @author Ana Boccanfuso
 */
public class TinyHomePlan extends HousePlan {
   
    /**
     * A method that calls the super with 1 room, 5 windows, and 200 square feet.
     */
    public TinyHomePlan() {
        super(1, 5, 200);
    }

    /**
     * A method that adds the materials of the tiny house to the materials
     * array list.
     */
    protected void setMaterials() {
        this.materials.add("Lumber");
        this.materials.add("Insulation");
        this.materials.add("Metal Roofing");
        this.materials.add("Hardware");
    }

    /**
     * A method that adds the features of the tiny house to the materials
     * array list.
     */
    protected void setFeatures() {
        this.features.add("Natural Light");
        this.features.add("Creative Storage");
        this.features.add("Multipurpose Areas");
        this.features.add("Mutli-Use Applications");
    }

    /**
     * A method that prints the tiny house information to the user.
     * @return The string representation of the tiny house information.
     */
    public String toString() {
        return "Tiny House\n" + super.toString();    
    }
}
