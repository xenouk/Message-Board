/**
 * Author: Guangpeng Li
 * ID: 200876363
 * Date: 20/10/13
 * Time: 14:08
 * University of Liverpool
 * Comp 213 Assignment 1
 */

/**
 * Stores data for a message, as used in a topic in a Message Board.
 *
 *   Instances of this class store:
 *   <ul>
 *    <li>the sender of a message, as a string;</li>
 *    <li>the text for the message, as a string;</li>
 *   </ul>
 *   Each of these has an accessor method.
 *
 * @author <a href="mailto:sggli@liverpool.ac.uk">Guangpeng Li</a>
 * @version 1.0
 */

public class Message {

    /**
     * The sender of the message
     *
     */
    private String sender;

    /**
     * The text for the message
     *
     */
    private String text;

    // ----- constructor ----------------------------------------------------

    /**
     * Creates a new <code>Message</code> instance with the given data.
     *
     * @param sender the sender of the message
     * @param text the text for the message
     */
    public Message(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    // ----- methods --------------------------------------------------------

    /**
     *  Returns the sender for the message
     *
     *  @return the sender
     */
    public String getSender(){
        return sender;
    }

    /**
     *  Returns the text for the message
     *
     *  @return the text
     */
    public String getText(){
        return text;
    }
}