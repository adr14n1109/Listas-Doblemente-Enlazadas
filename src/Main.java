public class Main {
    public static void main(String[] args) {
        MiListaDoble lista = new MiListaDoble();

        lista.insertTail(6);
        lista.insertTail(4);
        lista.insertTail(1);
        lista.insertTail(3);

        System.out.println("Lista inicial: " + lista);
        System.out.print("Recorrido adelante -> ");
        lista.recorrerAdelante();
        System.out.print("Recorrido atras    -> ");
        lista.recorrerAtras();

        System.out.println("\nTamano: " + lista.getSize());
        System.out.println("Cabeza: " + lista.getHead());
        System.out.println("Cola:   " + lista.getTail());

        DoubleNode nodo1 = lista.search(1);
        System.out.println("\ncontains(1): " + lista.contains(1));
        System.out.println("search(1) encontrado con dato: " + lista.get(nodo1));

        lista.insertHead(9);
        System.out.println("\nDespues de insertHead(9): " + lista);

        DoubleNode nodoUno = lista.search(1);
        lista.insert(nodoUno, 99);
        System.out.println("Despues de insertar 99 antes de 1: " + lista);

        lista.update(1, 0);
        System.out.println("\nDespues de update(1, 0): " + lista);

        lista.delete(0);
        System.out.println("Despues de delete(0): " + lista);

        DoubleNode nodoCola = lista.search(3);
        lista.set(nodoCola, 30);
        System.out.println("\nDespues de set(nodo(3), 30): " + lista);

        Object[] arreglo = lista.toArray();
        System.out.print("\ntoArray(): ");
        for (Object o : arreglo) {
            System.out.print(o + " ");
        }
        System.out.println();

        DoubleNode desde = lista.search(4);
        DoubleNode hasta = lista.search(30);
        MiListaDoble sub = lista.subList(desde, hasta);
        System.out.println("subList(4, 30): " + sub);

        MiListaDoble ordenada = lista.sortList();
        System.out.println("\nsortList(): " + ordenada);

        DoubleNode nodoAEliminar = lista.search(99);
        lista.remove(nodoAEliminar);
        System.out.println("\nDespues de remove(nodo(99)): " + lista);
        
        lista.clear();
        System.out.println("\nDespues de clear(): " + lista + " | isEmpty(): " + lista.isEmpty());
    }
}