package be.technifutur.Labo3.model.services;

import be.technifutur.Labo3.model.dtos.ProductDTO;
import be.technifutur.Labo3.model.entities.Product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements Crudable<Product, ProductDTO, Integer>{

    @Override
    public List<ProductDTO> getAll() {
        return null;
    }

    @Override
    public ProductDTO getById(Integer integer) {
        return null;
    }

    @Override
    public boolean insert(Product product) {
        return false;
    }

    @Override
    public boolean update(Product product, Integer integer) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
