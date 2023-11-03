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

    public VehiculoModel saveCitas(VehiculoModel vehiculo){
        return this.vehiculo.save(vehiculo);
    }

    public boolean deleteCitas(String placa){
        try{
            this.vehiculo.deleteById(placa);
            return true;
        }catch(Exception error){
            return false;
        }   
    }
}
