package com.lexadecimals.losersclub;

import com.lexadecimals.losersclub.model.Album;

public final class TestDataUtil {
    public TestDataUtil() {
    }

    public static Album createTestAlbum1() {
        return Album.builder()
                .title("Wish You Were Here")
                .year(1975)
                .artist("Pink Floyd")
                .genre("Progressive Rock")
                .build();
    }

    public static Album createTestAlbum2() {
        return Album.builder()
                .title("Pink Moon")
                .year(1972)
                .artist("Nick Drake")
                .genre("Folk")
                .build();
    }

    public static Album createTestAlbum3() {
        return Album.builder()
                .title("Disintegration")
                .year(1989)
                .artist("The Cure")
                .genre("Alternative Rock")
                .build();

    }
}
