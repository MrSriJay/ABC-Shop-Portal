package abc.springframework.springwebapp.services;


import abc.springframework.springwebapp.domain.Product;
import abc.springframework.springwebapp.repositories.ProductRepsitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {

    @Autowired
    private ProductRepsitory productRepsitory;

    public List<Product>  listAll(){
        return (List<Product>) productRepsitory.findAll();
    }

    public void  save(Product product){
        productRepsitory.save(product);
    }

    public Product get(long id){
        return  productRepsitory.findById(id).get();
    }


    public void  delete(long id){

         productRepsitory.deleteById(id);
    }


}
