package org.mp.sesion02.mesas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class MunicipioTest {

    @Test
    public void testConstructor() {
        String nombreMunicipio = "Sevilla";
        String nombreProvincia = "Sevilla";

        Municipio municipio = new Municipio(nombreMunicipio, nombreProvincia);

        assertEquals(nombreMunicipio, municipio.getNombreMunicipio());
        assertEquals(nombreProvincia, municipio.getNombreProvincia());
        assertNull(municipio.getMesasElectorales());
    }

    @Test
    public void testGetNombreMunicipio() {
        String nombreMunicipio = "Sevilla";
        String nombreProvincia = "Sevilla";

        Municipio municipio = new Municipio(nombreMunicipio, nombreProvincia);

        assertEquals(nombreMunicipio, municipio.getNombreMunicipio());
    }

    @Test
    public void testGetNombreProvincia() {
        String nombreMunicipio = "Sevilla";
        String nombreProvincia = "Sevilla";

        Municipio municipio = new Municipio(nombreMunicipio, nombreProvincia);

        assertEquals(nombreProvincia, municipio.getNombreProvincia());
    }

    @Test
    public void testGetSetMesasElectorales() {
        String nombreMunicipio = "Sevilla";
        String nombreProvincia = "Sevilla";
        MesaElectoral[] mesas = new MesaElectoral[2];

        Municipio municipio = new Municipio(nombreMunicipio, nombreProvincia);
        municipio.setMesasElectorales(mesas);

        assertSame(mesas, municipio.getMesasElectorales());
    }

    @Test
    public void testToString() {
        String nombreMunicipio = "Sevilla";
        String nombreProvincia = "Sevilla";
        Ciudadano presidente = new Ciudadano("López", "García", "José", LocalDate.of(1980, 1, 1), "Universidad");
        Ciudadano vocal1 = new Ciudadano("Martínez", "Pérez", "Ana", LocalDate.of(1990, 2, 2), "Secundaria");
        Ciudadano vocal2 = new Ciudadano("Pérez", "Gómez", "María", LocalDate.of(2000, 3, 3), "Primaria");
        Ciudadano[] electoresMesa1 = new Ciudadano[]{presidente, vocal1, vocal2};
        MesaElectoral mesa1 = new MesaElectoral("Mesa 1", electoresMesa1);
        Ciudadano[] electoresMesa2 = new Ciudadano[]{vocal2, presidente, vocal1};
        MesaElectoral mesa2 = new MesaElectoral("Mesa 2", electoresMesa2);
        MesaElectoral[] mesas = new MesaElectoral[]{mesa1, mesa2};

        Municipio municipio = new Municipio(nombreMunicipio, nombreProvincia);
        municipio.setMesasElectorales(mesas);

        String expectedString = String.format(
                "Municipio{nombreMunicipio='%s'nombreProvincia='%s', mesasElectorales=[%s, %s]}",
                nombreMunicipio, nombreProvincia, mesa1, mesa2);

        assertEquals(expectedString, municipio.toString());
    }

    
}
