package seedu.addressbook.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;

public class NameTest {
    private Name nameUnderTest;
    
    @Before
    public void setup() throws IllegalValueException {
        nameUnderTest = new Name("Li Heng");
    }
}
