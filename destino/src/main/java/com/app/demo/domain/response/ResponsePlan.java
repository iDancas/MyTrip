package com.app.demo.domain.response;

import com.app.demo.domain.dto.PlanGuardadoDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePlan {
    private String mensaje;
    private boolean esValido;
    private PlanGuardadoDTO planGuardado;
    private List<PlanGuardadoDTO> listaPlanesGuardados;
}
