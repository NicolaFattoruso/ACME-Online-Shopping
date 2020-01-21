package is.acmeshopping.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import is.acmeshopping.control.GestioneClienti;
import is.acmeshopping.control.GestoreNegozio;
import is.acmeshopping.entity.AcmeException;
import is.acmeshopping.entity.Carrello;
import is.acmeshopping.entity.Report;

public class Tests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("\n~~ FINE TEST ~~");
	}

	@Test
	public void test1() {
		System.out.println("\n~~ TEST 1 ~~");
		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(1, gCliente.getListaClienti()));

		for(Report report : reports)
		{
			System.out.println(report);
		}
		assertEquals(0, reports.size());
	}

	@Test
	public void test2() {
		System.out.println("\n~~ TEST 2 ~~");
		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);

		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");

		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();
		try
		{
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(0), 2); 
			carrello2.aggiungiAlCarrello(gNegozio.getProdotto(2), 1); 

			gCliente.faiSpesa(gCliente.getCliente(0), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(0), carrello2.getCarrello(), 0);
		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(2, gCliente.getListaClienti()));
		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(0), 5));

		for (Report report : reports)   { System.out.println(report); }

		assertEquals(oracolo, reports);
	}

	@Test
	public void test3() {
		System.out.println("\n~~ TEST 3 ~~");
		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);

		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");
		gCliente.creaCliente("Antonio", "qwerty", "3356986709", "5333-1710-4387-7645");

		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();
		try
		{
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(0), 2); 
			carrello2.aggiungiAlCarrello(gNegozio.getProdotto(2), 1); 

			//Gerardo fa due spese, Antonio 1
			gCliente.faiSpesa(gCliente.getCliente(0), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(0), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello1.getCarrello(), 2);
			
		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(2, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(0), 5));

		for (Report report : reports)   { System.out.println(report); }

		assertEquals(oracolo, reports);
	}

	
	@Test
	public void test4() {
		System.out.println("\n~~ TEST 4 ~~");
		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);

		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");
		gCliente.creaCliente("Antonio", "qwerty", "3356986709", "5333-1710-4387-7645");

		Carrello carrello1 = new Carrello();
		try
		{
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(0), 2); 

			gCliente.faiSpesa(gCliente.getCliente(0), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello1.getCarrello(), 2);
			
		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(0, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(1, gCliente.getCliente(0), 4));
		oracolo.add(new Report(1, gCliente.getCliente(1), 4));
		

		for (Report report : reports)   { System.out.println(report); }

		assertEquals(oracolo, reports);
	}
	

	@Test
	public void test5() {
		System.out.println("\n~~ TEST 5 ~~");
		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);

		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");
		gCliente.creaCliente("Antonio", "qwerty", "3356986709", "5333-1710-4387-7645");

		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();
		try
		{
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(0), 2);
			carrello2.aggiungiAlCarrello(gNegozio.getProdotto(2), 1);

			gCliente.faiSpesa(gCliente.getCliente(0), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(0), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello1.getCarrello(), 2);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello2.getCarrello(), 3);

			
		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(1, null));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		
		for (Report report : reports)   { System.out.println(report); }

		assertEquals(oracolo, reports);
	}

	
	@Test
	public void test6() {
		System.out.println("\n~~ TEST 6 ~~");
		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);

		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");
		gCliente.creaCliente("Antonio", "qwerty", "3356986709", "5333-1710-4387-7645");

		Carrello carrello1 = new Carrello();
		try
		{
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(0), 2); 

			gCliente.faiSpesa(gCliente.getCliente(0), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello1.getCarrello(), 2);
			
		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(2, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		

		for (Report report : reports)   { System.out.println(report); }

		assertEquals(oracolo, reports);
	}

	@Test
	public void test7() {
		System.out.println("\n~~ TEST 7 ~~");
		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);

		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");
		gCliente.creaCliente("Antonio", "qwerty", "3356986709", "5333-1710-4387-7645");

		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();
		try
		{
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(0), 2); 
			carrello2.aggiungiAlCarrello(gNegozio.getProdotto(2), 1);

			gCliente.faiSpesa(gCliente.getCliente(0), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(0), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello1.getCarrello(), 2);
			
		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(2, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(0), 5));
		

		for (Report report : reports)   { System.out.println(report); }

		assertEquals(oracolo, reports);
	}
	
	@Test
	public void test8() {
		System.out.println("\n~~ TEST 8 ~~");
		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);

		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");
		gCliente.creaCliente("Antonio", "qwerty", "3356986709", "5333-1710-4387-7645");

		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();
		try
		{
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(0), 2); 
			carrello2.aggiungiAlCarrello(gNegozio.getProdotto(2), 1);

			gCliente.faiSpesa(gCliente.getCliente(0), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(0), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello1.getCarrello(), 2);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello2.getCarrello(), 3);

			
		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(2, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(0), 5));
		oracolo.add(new Report(2, gCliente.getCliente(1), 5));
		

		for (Report report : reports)   { System.out.println(report); }

		assertEquals(oracolo, reports);
	}

	
	@Test
	public void test9() {
		System.out.println("\n~~ TEST 9 ~~");
		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);

		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");
		gCliente.creaCliente("Antonio", "qwerty", "3356986709", "5333-1710-4387-7645");

		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();
		try
		{
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(0), 2); 
			carrello2.aggiungiAlCarrello(gNegozio.getProdotto(2), 1);

			gCliente.faiSpesa(gCliente.getCliente(0), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(0), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello1.getCarrello(), 2);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello2.getCarrello(), 3);

			
		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(1, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(0), 5));
		oracolo.add(new Report(2, gCliente.getCliente(1), 5));
		

		for (Report report : reports)   { System.out.println(report); }

		assertEquals(oracolo, reports);
	}
	
	@Test
	public void test10() {
		System.out.println("\n~~ TEST 10 ~~");
		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);

		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");
		gCliente.creaCliente("Antonio", "qwerty", "3356986709", "5333-1710-4387-7645");

		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();
		try
		{
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(0), 2);
			carrello2.aggiungiAlCarrello(gNegozio.getProdotto(2), 1);

			gCliente.faiSpesa(gCliente.getCliente(0), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(0), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello1.getCarrello(), 2);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello2.getCarrello(), 3);

			
		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(-1, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();


		for (Report report : reports)   { System.out.println(report); }

		assertEquals(oracolo, reports);
	}

	
	
	@Test
	public void test11() {
		System.out.println("\n~~ TEST 11 ~~");
		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);

		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");
		gCliente.creaCliente("Antonio", "qwerty", "3356986709", "5333-1710-4387-7645");

		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();
		try
		{
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(0), 2);
			carrello2.aggiungiAlCarrello(gNegozio.getProdotto(2), 1);

			gCliente.faiSpesa(gCliente.getCliente(0), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(0), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello1.getCarrello(), 2);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello2.getCarrello(), 3);

			
		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(2, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(0), 5));
		oracolo.add(new Report(2, gCliente.getCliente(1), 5));


		for (Report report : reports)   { System.out.println(report); }

		assertEquals(oracolo, reports);
	}
	
	@Test
	public void test12() {
		System.out.println("\n~~ TEST 12 ~~");
		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);

		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");
		gCliente.creaCliente("Antonio", "qwerty", "3356986709", "5333-1710-4387-7645");

		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();
		try
		{
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(0), 2);
			carrello2.aggiungiAlCarrello(gNegozio.getProdotto(2), 1);

			gCliente.faiSpesa(gCliente.getCliente(0), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(0), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello1.getCarrello(), 2);
			gCliente.faiSpesa(gCliente.getCliente(1), carrello2.getCarrello(), 3);

			
		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(1, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(0), 5));
		oracolo.add(new Report(2, gCliente.getCliente(1), 5));


		for (Report report : reports)   { System.out.println(report); }

		assertEquals(oracolo, reports);
	}
	
	@Test
	public void test13() {
		System.out.println("\n~~ TEST 13 ~~");
		GestioneClienti gCliente = new GestioneClienti();
		GestoreNegozio gNegozio = new GestoreNegozio();

		gNegozio.inserisciProdotto(0, "DASH", "Detersivo", 2.0f,  10);
		gNegozio.inserisciProdotto(1, "Oral-B", "Dentifricio", 0.90f,  15);
		gNegozio.inserisciProdotto(2, "SVELTO", "Detersivo per piatti", 1.00f,  9);
		gNegozio.inserisciProdotto(3, "Stan-Home", "Sgrassatore", 1.10f,  20);

		gCliente.creaCliente("Gerardo", "12345", "3365489604", "5333-1710-8765-2982");
		gCliente.creaCliente("Antonio", "qwerty", "3356986709", "5333-1710-4387-7645");

		Carrello carrello1 = new Carrello();
		Carrello carrello2 = new Carrello();
		try
		{
			carrello1.aggiungiAlCarrello(gNegozio.getProdotto(0), 2);
			carrello2.aggiungiAlCarrello(gNegozio.getProdotto(2), 1);

			
		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(1, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();


		for (Report report : reports)   { System.out.println(report); }

		assertEquals(oracolo, reports);
	}
	
	
}
