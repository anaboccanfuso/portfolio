package factory;

/**
 * A class that implements the details of a contemporary house plan.
 * @author Ana Boccanfuso
 */
public class ContemporaryPlan extends HousePlan {
   
    /**
     * A method that calls the super with 5 rooms, 40 windows, and 3000 square feet.
     */
    public ContemporaryPlan() {
        super(5, 40, 3000);
    }

    /**
     * A method that adds the materials of the contemporary house to the materials
     * array list.
     */
    protected void setMaterials() {
        this.materials.add("Ceramics");
        this.materials.add("High-Strength Alloys");
        this.materials.add("Composites");
    }

    /**
     * A method that adds the features of the contemporary house to the features
     * array list.
     */
    protected void setFeatures() {
        this.features.add("Oversized Windows");
        this.features.add("Unconventional Roofs");
        this.features.add("Minimalism");
        this.features.add("Open Floor Plan");
    }

    /**
     * A method that prints the contemporary house information to the user.
     * @return The string representation of the contemporary house information.
     */
    public String toString() {
        return "Contemporary Home\n" + super.toString();
    }
}
