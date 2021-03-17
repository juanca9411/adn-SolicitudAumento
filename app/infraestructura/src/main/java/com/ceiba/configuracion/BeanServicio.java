package com.ceiba.configuracion;

import com.ceiba.puerto.repositorio.calendario.RepositorioDiaFestivo;
import com.ceiba.puerto.repositorio.funcionario.RepositorioFuncionario;
import com.ceiba.puerto.repositorio.solicitud.RepositorioSolicitud;
import com.ceiba.servicio.calendario.ServicioAgregarDiaFestivo;
import com.ceiba.servicio.funcionario.ServicioActualizarFuncionario;
import com.ceiba.servicio.funcionario.ServicioAumentarSalario;
import com.ceiba.servicio.funcionario.ServicioCrearFuncionario;
import com.ceiba.servicio.solicitud.ServicioCrearSolicitud;
import com.ceiba.servicio.solicitud.ServicioResolverSolicitud;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearFuncionario servicioCrearFuncionario(RepositorioFuncionario repositorioFuncionario) {
        return new ServicioCrearFuncionario(repositorioFuncionario);
    }

    @Bean
    public ServicioActualizarFuncionario servicioActualizarFuncionario(RepositorioFuncionario repositorioFuncionario) {
        return new ServicioActualizarFuncionario(repositorioFuncionario);
    }

    @Bean
    public ServicioCrearSolicitud servicioCrearSolicitud(RepositorioSolicitud repositorioSolicitud,RepositorioDiaFestivo repositorioDiaFestivo) {
        return new ServicioCrearSolicitud(repositorioSolicitud, repositorioDiaFestivo);
    }

    @Bean
    public ServicioResolverSolicitud servicioResolverSolicitud(RepositorioSolicitud repositorioSolicitud) {
        return new ServicioResolverSolicitud(repositorioSolicitud);
    }

    @Bean
    public ServicioAumentarSalario servicioAumentarSalario(RepositorioFuncionario repositorioFuncionario){
        return  new ServicioAumentarSalario(repositorioFuncionario);
    }

    @Bean
    public ServicioAgregarDiaFestivo servicioAgregarDiaFestivo (RepositorioDiaFestivo repositorioDiaFestivo){
        return new ServicioAgregarDiaFestivo(repositorioDiaFestivo);
    }
}
