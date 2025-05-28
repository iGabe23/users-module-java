package com.jobify.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    
    /**
     * Encripta una contraseña usando BCrypt
     * @param password Contraseña en texto plano
     * @return Contraseña encriptada
     */
    public static String encriptar(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    
    /**
     * Verifica si una contraseña coincide con su hash
     * @param password Contraseña en texto plano
     * @param hash Hash de la contraseña
     * @return true si la contraseña coincide, false en caso contrario
     */
    public static boolean verificar(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
} 