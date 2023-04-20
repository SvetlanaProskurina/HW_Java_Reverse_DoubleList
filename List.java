public class List {
  Node head;// начало списка
  Node tail;// конец списка, поиск в двусвзном списке - сложность O(n)
//  Node node = new Node();
  public void add(int value){ // добавляем в конец
    Node node = new Node();
    node.value = value;
    if (head == null){
      head = node;
      tail = node;
    } else{ // Добавляем в конец списка
      tail.next = node;
      node.previous = tail;
      tail = node;
    }

  }
  public void addinside(int value, Node node){ // вставка нового значения после указанного node
    Node next = node.next;
    Node newnode = new Node();
    newnode.value = value;

    node.next = newnode;
    newnode.previous = node;
    if(next == null){
      tail = newnode;
    }else{
      next.previous = newnode;
      newnode.next = next;
    }

  }

  public void delete(Node node){
    Node previous = node.previous;
    Node next = node.next;
    if (previous == null){// если элемент в начале списка
      next.previous = null;
      head = next;
    }else{
      if(next == null){// если элемент в конце списка
        previous.next = null;
        tail = previous;
      }else{
        previous.next = next;
        next.previous = previous;
      }
    }
  }

  public void revers(){
    Node currentNode = head;
    while(currentNode != null){
      Node next = currentNode.next;
      Node previous = currentNode.previous;
      currentNode.next = previous;
      currentNode.previous = next;
      if (previous == null){
        tail = currentNode;
      }
      if (next == null){
        head = currentNode;
      }
      currentNode = next;
    }
  }
 public void printList(){
    Node temp = head;
    while (temp != null){
      System.out.println(temp.value);
      temp = temp.next;
    }
 }
  public Node find(int value){
    Node currentNode = head;
    while(currentNode != null){
    if (currentNode.value == value){
      return currentNode;
    }
    currentNode = currentNode.next;
    }
    return null;
  }



  public class Node{ // односвязный список, любое добавление в список это добавление ссылки на следующий элемент
    int value;
    Node next; // ссылка на следующую ноду

    Node previous; // ссылка на предыдущую ноду
  }
}
