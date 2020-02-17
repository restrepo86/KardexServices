

class ParametrosInformeAprobacion {

    fechaInicio;
    fechaFin;
    estado;
    estrategia;
    tienda;
    cddocumento;

    constructor(fechaInicio, fechaFin, estado, estrategia, tienda, cddocumento) {

        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.estrategia = estrategia;
        this.tienda = tienda;
        this.cddocumento = cddocumento;

    };

};

export default ParametrosInformeAprobacion;