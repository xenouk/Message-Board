/**
 * Author: Guangpeng Li
 * ID: 200876363
 * Date: 20/10/13
 * Time: 14:08
 * University of Liverpool
 * Comp 213 Assignment 1
 */

/**
 * This is the test case for the message board and the test is following by:
 *  <ul>
 *	    <li> Add a new topic: Message[A: 1st Post!, Topic Name: Topid 0] </li>
 *	    <li> Add a new topic: Message[B: 1st Post!, Topic Name: Topid 1] </li>
 *	    <li> Add a new topic: Message[C: 1st Post!, Topic Name: Topid 2] </li>
 *	    <li> Add a new topic: Message[D: 1st Post!, Topic Name: Topid 3] </li>
 *	    <li> Add a new topic: Message[E: 1st Post!, Topic Name: Topid 4] </li>
 *	    <li> Add a Post: Message[E2: 2nd Post!, Topid ID: 4] </li>
 *	    <li> Add a Post: Message[C2: 2nd Post!, Topid ID: 2] </li>
 *	    <li> Add a Post: Message[B2: 2nd Post!, Topid ID: 1] </li>
 *	    <li> Add a Post: Message[C3: 3rd Post!, Topid ID: 2] </li>
 *	    <li> Add a new topic: Message[F: 1st Post!, Topic Name: Topid 5] </li>
 *	    <li> Add a Post: Message[I: 1st Post!, Topid ID: 9] </li>
 *	    <li> Add a Post: Message[A2: 2nd Post!, Topid ID: 0] </li>
 *  </ul>
 */

public class MessageBoard {

    public static void main(String[] args){

        SortedList list = new SortedList();
        list.addNewTopic(new Message("A","1st Post!"), "Topic 0");
        list.addNewTopic(new Message("B","1st Post!"), "Topic 1");
        list.addNewTopic(new Message("C","1st Post!"), "Topic 2");
        list.addNewTopic(new Message("D","1st Post!"), "Topic 3");
        list.addNewTopic(new Message("E","1st Post!"), "Topic 4");

        list.addPost(new Message("E2","2nd Post!"),4);
        list.addPost(new Message("C2","2nd Post!"),2);
        list.addPost(new Message("B2","2nd Post!"),1);
        list.addPost(new Message("C3","3rd Post!"),2);

        list.addNewTopic(new Message("F","1st Post!"), "Topic 5");

        list.addPost(new Message("I","2nd Post!"),9);
        list.addPost(new Message("A2","2nd Post!"),0);

        System.out.print(list);
    }
}
