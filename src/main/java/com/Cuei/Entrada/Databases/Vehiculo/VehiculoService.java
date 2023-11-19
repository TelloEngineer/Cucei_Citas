/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cuei.Entrada.Databases.Vehiculo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josue
 */
@Service
public class VehiculoService {
    @Autowired
    VehiculoRepository vehiculo;
    
    public VehiculoModel getVehiculo(String placa){
        return this.vehiculo.getReferenceById(placa);
    }
    
    public List<VehiculoModel> getVehiculos(){
        return  this.vehiculo.findAll();
    }
     public Optional<VehiculoModel> getById(String placa){
        return this.vehiculo.findById(placa);
    }

    public VehiculoModel saveVehiculo(VehiculoModel vehiculo){
        return this.vehiculo.save(vehiculo);
    }

    public boolean isThere(String placa){
        return this.vehiculo.existsById(placa);
    }

    public boolean deleteVehiculo(String placa){
        Optional<VehiculoModel> entity;
        entity = this.vehiculo.findById(placa);
        if(entity == null){
            return false;
        }
        try{
            this.vehiculo.delete(entity.get());
            return true;
        }catch(Exception error){
            return false;
        }   
    }
}
