package models;

public class Resultado {
    private String algoritmo;
    private String escenario;
    private int sample;
    private double tiempoNano;
    private double tiempoMilis;

    public Resultado(String algoritmo, String escenario, int sample, double tiempoNano) {
        this.algoritmo = algoritmo;
        this.escenario = escenario;
        this.sample = sample;
        this.tiempoNano = tiempoNano;
        this.tiempoMilis = tiempoNano / 1000000.0;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public String getEscenario() {
        return escenario;
    }

    public int getSample() {
        return sample;
    }

    public double getTiempoNano() {
        return tiempoNano;
    }

    public double getTiempoMilis() {
        return tiempoMilis;
    }

    @Override
    public String toString() {
        return "Resultado [algoritmo=" + algoritmo + ", escenario=" + escenario + ", sample=" + sample 
        + ", tiempoMilis=" + tiempoMilis + "]";
    }

    

    
}
