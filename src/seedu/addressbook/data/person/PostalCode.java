package seedu.addressbook.data.person;

/**
 * Represents a Person's Postal Code in the address book.
 */
public class PostalCode {
    private String value;

	public PostalCode (String postalCode){
		this.value = postalCode.trim();
	}
}