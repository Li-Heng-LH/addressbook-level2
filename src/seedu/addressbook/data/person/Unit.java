package seedu.addressbook.data.person;

/**
 * Represents a Person's Unit address in the address book.
 */
public class Unit {
    private String value;

	public Unit (String unit){
		this.value = unit.trim();
	}
}