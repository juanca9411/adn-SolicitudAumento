package com.ceiba.modelo.objetovalor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiasFestivos {

    private final static Date DIA_DE_SAN_JOSE = new Date("22/03/2021");
    private final static Date DOMINGO_DE_RAMOS = new Date("28/03/2021");
    private final static Date JUEVES_SANTO = new Date("01/04/2021");
    private final static Date VIERNES_SANTO = new Date("02/04/2021");
    private final static Date DOMINGO_DE_RESURRECCION = new Date("04/04/2021");
    private final static Date DIA_DEL_TRABAJO = new Date("01/05/2021");
    private final static Date DIA_DE_LA_ASENCION = new Date("17/05/2021");
    private final static Date CORPUS_CHRISTI = new Date("07/06/2021");
    private final static Date SAGRADO_CORAZON = new Date("14/06/2021");
    private final static Date SAN_PEDRO_Y_SAN_PABLO = new Date("05/07/2021");
    private final static Date DIA_DE_LA_INDEPENDENCIA = new Date("20/07/2021");
    private final static Date BATALLA_DE_BOYACA = new Date("07/08/2021");
    private final static Date LA_ASUNCION_DE_LA_VIRGEN = new Date("16/08/2021");
    private final static Date DIA_DE_LA_RAZA = new Date("18/10/2021");
    private final static Date TODOS_LOS_SANTOS = new Date("01/11/2021");
    private final static Date INDEPENDENCIA_DE_CARTAGENA = new Date("15/11/2021");
    private final static Date DIA_DE_LA_INMACULADA_CONCEPCION = new Date("08/12/2021");
    private final static Date DIA_DE_NAVIDAD = new Date("25/12/2021");


    public static List<Date> listarDiasFestivos(){
        List<Date> diasFestivos = new ArrayList<>();
            diasFestivos.add(DIA_DE_SAN_JOSE);
            diasFestivos.add(DOMINGO_DE_RAMOS);
            diasFestivos.add(JUEVES_SANTO);
            diasFestivos.add(VIERNES_SANTO);
            diasFestivos.add(DOMINGO_DE_RESURRECCION);
            diasFestivos.add(DIA_DEL_TRABAJO);
            diasFestivos.add(DIA_DE_LA_ASENCION);
            diasFestivos.add(CORPUS_CHRISTI);
            diasFestivos.add(SAGRADO_CORAZON);
            diasFestivos.add(SAN_PEDRO_Y_SAN_PABLO);
            diasFestivos.add(DIA_DE_LA_INDEPENDENCIA);
            diasFestivos.add(BATALLA_DE_BOYACA);
            diasFestivos.add(LA_ASUNCION_DE_LA_VIRGEN);
            diasFestivos.add(DIA_DE_LA_RAZA);
            diasFestivos.add(TODOS_LOS_SANTOS);
            diasFestivos.add(INDEPENDENCIA_DE_CARTAGENA);
            diasFestivos.add(DIA_DE_LA_INMACULADA_CONCEPCION);
            diasFestivos.add(DIA_DE_NAVIDAD);

     return diasFestivos;
    }
}
