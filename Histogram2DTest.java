package org.jlab.cnuphys.histogram;

/**
 * @author Erin Kirby
 * @version 061714
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class Histogram2DTest {

	@Test
	public void doesFillAddValuesCorrectly() {
		Histogram2D orig = new Histogram2D("Histo", 2, 0, 2, 2, 0, 2);
		double count = 1.0;
		for (double y = 0.5; y < 2; y += 1.0) {
			for (double x = 0.5; x < 2; x += 1.0) {
				orig.fill(x, y, count);
				count++;
			}
		}
		
		double[] actual = orig.offset();
		double[] expected = {1.0, 2.0, 3.0, 4.0};
		for (int i=0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}
	}

	
	@Test
	public void doesGetRegionReturnCorrectPiece() {
		Histogram2D orig = new Histogram2D("Histo", 2, 0, 2, 2, 0, 2);
		double count = 1.0;
		for (double y = 0.5; y < 2; y += 1.0) {
			for (double x = 0.5; x < 2; x += 1.0) {
				orig.fill(x, y, count);
				count++;
			}
		}
		
		
		Histogram2D slice = orig.getRegion("new slice", 0, 1, 0, 2);
		double[] actual = slice.offset();
		double[] expected = {1.0, 3.0};
		for (int i=0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}
	}
	
	@Test
	public void doesProjectionXReturnCorrectVal() {
		Histogram2D orig = new Histogram2D("Histo", 2, 0, 2, 2, 0, 2);
		double count = 1.0;
		for (double y = 0.5; y < 2; y += 1.0) {
			for (double x = 0.5; x < 2; x += 1.0) {
				orig.fill(x, y, count);
				count++;
			}
		}
		
		Histogram1D proj = orig.projectionX();
		double[] actual = proj.getData();
		double[] expected = {4.0, 6.0};
		
		for (int i=0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}
	}
	
	@Test
	public void doesProjectionYReturnCorrectVal() {
		Histogram2D orig = new Histogram2D("Histo", 2, 0, 2, 2, 0, 2);
		double count = 1.0;
		for (double y = 0.5; y < 2; y += 1.0) {
			for (double x = 0.5; x < 2; x += 1.0) {
				orig.fill(x, y, count);
				count++;
			}
		}
		
		Histogram1D proj = orig.projectionY();
		double[] actual = proj.getData();
		double[] expected = {3.0, 7.0};
		
		for (int i=0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}
	}
	
	@Test
	public void doesSliceXReturnCorrectVal() {
		Histogram2D orig = new Histogram2D("Histo", 2, 0, 2, 2, 0, 2);
		double count = 1.0;
		for (double y = 0.5; y < 2; y += 1.0) {
			for (double x = 0.5; x < 2; x += 1.0) {
				orig.fill(x, y, count);
				count++;
			}
		}
		
		Histogram1D slice = orig.sliceX(0);
		double[] actual = slice.getData();
		double[] expected = {1.0, 2.0};
		
		for (int i=0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}
	}
	
	@Test
	public void doesSliceYReturnCorrectVal() {
		Histogram2D orig = new Histogram2D("Histo", 2, 0, 2, 2, 0, 2);
		double count = 1.0;
		for (double y = 0.5; y < 2; y += 1.0) {
			for (double x = 0.5; x < 2; x += 1.0) {
				orig.fill(x, y, count);
				count++;
			}
		}
		
		Histogram1D slice = orig.sliceY(0);
		double[] actual = slice.getData();
		double[] expected = {1.0, 3.0};
		
		for (int i=0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}
	}
}
