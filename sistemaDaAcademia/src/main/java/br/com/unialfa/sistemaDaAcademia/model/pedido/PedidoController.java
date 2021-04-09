package br.com.unialfa.sistemaDaAcademia.model.pedido;


import br.com.unialfa.sistemaDaAcademia.model.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "")


public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping(path="/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Pedido> listarPedido(@PathVariable Long idCliente){
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        return pedidoRepository.findByCliente(cliente);
    }


    @PostMapping(path = "/add")
    public void cadastrarPedido( @RequestBody Pedido pedido ){

        pedidoRepository.save(pedido);
    }

    @PutMapping(path = "/edit")
    public void editarPdido( @RequestBody Pedido pedido ){

        pedidoRepository.save(pedido);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarPedido(@PathVariable(name = "id") long id){

        pedidoRepository.deleteById(id);
    }



}




