package es.udc.sistemasinteligentes.g2_18;

/** Clase Base apliacada donde no solo guardamos cada estado
 * sino que almacenamos mas informacion necesaria como la accion que se realizo para obtener el estado
 * el padre del nodo que nos permite reconstuir la solucion facilmente y los parametros coste y funcion de coste
 * necesarios para las busquedas informadas
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
    /**
    * Método de acceso al coste almacenado en el nodo devuelve un elemento tipo float
     * */
    public float getCoste() {
        return coste;
    }
    /**
     * Método de acceso a la funcion de coste del nodo devuelve un elemento de tipo float
    * */
    public float getF() {
        return f;
    }
    /**
     * Setter para porder modificar el coste de un nodo ya que este sew calcula dynamicamente mientras se
     * ejecuta el problema
     * */
    public void setCoste(float coste){
        this.coste = coste;
    }
    /**
     * Setter para poder modificar el valor de la funcion de coste del nodo ya que esta se calculara de forma
     * dinamica en la ejecucion del problema*/
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
