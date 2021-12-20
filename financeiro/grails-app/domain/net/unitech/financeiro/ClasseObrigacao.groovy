package net.unitech.financeiro

class ClasseObrigacao {

	String descricao
	Date inicio = new Date()
	Date fim

    static constraints = {
    	descricao nullable: false, maxSize: 30 
    }

    static mapping = {
    	table "CLASSE_OBRIGACAO"
    	id column: "CLOB_SQ_CLASSE_OBRIG"
    	descricao column: "CLOB_DS_CLASSE_OBRIG", sqlType: "varchar2", length: 30
    	inicio column: "CLOB_DT_INICIO" 
    	fim column: "CLOB_DT_FIM"  
    }
	
	String toString() {
		return descricao
	}
}
