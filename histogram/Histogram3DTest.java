package cnuphys.histogram;

import static org.junit.Assert.*;

import org.junit.Test;

public class Histogram3DTest {
	
	/**
	 * Checks if the fill method adds values correctly
	 */
	@Test
	public void doesFillAddValuesCorrectly() {
		Histogram3D orig = new Histogram3D("Histo", 2, 0, 4, 2, 0, 4, 2, 0, 4);
		double count = 1.0;
		for (int z = 0; z < 4; z += 3) {
			for (int y = 0; y < 4; y += 3) {
				for (int x = 0; x < 4; x += 3) {
					orig.fill(x, y, z, count);
					count++;
				}
			}
		}
		
		double[] actual = orig.offset();
		double[] expected = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
		for (int i=0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}
	}


	/**
	 * Does the getRegion method return the correct piece of the Histogram
	 */
	@Test
	public void doesGetRegionReturnCorrectPiece() {
		Histogram3D orig = new Histogram3D("Histo", 2, 0, 4, 2, 0, 4, 2, 0, 4);
		double count = 1.0;
		for (int z = 0; z < 4; z += 3) {
			for (int y = 0; y < 4; y += 3) {
				for (int x = 0; x < 4; x += 3) {
					orig.fill(x, y, z, count);
					count++;
				}
			}
		}
		
		Histogram3D slice = orig.getRegion("new slice", 0, 1, 0, 2, 0, 2);
		double[] expected = {1.0, 3.0, 5.0, 7.0};
		double[] actual = slice.offset();
		for (int i = 0; i < actual.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}	
	}
	
	@Test
	public void doesProjectionXYReturnCorrectVal() {
		Histogram3D orig = new Histogram3D("Histo", 2, 0, 4, 2, 0, 4, 2, 0, 4);
		double count = 1.0;
		for (int z = 0; z < 4; z += 3) {
			for (int y = 0; y < 4; y += 3) {
				for (int x = 0; x < 4; x += 3) {
					orig.fill(x, y, z, count);
					count++;
				}
			}
		}
		
		Histogram2D proj = orig.projectionXY();
		double[] expected = {6.0, 8.0, 10.0, 12.0};
		double[] actual = proj.offset();
		
		for (int i = 0; i < actual.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}	
	}
	
	@Test
	public void doesProjectionXZReturnCorrectVal() {
		Histogram3D orig = new Histogram3D("Histo", 2, 0, 4, 2, 0, 4, 2, 0, 4);
		double count = 1.0;
		for (int z = 0; z < 4; z += 3) {
			for (int y = 0; y < 4; y += 3) {
				for (int x = 0; x < 4; x += 3) {
					orig.fill(x, y, z, count);
					count++;
				}
			}
		}
		
		Histogram2D proj = orig.projectionXZ();
		double[] expected = {4.0, 6.0, 13.0, 14.0};
		double[] actual = proj.offset();
		
		for (int i = 0; i < actual.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}	
	}
	
	@Test
	public void doesProjectionYZReturnCorrectVal() {
		Histogram3D orig = new Histogram3D("Histo", 2, 0, 4, 2, 0, 4, 2, 0, 4);
		double count = 1.0;
		for (int z = 0; z < 4; z += 3) {
			for (int y = 0; y < 4; y += 3) {
				for (int x = 0; x < 4; x += 3) {
					orig.fill(x, y, z, count);
					count++;
				}
			}
		}
		
		Histogram2D proj = orig.projectionYZ();
		double[] expected = {3.0, 11.0, 7.0, 15.0};
		double[] actual = proj.offset();
		
		for (int i = 0; i < actual.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}	
	}
	
	@Test
	public void doesSliceXYReturnCorrectVal() {
		Histogram3D orig = new Histogram3D("Histo", 2, 0, 4, 2, 0, 4, 2, 0, 4);
		double count = 1.0;
		for (int z = 0; z < 4; z += 3) {
			for (int y = 0; y < 4; y += 3) {
				for (int x = 0; x < 4; x += 3) {
					orig.fill(x, y, z, count);
					count++;
				}
			}
		}
		
		Histogram2D slice = orig.sliceXY(0);
		double[] expected = {1.0, 2.0, 3.0, 4.0};
		double[] actual = slice.offset();
		
		for (int i = 0; i < actual.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}	
	}
	
	@Test
	public void doesSliceXZReturnCorrectVal() {
		Histogram3D orig = new Histogram3D("Histo", 2, 0, 4, 2, 0, 4, 2, 0, 4);
		double count = 1.0;
		for (int z = 0; z < 4; z += 3) {
			for (int y = 0; y < 4; y += 3) {
				for (int x = 0; x < 4; x += 3) {
					orig.fill(x, y, z, count);
					count++;
				}
			}
		}
		
		Histogram2D slice = orig.sliceXZ(0);
		double[] expected = {1.0, 2.0, 5.0, 6.0};
		double[] actual = slice.offset();
		
		for (int i = 0; i < actual.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}	
	}
	
	@Test
	public void doesSliceYZReturnCorrectVal() {
		Histogram3D orig = new Histogram3D("Histo", 2, 0, 4, 2, 0, 4, 2, 0, 4);
		double count = 1.0;
		for (int z = 0; z < 4; z += 3) {
			for (int y = 0; y < 4; y += 3) {
				for (int x = 0; x < 4; x += 3) {
					orig.fill(x, y, z, count);
					count++;
				}
			}
		}
		
		Histogram2D slice = orig.sliceYZ(0);
		double[] expected = {1.0, 3.0, 5.0, 7.0};
		double[] actual = slice.offset();
		
		for (int i = 0; i < actual.length; i++) {
			assertEquals(expected[i], actual[i], 0.0);
		}	
	}
}
