package observer;

/**
 * A class to define the properties of a book, its accessors, and printing out its properties.
 * @author Ana Boccanfuso
 */
public class Book {
    private String title;
    private String authorFirstName;
    private String authorLastName;

    /**
     * A method to define the specific properties of a book.
     * @param title The title of the book.
     * @param authorFirstName The author of the book's first name.
     * @param authorLastName The author of the book's last name.
     */
    public Book(String title, String authorFirstName, String authorLastName) {
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    /**
     * A method to access the specific title of the book.
     * @return Returns the string representation of the title of the book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * A method to access the author of the book's first name.
     * @return Returns the string representation of the author's first name.
     */
    public String getAuthorFirstName() {
        return this.authorFirstName;
    }

    /**
     * A method to access the author of the book's last name.
     * @return Returns the string representation of the author's last name.
     */
    public String getAuthorLastName() {
        return this.authorLastName;
    }

    /**
     * A method to print out the book's properties in a coherent line.
     * @return Returns the coherent string as mentioned above. 
     */
    public String toString() {
        return "- " + getTitle() + " by: " + getAuthorFirstName() + " " + getAuthorLastName();
    }
}
