package seedu.addressbook.data;

import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;

/**
 * Represents the relationship of tagging between a Person and a Tag
 *
 */
public class Tagging {
    private boolean isAdded;//if not isAdded, tag is deleted
    private Person person;
    private Tag tag;
    
    public Tagging (boolean isAdded, Person person, Tag tag){
        this.isAdded = isAdded;
        this.person = person;
        this.tag = tag;
    }
    
    @Override
    public String toString(){
        String toBeDisplayed = "";
        if (isAdded == true){
            toBeDisplayed.concat("+ ");
        }else { //isDeleted
            toBeDisplayed.concat("- ");
        }
        toBeDisplayed.concat(person.getName().fullName).concat(" ").concat(tag.tagName);
        return toBeDisplayed;
    }
}