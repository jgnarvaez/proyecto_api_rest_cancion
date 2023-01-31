package co.edu.unicauca.distribuidos.core.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.models.CancionEntity;
import co.edu.unicauca.distribuidos.core.repositories.CancionRepository;
import co.edu.unicauca.distribuidos.core.services.DTO.CancionDTO;

@Service
public class CancionServiceImpl implements ICancionService {
    @Autowired
    private CancionRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CancionDTO> findAll() {

        List<CancionEntity> cancionesEntity = this.servicioAccesoBaseDatos.findAll();
        List<CancionDTO> cancionesDTO = this.modelMapper.map(cancionesEntity, new TypeToken<List<CancionDTO>>() {
        }.getType());
        return cancionesDTO;
    }

    @Override
    public CancionDTO findById(Integer codigo) {
        CancionEntity objCancionEntity = this.servicioAccesoBaseDatos.findById(codigo);
        CancionDTO cancionDTO = this.modelMapper.map(objCancionEntity, CancionDTO.class);
        return cancionDTO;
    }

    @Override
    public CancionDTO save(CancionDTO cancion) {
        CancionEntity cancionEntity = this.modelMapper.map(cancion, CancionEntity.class);
        CancionEntity objCancionEntity = this.servicioAccesoBaseDatos.save(cancionEntity);
        CancionDTO cancionDTO = this.modelMapper.map(objCancionEntity, CancionDTO.class);
        return cancionDTO;
    }

    @Override
    public CancionDTO update(Integer codigo, CancionDTO cancion) {
        CancionEntity cancionEntity = this.modelMapper.map(cancion, CancionEntity.class);
        CancionEntity cancionEntityActualizado = this.servicioAccesoBaseDatos.update(codigo, cancionEntity);
        CancionDTO cancionDTO = this.modelMapper.map(cancionEntityActualizado, CancionDTO.class);
        return cancionDTO;
    }

    @Override
    public boolean delete(Integer codigo) {
        return this.servicioAccesoBaseDatos.delete(codigo);
    }
}
