package fp.conflict.test;

import java.util.List;

import fp.conflict.Conflicto;
import fp.conflict.FactoriaConflicto;

public class TestFactoriaConflicto {

	public static void main(String[] args) {
		testLeerFichero("data/conflict_data_cod.csv");
		
		

	}
	private static void testLeerFichero(String fichero) {
		System.out.println("\ntestleerfichero");
		List<Conflicto> conflicto = FactoriaConflicto.leerConflicto(fichero);
		System.out.println("conflictos: " + conflicto);
	}
}
