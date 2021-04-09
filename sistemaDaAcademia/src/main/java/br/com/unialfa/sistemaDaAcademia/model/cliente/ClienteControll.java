package br.com.unialfa.sistemaDaAcademia.model.cliente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "")

public class ClienteControll {

    @Autowired
    private ClienteBusiness clienteBusiness;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Cliente> printarCliente(){


        return clienteBusiness.printarCliente();
    }

    @PostMapping(path="/add")
    public void cadastrarCliente (@RequestBody Cliente cliente){



        clienteBusiness.cadastrarCliente(cliente);
    }

    @PutMapping(path = "/edit")
    public void editarCliente(@RequestBody Cliente cliente){

        clienteBusiness.editarCliente(cliente);

    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarCliente(@PathVariable(name = "id") long id){

        clienteBusiness.deletarCliente(id);


    }



}
