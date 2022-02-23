package es.udc.sistemasinteligentes;

/** La clase nodo seran los nodos utilizados en nuestro ejercicio
 * para almacenar la información necesaria para poder reconstruir la solucionç
 * del problema correctamente
 * */
public class Nodo {
    private Estado es;
    private Accion ac;
    private Nodo fha;

    /** Constructor de Nodo  es necesario pasarle un Estado una accion y un padre a cada nodo
     * el primer nodo de cada resolución llevará siempre los parametros ac y fha a null ya que
     * al ser el primero no tendrá ni padre ni acciones definidas que lo lleven a el.
     * */
    public Nodo(Estado es, Accion ac, Nodo fha) {
        this.es = es;
        this.ac = ac;
        this.fha = fha;
    }

    /**
     * Método de acceso a al estado almacenado en el nodo devuelve un elemento tipo Estado
     * */
    public Estado getEs() {
        return es;
    }
    /**
     * Método de acceso a la acción almacenado en el nodo devuelve un elemento tipo Accion
     * */
    public Accion getAc() {
        return ac;
    }
    /**
     * Método de acceso al padre del  nodo devuelve un elemento tipo Nodo
     * */
    public Nodo getFha() {
        return fha;
    }

    @Override
    public int hashCode() {
            return es.hashCode() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return hashCode() == o.hashCode();
    }

    @Override
    public String toString() {
        if(ac == null && fha == null){
            return "Nodo {" + "es=" + es.toString() + ", ac= Ninguno"  + ", fha = Ninguno }'";
        }else{
            return "Nodo {" + "es=" + es.toString() + ", ac=" + ac.toString() + ", fha=" + hashCode() +'}';
        }
    }
}
