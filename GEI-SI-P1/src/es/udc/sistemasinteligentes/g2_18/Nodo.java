package es.udc.sistemasinteligentes.g2_18;

/** La clase nodo seran los nodos utilizados en nuestro ejercicio
 * para almacenar la información necesaria para poder reconstruir la solucionç
 * del problema correctamente
 * */
public class Nodo {
    private Estado estado;
    private Accion action;
    private Nodo father;
    private float coste;
    private float f;

    /** Constructor de Nodo  es necesario pasarle un Estado una accion y un padre a cada nodo
     * el primer nodo de cada resolución llevará siempre los parametros ac y fha a null ya que
     * al ser el primero no tendrá ni padre ni acciones definidas que lo lleven a el.
     * */
    public Nodo(Estado es, Accion ac, Nodo fha,float coste,float funcion) {
        this.estado = es;
        this.action = ac;
        this.father = fha;
        this.coste = coste;
        this.f = funcion;
    }

    /**
     * Método de acceso a al estado almacenado en el nodo devuelve un elemento tipo Estado
     * */
    public Estado getEs() {
        return estado;
    }
    /**
     * Método de acceso a la acción almacenado en el nodo devuelve un elemento tipo Accion
     * */
    public Accion getAc() {
        return action;
    }
    /**
     * Método de acceso al padre del  nodo devuelve un elemento tipo Nodo
     * */
    public Nodo getFha() {
        return father;
    }

    public float getCoste() {
        return coste;
    }

    public float getF() {
        return f;
    }

    public void setCoste(float coste){
        this.coste = coste;
    }

    public void setFunction(float funcion){
        this.f = funcion;
    }

    @Override
    public int hashCode() {
            return estado.hashCode() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return hashCode() == o.hashCode();
    }

    @Override
    public String toString() {
        if(action == null && father == null){
            return "Nodo {" + "es=" + estado.toString() + ", ac= Ninguno"  + ", fha = Ninguno }'";
        }else{
            return "Nodo {" + "es=" + estado.toString() + ", ac=" + action.toString() + ", fha=" + father.hashCode() +'}';
        }
    }

}
