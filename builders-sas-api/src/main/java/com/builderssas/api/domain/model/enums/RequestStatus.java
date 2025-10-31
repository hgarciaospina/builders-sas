package com.builderssas.api.domain.model.enums;

public enum RequestStatus {
    PENDING,       // Solicitud creada, pendiente de revisión/aprobación
    APPROVED,      // Solicitud aprobada y lista para generar la orden
    REJECTED,      // Solicitud rechazada
    CANCELLED      // Solicitud cancelada por el arquitecto antes de aprobar
}
