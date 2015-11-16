/**
 * Author: Guangpeng Li
 * ID: 200876363
 * Date: 20/10/13
 * Time: 14:08
 * University of Liverpool
 * Comp 213 Assignment 1
 */

/**
 * Create a new topic with a message and add message into
 * an existing topic, as used in a Message Board.
 *
 *   Instances of this class store:
 *   <ul>
 *    <li>the name of a topic, as a string;</li>
 *    <li>the ID for a topic, as a integer;</li>
 *    <li>the start point of the message list, as a list;</li>
 *    <li>the end point of the message list, as a list;</li>
 *   </ul>
 *    Operation of this class:
 *   <ul>
 *    <li>add message into message list</li>
 *   </ul>
 *   Each of these has an accessor method.
 *
 * @author <a href="mailto:sggli@liverpool.ac.uk">Guangpeng Li</a>
 * @version 1.0
 */
public class Topic {

    /**
     * The ID value for a topic
     *
     */
    private int topicID;

    /**
     * The name for a topic
     *
     */
    private String topicName;

    /**
     *  This stores the linked list for {@link LinkedList LinkedList}.
     *  Its value is null for an empty list;
     *  otherwise it points to the first element in the list.
     */
    private LinkedList<Message> ListStartMessage;

    /**
     *  This points to the startPart element
     *  in the {@link LinkedList LinkedList} list.
     *  The value is null if the list is empty.
     */
    private LinkedList<Message> listEndMessage;

    // ----- constructor ----------------------------------------------------

    /**
     * Creates a new <code>Topic</code> instance with the given data.
     *
     * @param topicName the name of the topic
     * @param m the Message for the topic
     * @param topicID the ID for the topic
     */
    public Topic(String topicName,
                 Message m,
                 int topicID) {
        this.topicID=topicID;
        this.topicName = topicName;
        addMessage(m);
    }

    // ----- methods -------------------------------------------------------

    /**
     *  Add a Message into a Topic
     *
     *  @param m the Message to be added to the Topic
     */
    public void addMessage(Message m) {
        if (ListStartMessage == null) {
            // the list is empty,
            // make a new element whose tail is listStartTopic
            ListStartMessage = new LinkedList<Message>(m, ListStartMessage);

            // if the list was empty before, the new element is also the startPart
            if (listEndMessage == null) {
                listEndMessage = ListStartMessage;
            }
        }
        else {
            // the list is not empty, so stick m at the end
            listEndMessage.addEnd(m);
            listEndMessage = listEndMessage.getTail();
        }
    }

    /**
     *  Returns the name for the Topic
     *
     *  @return the Topic Name
     */
    public String getTopicName(){
        return topicName;
    }

    /**
     *  Return the ID of the Topic
     *
     *  @return the Topic ID
     */
    public int getTopicID(){
        return topicID;
    }

    /**
     *  Returns all messages in a topic
     *
     * @return the sender and text of a message
     */
    public String toString(){
        LinkedList<Message> m = ListStartMessage;

        String s = "";

        while(m != null){
            s += "\tUser: "+m.getHead().getSender()+"\n"+
                    "\t\tMessage: "+m.getHead().getText()+"\n";
            m = m.getTail();
        }

        return s;
    }
}