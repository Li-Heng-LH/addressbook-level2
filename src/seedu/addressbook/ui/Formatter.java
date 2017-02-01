package seedu.addressbook.ui;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * Formats messages to be output to user
 * for service of TextUI 
 */
public class Formatter {
    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    public Formatter(){}
    
    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     * @return showToUserAsIndexedList a formatted string ready to show to user
     */
    public String showPersonListView (List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        return showToUserAsIndexedList(formattedPersons);
    }
    
    /** Shows a list of strings to the user, formatted as an indexed list. */
    private String showToUserAsIndexedList(List<String> list) {
        return getIndexedListForViewing(list);
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    private static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}