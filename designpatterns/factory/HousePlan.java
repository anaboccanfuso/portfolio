package factory;

import java.util.ArrayList;

/**
 * A abstract class extended by its children to create the components of the house
 * plan (its materials, features, number of rooms, number of windows, square feet),
 * as well as print them to the user.
 * @author Ana Boccanfuso
 */
public abstract class HousePlan {
    protected ArrayList<String> materials;
    protected ArrayList<String> features;
    private int numRooms;
    private int numWindows;
    private int squareFeet;

    /**
     * Sets the parameters to their specific instances, and creates array lists for 
     * materials and features. Calls the setMaterials and setFeatures methods that are defined 
     * in the children.
     * @param numRooms The number of rooms that the house has.
     * @param numWindows The number of windows that the house has.
     * @param squareFeet The amount of square feet that the house has.
     */
    public HousePlan(int numRooms, int numWindows, int squareFeet) {
        this.numRooms = numRooms;
        this.numWindows = numWindows;
        this.squareFeet = squareFeet;
        this.materials = new ArrayList<String>();
        this.features = new ArrayList<String>();
        this.setFeatures();
        this.setMaterials();
    }

    /**
     * An abstract method implemented in the children to set the materials based on the
     * individual house plan.
     */
    protected abstract void setMaterials();

    /**
     * An abstract method implemented in the children to set the features based on the 
     * individual house plan.
     */
    protected abstract void setFeatures();

    /**
     * A method that returns the materials of the house plan.
     * @return Returns the array list containing the materials of the house.
     */
    public ArrayList<String> getMaterials() {
        return this.materials;
    }

    /**
     * A method that returns the features of the house plan.
     * @return Returns the array list containing the features of the house.
     */
    public ArrayList<String> getFeatures() {
        return this.features;
    }

    /**
     * A method that returns the number of rooms in the house plan.
     * @return Returns the number of rooms in the house plan. 
     */
    public int getNumRooms() {
        return this.numRooms;
    }

    /**
     * A method that returns the number of windows in the house plan.
     * @return Returns the number of windows in the house plan.
     */
    public int getNumWindows() {
        return this.numWindows;
    }

    /**
     * A method that returns the square footage of the house plan.
     * @return Returns the square footage of the house plan.
     */
    public int getSquareFeet() {
        return this.squareFeet;
    }

    /**
     * A method that prints the details of the house including the square
     * footage, the amount of windows and rooms, the materials, and the features.
     * @return Returns the string containing the above information. 
     */
    public String toString() {
        String allMaterials = "";
        for(String material : this.materials) {
            allMaterials = allMaterials + " - " + material + "\n"; 
        }
        String allFeatures = "";
        for(String feature : this.features) {
            allFeatures = allFeatures + " - " + feature + "\n";
        }
        return "Square Feet: " + this.getSquareFeet() + "\n" 
            + "Room: " + this.getNumRooms() + "\n"
            + "Windows: " + this.getNumWindows() + "\n\n"
            + "Materials:\n" + allMaterials + "\n"
            + "Features:\n" + allFeatures;
    }
}
