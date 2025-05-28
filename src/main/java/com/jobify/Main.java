package com.jobify;

import com.jobify.dao.UsuarioDAO;
import com.jobify.model.Usuario;
import com.jobify.util.Conexion;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            // Crear un nuevo usuario
            Usuario nuevoUsuario = new Usuario(
                "Juan Pérez",
                "juan.nuevo@example.com", // Cambiamos el correo para evitar duplicados
                "password123",
                "cliente"
            );

            // Insertar usuario
            if (usuarioDAO.insertar(nuevoUsuario)) {
                System.out.println("Usuario insertado correctamente");
                
                // Verificar credenciales inmediatamente después de insertar
                Usuario usuarioAutenticado = usuarioDAO.verificarCredenciales(
                    nuevoUsuario.getCorreo(), 
                    "password123"
                );
                
                if (usuarioAutenticado != null) {
                    System.out.println("\nUsuario autenticado correctamente:");
                    System.out.println(usuarioAutenticado);
                } else {
                    System.out.println("\nCredenciales incorrectas");
                }
            }

            // Listar todos los usuarios
            System.out.println("\nLista de usuarios:");
            List<Usuario> usuarios = usuarioDAO.listar();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }

            // Actualizar un usuario
            if (!usuarios.isEmpty()) {
                Usuario usuarioActualizar = usuarios.get(0);
                usuarioActualizar.setNombre("Juan Pérez Actualizado");
                usuarioActualizar.setCorreo("juan.actualizado@example.com");
                usuarioActualizar.setContrasena("nuevaPassword456");
                usuarioActualizar.setTipoUsuario("proveedor");
                
                if (usuarioDAO.actualizar(usuarioActualizar)) {
                    System.out.println("\nUsuario actualizado correctamente");
                    
                    // Verificar credenciales después de actualizar
                    Usuario usuarioActualizado = usuarioDAO.verificarCredenciales(
                        usuarioActualizar.getCorreo(),
                        "nuevaPassword456"
                    );
                    
                    if (usuarioActualizado != null) {
                        System.out.println("Credenciales actualizadas verificadas correctamente");
                    }
                }
            }

            // Buscar usuario por ID
            if (!usuarios.isEmpty()) {
                Usuario usuarioEncontrado = usuarioDAO.buscarPorId(usuarios.get(0).getIdUsuario());
                if (usuarioEncontrado != null) {
                    System.out.println("\nUsuario encontrado por ID:");
                    System.out.println(usuarioEncontrado);
                }
            }

            // Eliminar un usuario
            // if (!usuarios.isEmpty()) {
            //     if (usuarioDAO.eliminar(usuarios.get(0).getIdUsuario())) {
            //         System.out.println("\nUsuario eliminado correctamente");
            //     }
            // }

        } catch (Exception e) {
            System.err.println("Error en la ejecución: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            Conexion.cerrarConexion();
        }
    }
} 