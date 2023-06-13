package com.tingeso.grasaSolidoservice.repositories;

import com.tingeso.grasaSolidoservice.entities.GrasaSolidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GrasaSolidoRepository extends JpaRepository<GrasaSolidoEntity, String> {

    //Obtener grasaSolido por proveedor
    @Query(value = "select * from grasas a where a.proveedor = :proveedor", nativeQuery = true)
    public GrasaSolidoEntity findGSByProveedor(@Param("proveedor") String proveedor);


}
