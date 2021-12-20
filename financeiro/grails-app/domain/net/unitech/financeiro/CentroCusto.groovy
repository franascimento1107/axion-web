package net.unitech.financeiro

class CentroCusto {

	String descricao
	TipoCentroCusto tipoCentroCusto
	Date inicio = new Date()
	Date fim

    static constraints = {
    	descricao nullable: false 
    }

    static mapping = {
    	table "CENTRO_CUSTO"
    	id column: "CECU_SQ_CENTRO_CUSTO"
    	descricao column: "CECU_DS_CENTRO_CUSTO", sqlType: "varchar2", length: 40
    	inicio column: "CECU_DT_INICIO" 
    	fim column: "CECU_DT_FIM"  
    }
	
	String toString() {
		return descricao
	}
}
