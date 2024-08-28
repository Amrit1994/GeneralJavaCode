package Interview;

import java.util.LinkedList;

public class CustomHashMap implements CustomMap {

    LinkedList<Node> list = new LinkedList<>();
    @Override
    public boolean put(Object key, Object value) {
        if(get(key) != null) {
            Node existingNode = get(key);
            existingNode.value = value;
            list.add(existingNode);
        } else {
            Node node = new Node(key, value);
            list.add(node);
        }
        return true;
    }

    @Override
    public Node get(Object key) {
        return null;
    }

    @Override
    public boolean delete(Object key) {
        return false;
    }

    public int getHashCode(Object key) {
        return key.hashCode() % 16;
    }
}

 class Node {
    Object key;
    Object value;

     public Node(Object key, Object value) {
         this.key = key;
         this.value = value;
     }
 }
