package net.unitech.financeiro

class PeriodoObrigacao {

	String indicador
	String descricao
	Date inicio = new Date()
	Date fim

    static constraints = {
    	indicador nullable: false, unique: true
    	descricao nullable: false 
    }

    static mapping = {
    	table "PERIODO_OBRIGACAO"
    	id column: "PEOB_SQ_PERIODO_OBRIG"
    	descricao column: "PEOB_DS_PERIODO_OBRIG", sqlType: "varchar2", length: 40
    	inicio column: "PEOB_DT_INICIO" 
    	fim column: "PEOB_DT_FIM"  
    }
	
	String toString() {
		return indicador
	}
}
