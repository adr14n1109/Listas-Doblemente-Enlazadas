
public class MiListaDoble implements ListInterface {

    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    public MiListaDoble() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object getHead() {
        return (head == null) ? null : head.dato;
    }

    @Override
    public Object getTail() {
        return (tail == null) ? null : tail.dato;
    }

    @Override
    public Object get(DoubleNode node) {
        return (node == null) ? null : node.dato;
    }

    @Override
    public DoubleNode search(Object object) {
        DoubleNode temp = head;
        while (temp != null) {
            if (temp.dato == null ? object == null : temp.dato.equals(object)) {
                return temp;
            }
            temp = temp.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

    @Override
    public boolean insert(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }

        DoubleNode nuevo = new DoubleNode(object);

        if (node == head) {
            nuevo.siguiente = head;
            nuevo.anterior = null;
            head.anterior = nuevo;
            head = nuevo;
        } else {
            DoubleNode anteriorNode = node.anterior;
            nuevo.anterior = anteriorNode;
            nuevo.siguiente = node;
            anteriorNode.siguiente = nuevo;
            node.anterior = nuevo;
        }

        size++;
        return true;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        DoubleNode nodeRef = search(objectRef);
        if (nodeRef == null) {
            return false;
        }
        return insert(nodeRef, object);
    }

    @Override
    public boolean insertHead(Object object) {
        DoubleNode nuevo = new DoubleNode(object);
        if (isEmpty()) {
            head = nuevo;
            tail = nuevo;
        } else {
            nuevo.siguiente = head;
            head.anterior = nuevo;
            head = nuevo;
        }
        size++;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        DoubleNode nuevo = new DoubleNode(object);
        if (isEmpty()) {
            head = nuevo;
            tail = nuevo;
        } else {
            nuevo.anterior = tail;
            tail.siguiente = nuevo;
            tail = nuevo;
        }
        size++;
        return true;
    }

    @Override
    public boolean set(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }
        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(DoubleNode node) {
        if (node == null || isEmpty()) {
            return false;
        }

        DoubleNode anteriorNode = node.anterior;
        DoubleNode siguienteNode = node.siguiente;

        if (anteriorNode != null) {
            anteriorNode.siguiente = siguienteNode;
        } else {
            head = siguienteNode; // node era la cabeza
        }

        if (siguienteNode != null) {
            siguienteNode.anterior = anteriorNode;
        } else {
            tail = anteriorNode; // node era la cola
        }

        node.anterior = null;
        node.siguiente = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        DoubleNode temp = head;
        int i = 0;
        while (temp != null) {
            array[i++] = temp.dato;
            temp = temp.siguiente;
        }
        return array;
    }

    @Override
    public Object[] toArray(Object[] object) {
        if (object.length < size) {
            object = new Object[size];
        }
        DoubleNode temp = head;
        int i = 0;
        while (temp != null) {
            object[i++] = temp.dato;
            temp = temp.siguiente;
        }
        if (object.length > size) {
            object[size] = null;
        }
        return object;
    }

    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {
        MiListaDoble sub = new MiListaDoble();
        if (from == null || to == null) {
            return sub;
        }

        DoubleNode temp = from;
        while (temp != null) {
            sub.insertTail(temp.dato);
            if (temp == to) {
                break;
            }
            temp = temp.siguiente;
        }
        return sub;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MiListaDoble sortList() {
        MiListaDoble sorted = new MiListaDoble();

        DoubleNode temp = head;
        while (temp != null) {
            Comparable<Object> actual = (Comparable<Object>) temp.dato;
            DoubleNode nodoSorted = sorted.head;

            while (nodoSorted != null && actual.compareTo(nodoSorted.dato) > 0) {
                nodoSorted = nodoSorted.siguiente;
            }

            if (nodoSorted == null) {
                sorted.insertTail(temp.dato);
            } else {
                sorted.insert(nodoSorted, temp.dato);
            }

            temp = temp.siguiente;
        }
        return sorted;
    }


    public boolean update(Object valorViejo, Object valorNuevo) {
        DoubleNode temp = head;
        while (temp != null) {
            if (temp.dato == null ? valorViejo == null : temp.dato.equals(valorViejo)) {
                temp.dato = valorNuevo;
                return true;
            }
            temp = temp.siguiente;
        }
        return false;
    }

    public boolean delete(Object elementoABorrar) {
        DoubleNode node = search(elementoABorrar);
        return remove(node);
    }

    public void recorrerAdelante() {
        StringBuilder sb = new StringBuilder("null");
        DoubleNode temp = head;
        while (temp != null) {
            sb.append(" <-> ").append(temp.dato);
            temp = temp.siguiente;
        }
        sb.append(" <-> null");
        System.out.println(sb);
    }

    public void recorrerAtras() {
        StringBuilder sb = new StringBuilder("null");
        DoubleNode temp = tail;
        while (temp != null) {
            sb.append(" <-> ").append(temp.dato);
            temp = temp.anterior;
        }
        sb.append(" <-> null");
        System.out.println(sb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        DoubleNode temp = head;
        while (temp != null) {
            sb.append(temp.dato);
            if (temp.siguiente != null) {
                sb.append(", ");
            }
            temp = temp.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}