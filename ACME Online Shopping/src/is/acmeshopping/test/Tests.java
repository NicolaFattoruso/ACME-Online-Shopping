package is.acmeshopping.test;

import static org.junit.Assert.*;
import is.acmeshopping.entity.*;

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
	final int DASH = 0;
	final int ORALB = 1;
	final int SVELTO = 2;
	final int STANHOME = 3;
	final int GERARDO = 0;
	final int ANTONIO = 1;



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

		try
		{
			Carrello carrello1 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(DASH), 2)
					);
			Carrello carrello2 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(SVELTO), 1)
					);

			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello2.getCarrello(), 0);
		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(2, gCliente.getListaClienti()));
		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(GERARDO), 5));

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

		try
		{
			Carrello carrello1 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(DASH), 2)
					);
			Carrello carrello2 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(SVELTO), 1)
					);

			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello1.getCarrello(), 2);

		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(2, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(GERARDO), 5));

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

		try
		{
			Carrello carrello1 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(DASH), 2)
					);

			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello1.getCarrello(), 1);

		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(0, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(1, gCliente.getCliente(GERARDO), 4));
		oracolo.add(new Report(1, gCliente.getCliente(ANTONIO), 4));


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

		try
		{

			Carrello carrello1 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(DASH), 2)
					);
			Carrello carrello2 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(SVELTO), 1)
					);

			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello1.getCarrello(), 2);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello2.getCarrello(), 3);


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

		try
		{
			Carrello carrello1 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(DASH), 2)
					);

			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello1.getCarrello(), 1);

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

		try
		{
			Carrello carrello1 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(DASH),2)
					);
			Carrello carrello2 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(SVELTO), 1)
					);

			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello1.getCarrello(), 2);

		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(2, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(GERARDO), 5));


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

		try
		{
			Carrello carrello1 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(DASH), 2)
					);
			Carrello carrello2 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(SVELTO), 1)
					);

			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello1.getCarrello(), 2);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello2.getCarrello(), 3);


		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(2, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(GERARDO), 5));
		oracolo.add(new Report(2, gCliente.getCliente(ANTONIO), 5));


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

		try
		{
			Carrello carrello1 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(DASH), 2)
					);
			Carrello carrello2 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(SVELTO), 1)
					);

			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello1.getCarrello(), 2);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello2.getCarrello(), 3);


		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(1, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(GERARDO), 5));
		oracolo.add(new Report(2, gCliente.getCliente(ANTONIO), 5));


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

		try
		{
			Carrello carrello1 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(DASH), 2)
					);
			Carrello carrello2 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(SVELTO), 1)
					);


			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello1.getCarrello(), 2);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello2.getCarrello(), 3);


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

		try
		{
			Carrello carrello1 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(DASH), 2)
					);
			Carrello carrello2 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(SVELTO), 1)
					);

			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello1.getCarrello(), 2);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello2.getCarrello(), 3);


		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(2, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(GERARDO), 5));
		oracolo.add(new Report(2, gCliente.getCliente(ANTONIO), 5));


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

		try
		{
			Carrello carrello1 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(DASH), 2)
					);
			Carrello carrello2 = new Carrello(
					new QuantitaProdotti(gNegozio.getProdotto(SVELTO), 1)
					);

			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello1.getCarrello(), 0);
			gCliente.faiSpesa(gCliente.getCliente(GERARDO), carrello2.getCarrello(), 1);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello1.getCarrello(), 2);
			gCliente.faiSpesa(gCliente.getCliente(ANTONIO), carrello2.getCarrello(), 3);


		}
		catch (AcmeException e) {
			e.printStackTrace();
		}

		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(1, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();
		oracolo.add(new Report(2, gCliente.getCliente(GERARDO), 5));
		oracolo.add(new Report(2, gCliente.getCliente(ANTONIO), 5));


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


		ArrayList<Report> reports = new ArrayList<Report>(gNegozio.generaReport(1, gCliente.getListaClienti()));

		ArrayList<Report> oracolo = new ArrayList<Report>();


		for (Report report : reports)   { System.out.println(report); }

		assertEquals(oracolo, reports);
	}

}
