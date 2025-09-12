package com.chechere.itsame;

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
            R.drawable.im_m_tired,
            R.drawable.im_p_tired,
            R.drawable.im_calm,
            R.drawable.im_chillin,
            R.drawable.im_angry,
            R.drawable.im_defenestration,
            R.drawable.im_happiness,
            R.drawable.im_illness,
            R.drawable.im_sad,
            R.drawable.im_slight_well_being,
            R.drawable.im_stress,
            R.drawable.im_sarcasm,
            R.drawable.im_suspicious,
            R.drawable.im_romantik
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
