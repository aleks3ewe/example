package ru.rsreu.vkr.fann;

import com.googlecode.fannj.Fann;

public class BunkruptTest {
	
	public static int count(Fann fann, float k1, float k2, float extra1, float extra2) {
		int result = 1;
		float bunkrupt = 0.0f;
		
		float[][] tests = { { k1, k2, extra1, extra2 }, };
		for (float[] test : tests) {
			bunkrupt = fann.run(test)[0];
		}

		if (bunkrupt >= 0.5) {
			result = 1;
		}
		if (bunkrupt < 0.5) {
			result = 0;
		}

		return result;
	}
}