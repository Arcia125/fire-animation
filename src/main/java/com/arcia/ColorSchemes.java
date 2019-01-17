package com.arcia;

import java.awt.Color;
import java.util.stream.Stream;

/**
 * ColorSchemes
 */
public class ColorSchemes {

        static final Color[] CLASSIC = { new Color(0, 0, 0), new Color(10, 10, 15), new Color(20, 20, 30),
                        new Color(22, 22, 32), new Color(25, 25, 34), new Color(34, 34, 40), new Color(45, 45, 75),
                        new Color(72, 61, 80), new Color(72, 61, 85), new Color(230, 115, 80), new Color(255, 115, 70),
                        new Color(251, 98, 60), new Color(255, 99, 50), new Color(230, 230, 20),
                        new Color(255, 215, 20), new Color(255, 255, 20), new Color(255, 255, 185) };

        static final Color[] HOT_SMOKE = { new Color(0, 0, 0), new Color(25, 10, 15), new Color(45, 20, 30),
                        new Color(55, 22, 32), new Color(65, 25, 34), new Color(75, 34, 40), new Color(95, 45, 75),
                        new Color(105, 61, 80), new Color(110, 61, 85), new Color(230, 115, 80),
                        new Color(255, 115, 70), new Color(251, 98, 60), new Color(255, 99, 50),
                        new Color(230, 230, 20), new Color(255, 215, 20), new Color(255, 255, 20),
                        new Color(255, 255, 240) };

        static final Color[] HOT = { new Color(0, 0, 0), new Color(10, 10, 15), new Color(20, 20, 30),
                        new Color(22, 22, 32), new Color(25, 25, 34), new Color(34, 34, 40), new Color(45, 45, 75),
                        new Color(72, 61, 80), new Color(72, 61, 85), new Color(230, 115, 80), new Color(255, 115, 70),
                        new Color(251, 98, 60), new Color(255, 99, 50), new Color(255, 175, 90),
                        new Color(255, 75, 50) };

        static final Color[] HOT2 = { new Color(0, 0, 0), new Color(72, 61, 120), new Color(72, 61, 120),
                        new Color(72, 61, 90), new Color(255, 75, 50), new Color(255, 75, 50), new Color(255, 75, 50),
                        new Color(255, 175, 0) };

        static final Color[] HOT3 = { new Color(0, 0, 0), new Color(30, 30, 40), new Color(30, 30, 40),
                        new Color(30, 30, 40), new Color(30, 30, 40), new Color(30, 30, 40), new Color(255, 75, 50),
                        new Color(255, 75, 50), new Color(255, 75, 50), new Color(255, 175, 0),
                        new Color(255, 225, 0) };

        static final Color[] BLUE = { new Color(0, 0, 0), new Color(20, 20, 40), new Color(0, 30, 90),
                        new Color(0, 40, 110), new Color(0, 50, 130), new Color(0, 60, 150), new Color(0, 70, 170),
                        new Color(0, 80, 190), new Color(0, 90, 210), new Color(0, 100, 230), new Color(0, 110, 240),
                        new Color(0, 120, 255), new Color(20, 140, 255), new Color(140, 220, 255),
                        new Color(180, 230, 255), new Color(225, 245, 255), new Color(235, 250, 255) };

        static final Color[] GREEN = { new Color(0, 0, 0), new Color(10, 10, 10), new Color(10, 10, 10),
                        new Color(25, 25, 34), new Color(34, 34, 40), new Color(72, 61, 95), new Color(72, 61, 95),
                        new Color(0, 115, 80), new Color(0, 115, 70), new Color(0, 98, 60), new Color(0, 99, 50),
                        new Color(0, 230, 20), new Color(0, 215, 20), new Color(0, 255, 20), new Color(0, 255, 20),
                        new Color(0, 255, 240) };

        static final Color[] RAINBOW = { new Color(0, 0, 0), new Color(50, 10, 125), new Color(100, 20, 255),
                        new Color(50, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 125, 125),
                        new Color(0, 255, 0), new Color(0, 255, 0), new Color(125, 255, 0), new Color(255, 255, 0),
                        new Color(255, 255, 0), new Color(255, 175, 35), new Color(255, 99, 71), new Color(255, 99, 71),
                        new Color(255, 50, 35), new Color(255, 0, 0), new Color(255, 0, 0) };

        static final Color[] MULTI = { new Color(0, 0, 0), new Color(10, 10, 10), new Color(10, 10, 10),
                        new Color(25, 25, 34), new Color(34, 34, 40), new Color(72, 61, 95), new Color(72, 61, 95),
                        new Color(230, 115, 80), new Color(255, 115, 70), new Color(251, 98, 60),
                        new Color(255, 99, 50), new Color(230, 230, 20), new Color(255, 215, 20),
                        new Color(255, 255, 20), new Color(255, 255, 20), new Color(255, 255, 240),
                        new Color(0, 120, 255), new Color(20, 140, 255), new Color(140, 220, 255),
                        new Color(180, 230, 255), new Color(0, 230, 20), new Color(0, 215, 20), new Color(0, 255, 20),
                        new Color(0, 255, 20), new Color(0, 255, 240), new Color(100, 20, 255), new Color(50, 0, 255),
                        new Color(0, 0, 255), new Color(0, 255, 0), new Color(255, 255, 0), new Color(255, 99, 71),
                        new Color(255, 0, 0) };

        static final Color[] PURPLE = { new Color(0, 0, 0), new Color(63, 0, 175), new Color(127, 0, 255),
                        new Color(127, 0, 255), new Color(200, 162, 200), new Color(200, 0, 200),
                        new Color(175, 175, 255) };

        static final Color[] GREYSCALE = { new Color(0, 0, 0), new Color(10, 10, 10), new Color(20, 20, 20),
                        new Color(30, 30, 30), new Color(40, 40, 40), new Color(50, 50, 50), new Color(60, 60, 60),
                        new Color(70, 70, 70), new Color(80, 80, 80), new Color(90, 90, 90), new Color(100, 100, 100),
                        new Color(110, 110, 110) };

        static final Color[] GREYSCALE2 = { new Color(0, 0, 0), new Color(10, 10, 10), new Color(20, 20, 20),
                        new Color(30, 30, 30), new Color(40, 40, 40), new Color(60, 60, 60), new Color(80, 80, 80),
                        new Color(110, 110, 110), new Color(175, 175, 175), new Color(220, 220, 220) };

        public static Color[] concat(Color[] a, Color[] b) {
                return Stream.of(a, b).flatMap(Stream::of).toArray(Color[]::new);
        }
}