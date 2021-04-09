package br.com.unialfa.sistemaDaAcademia;

import br.com.unialfa.sistemaDaAcademia.model.cliente.Cliente;
import br.com.unialfa.sistemaDaAcademia.model.cliente.ClienteRepositorio;
import br.com.unialfa.sistemaDaAcademia.model.pedido.ItensPedido;
import br.com.unialfa.sistemaDaAcademia.model.pedido.ItensPedidoRepository;
import br.com.unialfa.sistemaDaAcademia.model.pedido.Pedido;
import br.com.unialfa.sistemaDaAcademia.model.pedido.PedidoRepository;
import br.com.unialfa.sistemaDaAcademia.model.produto.Produto;
import br.com.unialfa.sistemaDaAcademia.model.produto.ProdutoRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SistemaDaAcademiaApplication {


	@Autowired
	private ClienteRepositorio clienteRepositry;

	@Autowired
	private PedidoRepository pedidoRepostory;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ItensPedidoRepository itensPedidoRepository;

	public static void main(String[] args) {

		SpringApplication.run(SistemaDaAcademiaApplication.class, args);

	}
	//@Bean
	InitializingBean sendDataBase(){
		Cliente cliente = new Cliente();
		cliente.setNome("testNome");
		cliente.setCpf("111.111.111-11");
		cliente.setDataNascimento(LocalDate.now());
		cliente.setVersao(1);
		cliente.setSobreNome("TesteZ");
		clienteRepositry.save(cliente);

		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataCriacaoPedido(LocalDate.now());
		pedido.setDataUltimaAtualizacao(LocalDate.now());
		pedido.setDataConclusao(LocalDate.now());
		pedido.setSubtotal(BigDecimal.ZERO);
		pedido.setTotal(BigDecimal.ZERO);
		pedido.setValorFrete(BigDecimal.ZERO);



		pedidoRepostory.save(pedido);

		List<Produto> produtos = new ArrayList<>();

		Produto produto = new Produto();
		produto.setAtivo(true);
		produto.setNome("produto1");
		produto.setDescricao("Produto teste 1");
		produto.setPreco(BigDecimal.valueOf(10.00));
		produtos.add(produto);

		Produto produto2 = new Produto();
		produto.setAtivo(true);
		produto.setNome("cocacola2");
		produto.setDescricao("Produto teste 2");
		produto.setPreco(BigDecimal.valueOf(5.00));
		produtos.add(produto2);


		produtoRepository.saveAll(produtos);

		List<ItensPedido> itensPedidos = new ArrayList<>();
		ItensPedido itensPedido = new ItensPedido(pedido, produto, 1);

		ItensPedido itensPedido2 = new ItensPedido(pedido, produto2, 50);
		itensPedidos.add(itensPedido);
		itensPedidos.add(itensPedido2);

		itensPedidoRepository.saveAll(itensPedidos);


		return null;















	}

}






























