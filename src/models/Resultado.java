package models;

import java.util.Locale;

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
        String tiempoFormateado = String.format(Locale.GERMAN, "%,.3f ms", tiempoMilis);
        return String.format("%-26s | %-9s | %-6d | %s",
                escenario, algoritmo, sample, tiempoFormateado);
    }

    

    
}
