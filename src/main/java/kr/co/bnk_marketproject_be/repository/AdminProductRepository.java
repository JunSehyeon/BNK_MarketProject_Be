package kr.co.bnk_marketproject_be.repository;

import kr.co.bnk_marketproject_be.entity.Products;
import kr.co.bnk_marketproject_be.repository.custom.AdminProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminProductRepository extends JpaRepository<Products,String>, AdminProductRepositoryCustom {
}
