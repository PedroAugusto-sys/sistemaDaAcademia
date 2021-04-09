package br.com.unialfa.sistemaDaAcademia.model.pedido;

import br.com.unialfa.sistemaDaAcademia.model.cliente.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido,Long> {

    public Iterable<Pedido> findByCliente(Cliente cliente);


}
