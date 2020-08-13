public class Ciudad {
    private Provincia provincia;
    private String nombre;


    public Ciudad(String nombre, Provincia provincia) {
        this.provincia = provincia;
        this.nombre = nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public boolean equals(Ciudad ciudad) {
        return ciudad.getNombre().equals(this.getNombre());
    }

    private String getNombre() {
        return nombre;
    }
}
