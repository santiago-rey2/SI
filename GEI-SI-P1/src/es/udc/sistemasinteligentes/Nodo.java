package es.udc.sistemasinteligentes;

public class Nodo {
    private Estado es;
    private Accion ac;
    private Nodo fha;

    public Nodo(Estado es, Accion ac, Nodo fha) {
        this.es = es;
        this.ac = ac;
        this.fha = fha;
    }
    public Estado getEs() {
        return es;
    }
    public Accion getAc() {
        return ac;
    }
    public Nodo getFha() {
        return fha;
    }

    @Override
    public int hashCode() {
        return es.hashCode() + ac.hashCode();
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
