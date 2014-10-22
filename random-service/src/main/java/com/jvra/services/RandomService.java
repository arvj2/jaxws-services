package com.jvra.services;

import javax.jws.WebService;
import java.util.Random;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/20/2014.
 */

@WebService(endpointInterface = "com.jvra.services.RandomInterface")
public class RandomService implements RandomInterface {

    private static final int MAX_RANDOM = 16;

    @Override
    public int next() {
        return new Random().nextInt(MAX_RANDOM);
    }

    @Override
    public int[] nextBulk(int m) {
        final int k = (0 < m) ? m : Math.abs(m);
        int[] a = new int[k];
        final Random random = new Random();
        for (int i = 0; k > i; ++i) {
            a[i] = random.nextInt(MAX_RANDOM);
        }
        return a;
    }
}
