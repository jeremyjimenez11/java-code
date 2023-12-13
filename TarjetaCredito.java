import java.util.Scanner; 

public class TarjetaCredito{

    // Variables intanciadas
    private String propietarioTarjeta, fechaInicio, fechaExpira;
    private String tipoTarjeta, codigoTarjeta, numeroTarjeta;

    private String claveTarjeta, claveNueva, claveNuevaRev;
    private double saldoTarjeta;

    // Getters & Setters

    public String getPropietarioTarjeta(){
        return propietarioTarjeta;
    }
    public void setPropietarioTarjeta(String propietarioTarjeta){
        this.propietarioTarjeta = propietarioTarjeta;  
    }

    public String getFechaInicio(){
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio){
    this.fechaInicio = fechaInicio;
    }

    public String getFechaExpira(){
        return fechaExpira;
    }
    public void setFechaExpira(String fechaExpira){
        this.fechaExpira = fechaExpira; 
    }

    public String getTipoTarjeta(){
        return tipoTarjeta;
    }
    public void setTipoTarjeta(String tipoTarjeta){
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getCodigoTarjeta(){
        return codigoTarjeta;
    }
    public void setCodigoTarjeta(String codigoTarjeta){
        this.codigoTarjeta = codigoTarjeta; 
    }

    public String getNumeroTarjeta(){
        return numeroTarjeta;
    }
    public void setNumeroTarjeta(String numeroTarjeta){
        this.numeroTarjeta = numeroTarjeta; 
    }


    public String getClaveTarjeta(){
        return claveTarjeta;
    }
    public void setClaveTarjeta(String claveTarjeta){
        /* COMPROBACION de CLAVE
         * cantidad de caracteres
         * solo digitos
         */
        String observacion = ""; 
        observacion += (claveTarjeta.matches("\\d+")? "": "* Solo se aceptan numeros.\n");
        observacion += (claveTarjeta.length() == 4? "": "* Numero de caracteres no permitido.\n");
        if(observacion.isEmpty()){
            System.out.println(observacion += "* Clave Ingresada correctamente.\n"); 
            this.claveTarjeta = claveTarjeta;
        }
        else{
            System.out.println(observacion);
        }
        
    }

    public double getSaldoTarjeta(){
        return saldoTarjeta; 
    }
    public void setSaldoTarjeta(double saldoTarjeta){
        this.saldoTarjeta = saldoTarjeta; 
    }

    // METODOS

    public static String cambiarClave(String claveNueva, String claveNuevaRev, String claveAnterior){
        String observacion = "";
        observacion +=  (!claveNueva.equals(claveAnterior)? "": "No usar claves anteriores.\n");
        observacion += (!claveNueva.equals(claveNuevaRev)? "Las claves no coinciden.\n": "");
        return observacion; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        TarjetaCredito creditCard = new TarjetaCredito();

        System.out.print("Propietario: ");
        String propietarioTarjeta = scanner.nextLine(); 
        creditCard.setPropietarioTarjeta(propietarioTarjeta); 
        
        System.out.print("Mes Inicio: ");
        String fechaInicio = scanner.nextLine();
        creditCard.setFechaInicio(fechaInicio); 
        
        System.out.print("Fecha Fin: ");
        String fechaExpira = scanner.nextLine();
        creditCard.setFechaExpira(fechaExpira); 
        
        System.out.print("Clave: ");
        String claveTarjeta = scanner.nextLine();
        creditCard.setClaveTarjeta(claveTarjeta);

        System.out.println("\t---Informacion de Tarjeta----");
        System.out.printf("%s%n%s%n%s%n%s%n%s%n",creditCard.getTipoTarjeta(), creditCard.getNumeroTarjeta(), 
        "Propietario: " + creditCard.getPropietarioTarjeta(), "Fecha Inicio: " + creditCard.getFechaInicio() + " \t\t Fecha Fin: " + creditCard.getFechaExpira(),
        "Codigo: " + creditCard.getCodigoTarjeta());

        System.out.println("Cambio de clave.");
        System.out.print("Clave nueva: ");
        String claveNueva = scanner.nextLine(); 
        System.out.print("Confirmacion: ");
        String claveNuevaRev = scanner.nextLine(); 
        if(cambiarClave(claveNueva, claveNuevaRev, claveTarjeta).isEmpty()){
            creditCard.setClaveTarjeta(claveNueva);
            System.out.printf("%s%s%n", "Nueva clave de tarjeta: ",  creditCard.getClaveTarjeta());
        }
        else{
            System.out.println(cambiarClave(claveNueva, claveNuevaRev, claveTarjeta));
            //System.out.printf("%s%s%n", "Nueva clave de tarjeta: ",  creditCard.getClaveTarjeta());
        }

        
        scanner.close();
    }
}