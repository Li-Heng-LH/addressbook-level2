package seedu.addressbook.data.person;

import seedu.addressbook.data.person.Block;
import seedu.addressbook.data.person.Unit;
import seedu.addressbook.data.person.PostalCode;
import seedu.addressbook.data.person.Street;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = 
            "Person address should consists of Block, Street, Unit, and Postal Code";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;
    private String value;
    private String [] splittedAddressArray;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.splittedAddressArray = splitAddressIntoArray(trimmedAddress);
        this.isPrivate = isPrivate;
        if (!isValidAddress(this.splittedAddressArray)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
        this.block = new Block (splittedAddressArray[0]);
        this.street = new Street (splittedAddressArray[1]);
        this.unit = new Unit (splittedAddressArray[2]);
        this.postalCode = new PostalCode (splittedAddressArray[3]);
    }


    /**
     * Split input address string into a String array, consisting of the block, street, unit and postal code.
     * 
     * @param address the input address String
     * @return array of String
     */
    private String[] splitAddressIntoArray(String address) {
        String[] addressArray = address.split(", ");
        return addressArray;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String[] test) {
        return test.length==4;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    public String getValue() {
        return this.value;
    }
}
