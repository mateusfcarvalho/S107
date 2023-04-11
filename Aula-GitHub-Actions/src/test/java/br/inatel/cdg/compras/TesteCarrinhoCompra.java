package br.inatel.cdg.compras;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCarrinhoCompra {


	// Teste inicial básico (Padrão 1)
	@Test
	public void testSomaTotalCompra() throws NumeroNegativoException {

		Brownie Chocolate = new Brownie("Brownie de Chocolate", 3, 9);
		Brownie Baunilha = new Brownie("Brownie Baunilha", 3, 6);
		Brownie Nutela = new Brownie("Brownie Nutela", 1, 10);

		CarrinhoCompra carrinho = new CarrinhoCompra();

		carrinho.adiciona(Chocolate);
		carrinho.adiciona(Baunilha);
		carrinho.adiciona(Nutela);

		assertEquals(25, carrinho.somaTotal(),0.01);

	}


	// Teste inicial básico (Padrão 1) + algo diferente (teste valor total de itens) (Padrão 2)
	@Test
	public void testSomaTotalQtd() throws NumeroNegativoException {

		Brownie Chocolate = new Brownie("Brownie de Chocolate", 3, 9);
		Brownie Baunilha = new Brownie("Brownie Baunilha", 8, 16);
		Brownie Nutela = new Brownie("Brownie Nutela", 2, 20);

		CarrinhoCompra carrinho = new CarrinhoCompra();

		carrinho.adiciona(Chocolate);
		carrinho.adiciona(Baunilha);
		carrinho.adiciona(Nutela);

		assertEquals(45, carrinho.somaTotal(),0.01);

	}

	// Teste negativo (Padrão 3) forçando uma situação inesperada
	@Test(expected = NumeroNegativoException.class)
	public void testSomaNegativo() throws NumeroNegativoException {

		Brownie Chocolate = new Brownie("Brownie de Chocolate", -3, 9);
		Brownie Baunilha = new Brownie("Brownie Baunilha", -3, 6);
		Brownie Nutela = new Brownie("Brownie Nutela", -1, 10);

		CarrinhoCompra carrinho = new CarrinhoCompra();

		carrinho.adiciona(Chocolate);
		carrinho.adiciona(Baunilha);
		carrinho.adiciona(Nutela);

	}

	// Teste integração (Padrão 4) 2 classes (Carrinho e Cupom sendo testadas juntas).
	@Test
	public void testIntegracaoCupom() throws NumeroNegativoException, DescontoException {

		Brownie Chocolate = new Brownie("Brownie de Chocolate", 3, 9);
		Brownie Baunilha = new Brownie("Brownie Baunilha", 3, 6);
		Brownie Nutela = new Brownie("Brownie Nutela", 1, 10);

		CarrinhoCompra carrinho = new CarrinhoCompra();
		CupomDesconto cupom = new CupomDesconto(0.50);
		carrinho.setCupom(cupom);

		carrinho.adiciona(Chocolate);
		carrinho.adiciona(Baunilha);
		carrinho.adiciona(Nutela);
		carrinho.somaTotal();

		assertEquals(22.5, carrinho.somaTotal(), 0.1);

	}

	// Teste integração (Padrão 4) 2 classes (Carrinho e Cupom sendo testadas juntas).
	//Teste desconto 100%
	@Test
	public void testIntegracaoCupom() throws NumeroNegativoException, DescontoException {

		Brownie Chocolate = new Brownie("Brownie de Chocolate", 3, 9);
		Brownie Baunilha = new Brownie("Brownie Baunilha", 3, 6);
		Brownie Nutela = new Brownie("Brownie Nutela", 1, 10);

		CarrinhoCompra carrinho = new CarrinhoCompra();
		CupomDesconto cupom = new CupomDesconto(0.100);
		carrinho.setCupom(cupom);

		carrinho.adiciona(Chocolate);
		carrinho.adiciona(Baunilha);
		carrinho.adiciona(Nutela);
		carrinho.somaTotal();


	}

	//Teste Desconto 120%
	@Test(expected = DescontoException.class)
	public void testSomaNegativo() throws NumeroNegativoException {

		Brownie Chocolate = new Brownie("Brownie de Chocolate", 3, 9);
		Brownie Baunilha = new Brownie("Brownie Baunilha", 3, 6);
		Brownie Nutela = new Brownie("Brownie Nutela", 1, 10);

		CarrinhoCompra carrinho = new CarrinhoCompra();
		CupomDesconto cupom = new CupomDesconto(0.120);
		carrinho.setCupom(cupom);

		carrinho.adiciona(Chocolate);
		carrinho.adiciona(Baunilha);
		carrinho.adiciona(Nutela);

	}

	//Teste Desconto 200% Aplicada a 1 produto
	@Test(expected = DescontoException.class)
	public void testSomaNegativo() throws NumeroNegativoException {

		Brownie Chocolate = new Brownie("Brownie de Chocolate", 3, 9);

		CarrinhoCompra carrinho = new CarrinhoCompra();
		CupomDesconto cupom = new CupomDesconto(0.200);
		carrinho.setCupom(cupom);

		carrinho.adiciona(Chocolate);
	}

	// Teste integração (Padrão 4) 2 classes (Carrinho e Cupom sendo testadas juntas). - Falso
	@Test
	public void testIntegracaoCupom() throws NumeroNegativoException, DescontoException {

		Brownie Chocolate = new Brownie("Brownie de Chocolate", 3, 9);
		Brownie Baunilha = new Brownie("Brownie Baunilha", 3, 6);
		Brownie Nutela = new Brownie("Brownie Nutela", 1, 10);

		CarrinhoCompra carrinho = new CarrinhoCompra();
		CupomDesconto cupom = new CupomDesconto(0.50);
		carrinho.setCupom(cupom);

		carrinho.adiciona(Chocolate);
		carrinho.adiciona(Baunilha);
		carrinho.adiciona(Nutela);
		carrinho.somaTotal();

		assertFalse(21, carrinho.somaTotal(), 0.1);

	}

	// Teste inicial básico (Padrão 1) - Falso
	@Test
	public void testSomaTotalCompra() throws NumeroNegativoException {

		Brownie Chocolate = new Brownie("Brownie de Chocolate", 3, 9);
		Brownie Baunilha = new Brownie("Brownie Baunilha", 3, 6);
		Brownie Nutela = new Brownie("Brownie Nutela", 1, 10);

		CarrinhoCompra carrinho = new CarrinhoCompra();

		carrinho.adiciona(Chocolate);
		carrinho.adiciona(Baunilha);
		carrinho.adiciona(Nutela);

		assertFalse(90, carrinho.somaTotal(),0.01);

	}


	// Teste inicial básico (Padrão 1) + algo diferente (teste valor total de itens) (Padrão 2) - Falso
	@Test
	public void testSomaTotalQtd() throws NumeroNegativoException {

		Brownie Chocolate = new Brownie("Brownie de Chocolate", 3, 9);
		Brownie Baunilha = new Brownie("Brownie Baunilha", 8, 16);
		Brownie Nutela = new Brownie("Brownie Nutela", 2, 20);

		CarrinhoCompra carrinho = new CarrinhoCompra();

		carrinho.adiciona(Chocolate);
		carrinho.adiciona(Baunilha);
		carrinho.adiciona(Nutela);

		assertFalse(67, carrinho.somaTotal(),0.01);

	}