/**
 * Author: Guangpeng Li
 * ID: 200876363
 * Date: 20/10/13
 * Time: 14:08
 * University of Liverpool
 * Comp 213 Assignment 1
 */

/**
 * A sorted list of topics and used as a Message Board.
 * Users can create topics and post messages on it.
 *
 *   Instances of this class store:
 *   <ul>
 *    <li>the start point of the topic list, as a list;</li>
 *    <li>the end point of the topic list, as a list;</li>
 *   </ul>
 *
 *   Operation of this class:
 *   <ul>
 *    <li>instantiate empty lists</li>
 *    <li>create new topics</li>
 *    <li>add message into topics</li>
 *    <li>return topics from the topic list</li>
 *    <li>move topic to the top of the topic list</li>
 *    <li>remove topics from the topic list</li>
 *    <li>return the length of the topic list</li>
 *   </ul>
 *
 * @author <a href="mailto:sggli@liverpool.ac.uk">Guangpeng Li</a>
 * @version 1.0
 */

public class SortedList {
    /**
     *  This stores the linked list for {@link Topic Topic}.
     *  Its value is null for an empty list;
     *  otherwise it points to the first element in the list.
     */
    private LinkedList<Topic> listStartTopic;

    /**
     *  This points to the startPart element
     *  in the {@link Topic Topic} list.
     *  The value is null if the list is empty.
     */
    private LinkedList<Topic> listEndTopic;

    // ----- constructor ----------------------------------------------------

    /**
     * Creates a new <code>SortedList</code> instance.
     * Does nothing; lists will be null when empty.
     */
    public SortedList() {
    }

    // ----- methods --------------------------------------------------------

    /**
     *  Add a Topic to the start of the topic list.
     *
     * @param e the Message to be added to the list
     * @param t the title to be added to the list
     */
    public void addNewTopic(Message e, String t) {
        // make a new element whose tail is listStartTopic
        listStartTopic = new LinkedList<Topic>(new Topic(t,e,length()), listStartTopic);

        // if the list was empty before, the new element is also the startPart
        if (listEndTopic == null) {
            listEndTopic = listStartTopic;
        }
    }

    /**
     *  Add a message to an existing Topic with the given identifier
     *
     * @param m the Message to be added to the Topic
     * @param i the ID of the Topic which the Message goes to
     */
    public void addPost(Message m, int i) {
        // add the topic to the top of the list
        add(i);
        // add the message to the topic on the top of the list
        listStartTopic.getHead().addMessage(m);
        // remove the old topic (duplicated after added to top)
        remove(i);
    }

    /**
     *  Add a Topic to the start of the topic list with the given identifier
     *
     * @param i the ID of the Topic goes to start
     */
    private void add(int i) {
        LinkedList temp = listStartTopic;
        // only add the topic if it exists
        listStartTopic = (get(i) != null)? new LinkedList<Topic>(get(i),temp):temp;
    }

    /**
     *  The length of the list.
     *  Counts the number of Topics in the list.
     *
     * @return the number of Topics in the list
     */
    private int length() {
        // stores the number of Topics found so far
        int len = 0;

        LinkedList t = listStartTopic;

        // loop until the end of the list
        while (t != null) {
            len++;
            t = t.getTail();
        }

        return len;
    }

    /**
     *  Remove the topic with a given identifier
     *
     * @param i the ID of the Topic to remove
     */
    private void remove(int i) {
        if (listEndTopic != null) {
            // List will become empty if there is only one element
            if (listEndTopic.prev() == null) {
                listStartTopic = null;
                listEndTopic = null;
            }
            else {
                LinkedList<Topic> temp = listStartTopic;
                // the search starts from the second element on the list
                listStartTopic = listStartTopic.getTail();
                // check if the element is on the list
                if(get(i) != null){
                    if (listStartTopic.getTail() != null){
                        // this removed the element that is not the last
                        listStartTopic.prev().link(listStartTopic.getTail());
                    }else{
                        // this eliminate the last element
                        listEndTopic = listEndTopic.prev();
                        listEndTopic.chop();
                    }
                }
                // put the pointer back to the start of the list
                listStartTopic = temp;
            }
        }
    }

    /**
     *  Returns the topic with a given identifier
     *
     * @param i the ID of the Topic to return
     *
     * @return a topic
     */
    private Topic get(int i){
        Topic t = null;

        boolean found = false;

        // loop until the end of the list
        while(!found){
            // if the topic does not exist
            if(listStartTopic == null){
                found = true;
            }
            // if the element is found
            else if(listStartTopic.getHead().getTopicID() == i){
                t = listStartTopic.getHead();
                found = true;
            }
            // else keep looking in the list
            else{
                listStartTopic = listStartTopic.getTail();
            }
        }
        // return the found topic
        return t;
    }

    /**
     *  Returns all topics in the list
     *
     * @return the name and identifier of a topic
     */
    public String toString(){
        LinkedList<Topic> l = listStartTopic;

        String s = "";

        while(l != null){
            s += "\nTopic Name: "+l.getHead().getTopicName()+
                    "\nID: "+l.getHead().getTopicID()+"\n"
                        +l.getHead();
            l = l.getTail();
        }

        return s;
    }
}