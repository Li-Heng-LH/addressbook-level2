package seedu.addressbook.parser;

import org.junit.Test;
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
    
    @Test
    public void isSimilarNameTest () throws IllegalValueException{
        //equal name
        assertTrue(nameUnderTest.isSimilar(new Name("Li Heng")));
        assertFalse(nameUnderTest.isSimilar(new Name("Li Heng Heng")));
        
        //case insensitive 
        assertTrue(nameUnderTest.isSimilar(new Name("lI hEnG")));
        assertTrue(nameUnderTest.isSimilar(new Name("li HENg")));
    }
}
