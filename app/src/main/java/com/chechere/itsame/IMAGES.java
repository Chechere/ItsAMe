package com.chechere.itsame;

import android.content.Context;

import java.util.Random;

/**
 * Gestiona las imagenes que hay disponibles en la aplicación
 */
public class IMAGES {
    private static final int[] IMAGES = {
            R.drawable.im_cafeinated,
            R.drawable.im_depression,
            R.drawable.im_desvivition,
            R.drawable.im_distracted,
            R.drawable.im_gamer,
            R.drawable.im_hunger,
            R.drawable.im_inspired,
            R.drawable.im_tired,
    };

    private static final Random rnd = new Random();

    /**
     * Permite obtener una imagen de las disponibles
     * @param index Imagen a sacar
     * @return Devuelve la imagen deseada o, por defecto, una imagen aleatoria disponible.
     */
    public static int getImage(int index) {
        if(index < 0 || index >= IMAGES.length) {
            //Default Random Image
            index = rnd.nextInt(IMAGES.length);
        }

        return IMAGES[index];
    }
}
