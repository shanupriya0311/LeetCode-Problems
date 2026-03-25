class Node{
    int key,val;
    Node prev;
    Node next;
    Node(int key,int val){
        this.key=key;
        this.val=val;
        this.prev=null;
        this.next=null;
    }
}
class LRUCache {  
   public final int capacity;
    Map<Integer,Node>map;
    Node head,tail;
    public LRUCache(int capacity) {
         this.capacity=capacity;
         map=new HashMap<>();
        head=null;
        tail=head;
         
        }    
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node newnode=map.get(key);
            remove(newnode);
            insert(newnode);
            return newnode.val;
        }
        else{
            return -1;
        }
    } 
    
    public void put(int key, int value) {
         if(map.containsKey(key)){
            Node n=map.get(key);
            n.val=value;
            remove(n);
            insert(n);
            return;
         }
         if(map.size()==capacity){
            Node lru=tail;
            remove(lru);
            map.remove(lru.key);
         }
             Node newnode=new Node(key,value);
             map.put(key,newnode);
             insert(newnode);   
    }
    public void remove(Node node){
        if(head==tail){
            head=tail=null;
        }
        else if(head==node){
            head=head.next;
             if (head != null) head.prev = null;
        }
        else if(tail==node){
            tail.prev.next=null;
            tail=tail.prev;
        }
        else{
        node.prev.next=node.next;
        node.next.prev=node.prev;}
    }
    public void insert(Node node){
       if(head==null){
            head=node;
            tail=head;
       }
       else{
        node.next=head;
        node.prev=null;
        head.prev=node;
        head=node;
       }
       }}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */