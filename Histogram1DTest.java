package org.jlab.cnuphys.histogram;

/**
 * @author Erin Kirby
 * @version 062514
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class Histogram1DTest {

	@Test
	public void doVariableBinWidthsWorkAsExpected() {
		Histogram1D test = new Histogram1D("","",0.0, 10.0);
		test.incrementBinContent(0, 100);
		test.incrementBinContent(1, 1);
		test.incrementBinContent(2, 2);
		test.incrementBinContent(3, 7);
		test.incrementBinContent(4, 35);
		test.incrementBinContent(5, 45);
		test.incrementBinContent(6, 10);
		test.incrementBinContent(7, 11);
		test.incrementBinContent(8, 20);
		test.incrementBinContent(9, 35);
		test.fixBinWidths(.05);
		double[] expected = {100, 10, 35, 86, 35};
		double[] actual = test.getData();
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}
	}

}
