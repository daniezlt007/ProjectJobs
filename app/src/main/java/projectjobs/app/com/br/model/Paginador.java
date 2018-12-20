package projectjobs.app.com.br.model;

public class Paginador {

    private int pagina;
    private int total_pagina;
    private int registros_por_pagina;
    private int total_registros;

    public Paginador() {

    }

    public Paginador(int pagina, int total_pagina, int registros_por_pagina, int total_registros) {
        this.pagina = pagina;
        this.total_pagina = total_pagina;
        this.registros_por_pagina = registros_por_pagina;
        this.total_registros = total_registros;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getTotal_pagina() {
        return total_pagina;
    }

    public void setTotal_pagina(int total_pagina) {
        this.total_pagina = total_pagina;
    }

    public int getRegistros_por_pagina() {
        return registros_por_pagina;
    }

    public void setRegistros_por_pagina(int registros_por_pagina) {
        this.registros_por_pagina = registros_por_pagina;
    }

    public int getTotal_registros() {
        return total_registros;
    }

    public void setTotal_registros(int total_registros) {
        this.total_registros = total_registros;
    }
}
