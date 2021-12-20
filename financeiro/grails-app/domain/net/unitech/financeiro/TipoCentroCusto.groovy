package net.unitech.financeiro

class TipoCentroCusto {

	String descricao
	Date inicio = new Date()
	Date fim

    static constraints = {
    	descricao nullable: false, maxSize: 30 
    }

    static mapping = {
    	table "TIPO_CENTRO_CUSTO"
    	id column: "TICC_SQ_TP_CENTRO_CUSTO"
    	descricao column: "TICC_DS_TP_CENTRO_CUSTO", sqlType: "varchar2", length: 30
    	inicio column: "TICC_DT_INICIO" 
    	fim column: "TICC_DT_FIM"  
    }
	
	String toString() {
		return descricao
	}
}
