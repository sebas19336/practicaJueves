import java.util.Scanner;

public class prueba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaCircularDoblementeLigada m = new ListaCircularDoblementeLigada();
        int opt;
        boolean band;
        do {
        System.out.println("lista circular doblemente ligada ");
        System.out.println("1.Agregar en cola");
        System.out.println("2.Eliminar valor especifico");
        System.out.println("3.Mostrar adelante");
        System.out.println("4.Mostrar atras");
        switch (opt=sc.nextInt()) {
            case 1:
                System.out.println("Ingrese un valor: ");
                int p = sc.nextInt();
                m.agregar(p);
                break;
            case 2:
                System.out.println("Que valor desea eliminar? ");
                int l =sc.nextInt();
                m.eliminar(l);
                break;
            case 3:
                m.adelante();
                break;
            case 4:
                m.atras();
                break;
            default:
                break;
        }
        System.out.println("desea continuar? 1.si 2.no");
        int q =sc.nextInt();
        if (q==1) {
            band = false;
        }else{
            band= true;
        }
        } while (!band);
    }
}

class Nodo {
    int o;
    Nodo next;
    Nodo prev;

    public Nodo(int o) {
        this.o = o;
    }

    public int getO() { return o; }
    public void setO(int o) { this.o = o; }
    public Nodo getNext() { return next; }
    public void setNext(Nodo next) { this.next = next; }
    public Nodo getPrev() { return prev; }
    public void setPrev(Nodo prev) { this.prev = prev; }
}

class ListaCircularDoblementeLigada {
    Nodo head;
    Nodo tail;
    int length;

    public ListaCircularDoblementeLigada() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void agregar(int o) {
        Nodo n = new Nodo(o);
        if (head == null) {
            head = n;
            tail = n;
            head.setNext(head);
            head.setPrev(head);
        } else {
            n.setPrev(tail);
            n.setNext(head);
            tail.setNext(n);
            head.setPrev(n);
            tail = n;
        }
        length++;
    }

    public int eliminar(int valor) {
        if (head == null) {
            return -1;
        }
        Nodo actual = head;
        do {
            if (actual.getO() == valor) {
                if (actual == head && actual == tail) {
                    head = null;
                    tail = null;
                } else {
                    actual.getPrev().setNext(actual.getNext());
                    actual.getNext().setPrev(actual.getPrev());
                    if (actual == head) head = actual.getNext();
                    if (actual == tail) tail = actual.getPrev();
                }
                length--;
                return valor;
            }
            actual = actual.getNext();
        } while (actual != head);
        return -1;
    }

    public void adelante() {
        if (head == null) return;
        Nodo temp = head;
        do {
            System.out.print(temp.getO() + " ");
            temp = temp.getNext();
        } while (temp != head);
        System.out.println();
        System.out.println("tamaño: "+length);
    }

    public void atras() {
        if (tail == null) return;
        Nodo temp = tail;
        do {
            System.out.print(temp.getO() + " ");
            temp = temp.getPrev();
        } while (temp != tail);
        System.out.println();
        System.out.println("tamaño: "+length);
        }
}