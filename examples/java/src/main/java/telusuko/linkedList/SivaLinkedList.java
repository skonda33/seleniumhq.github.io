package telusuko.linkedList;

public class SivaLinkedList {

    SivaNode headNode;

    public void add(int data) {
        SivaNode newNode = new SivaNode();
        newNode.setData(data);
        newNode.setNext(null);

        if (headNode == null) {

            headNode = newNode;
        } else {
//reach to end node to that we can add the new node to end
            //we are starting with head node and trying to reach end node
            SivaNode endNode = headNode;
            while (endNode.getNext() != null) {
                endNode = endNode.getNext();

            }
            //if the head node is the end node then set new
            //node refference in head node , node address

            endNode.setNext(newNode);

        }

    }

    public void printAll(){
        SivaNode  startNode = headNode;

        while (startNode.getNext()!=null){

            System.out.println(startNode.getData());
            startNode = startNode.getNext();
        }
        System.out.println(startNode.getData());
    }
}
