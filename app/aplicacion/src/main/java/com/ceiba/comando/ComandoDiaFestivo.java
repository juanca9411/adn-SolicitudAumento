package com.ceiba.comando;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoDiaFestivo {

    private Long codigoFecha;
    private String dia;
    private LocalDateTime fecha;


}
