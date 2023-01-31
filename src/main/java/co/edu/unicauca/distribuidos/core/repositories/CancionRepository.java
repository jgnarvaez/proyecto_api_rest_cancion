package co.edu.unicauca.distribuidos.core.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.distribuidos.core.models.CancionEntity;

@Repository
public class CancionRepository {
    private ArrayList<CancionEntity> listaDeCanciones;

    public CancionRepository() {
        this.listaDeCanciones = new ArrayList<CancionEntity>();
        cargarCanciones();
    }

    public List<CancionEntity> findAll() {
        System.out.println("Invocando a listarcanciones");
        return this.listaDeCanciones;
    }

    public CancionEntity findById(Integer codigo) {
        System.out.println("Invocando a consultar una canción");
        CancionEntity objCancion = null;

        for (CancionEntity cliente : listaDeCanciones) {
            if (cliente.getCodigo() == codigo) {
                objCancion = cliente;
                break;
            }
        }

        return objCancion;
    }

    public CancionEntity save(CancionEntity cancion) {
        System.out.println("Invocando a almacenar canción");
        CancionEntity objCancion = null;

        if (this.listaDeCanciones.add(cancion)) {
            objCancion = cancion;
        }

        return objCancion;
    }

    public CancionEntity update(Integer id, CancionEntity cancion) {
        System.out.println("Invocando a actualizar una canción");
        CancionEntity objCancion = null;

        for (int i = 0; i < this.listaDeCanciones.size(); i++) {
            if (this.listaDeCanciones.get(i).getCodigo() == id) {
                this.listaDeCanciones.set(i, cancion);
                objCancion = cancion;
                break;
            }
        }

        return objCancion;
    }

    public boolean delete(Integer codigo) {
        System.out.println("Invocando a eliminar una canción");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeCanciones.size(); i++) {
            if (this.listaDeCanciones.get(i).getCodigo() == codigo) {
                this.listaDeCanciones.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    private void cargarCanciones() {
        CancionEntity objCancion1 = new CancionEntity(100, "cancion1", "mp3", "autor1", 5.0);
        this.listaDeCanciones.add(objCancion1);
        CancionEntity objCancion2 = new CancionEntity(101, "cancion2", "flac", "autor2", 2.5);
        this.listaDeCanciones.add(objCancion2);
        CancionEntity objCancion3 = new CancionEntity(102, "cancion3", "flac", "autor3", 3.0);
        this.listaDeCanciones.add(objCancion3);
        CancionEntity objCancion4 = new CancionEntity(103, "cancion4", "mp3", "autor", 4.5);
        this.listaDeCanciones.add(objCancion4);
    }
}
