package co.edu.unicauca.distribuidos.core.services;

import java.util.List;
import co.edu.unicauca.distribuidos.core.services.DTO.CancionDTO;

public interface ICancionService {
    public List<CancionDTO> findAll();

    public CancionDTO findById(Integer codigo);

    public CancionDTO save(CancionDTO cancion);

    public CancionDTO update(Integer codigo, CancionDTO cancion);

    public boolean delete(Integer codigo);
}
